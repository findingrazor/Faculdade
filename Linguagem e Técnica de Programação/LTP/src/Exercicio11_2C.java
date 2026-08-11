import java.util.*;
import java.io.*;
public class Exercicio11_2C {
	public static class Cliente {
		public char ativo;
		public String codCliente;
		public String nomeCliente;
		public float vlrCompra;
		public int anoPrimeiraCompra;
		public boolean emDia;
	}
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		RandomAccessFile arquivo;
		Scanner leia = new Scanner(System.in);
		boolean encontrou;
		String codigoChave;
		char emDiaChar;
		long posicaoRegistro = 0;
		byte opcao; 
		
		do {
			System.out.println(" ******************* CONSULTA DE CLIENTES *******************");
			System.out.println(" [ 1 ] CONSULTAR APENAS 1 CLIENTE ");
			System.out.println(" [ 2 ] LISTA DE TODOS OS CLIENTES ");
			System.out.println(" [ 0 ] LISTA DE PAGAMENTOS EM DIA OU ATRASADOS ");
			System.out.println(" [ 3 ] CONSULTAR APENAS 1 ALUNO ");
			
			do {
				System.out.println("\n Digite a opção desejada: ");
				opcao = leia.nextByte();
				if (opcao < 0 || opcao > 3) {
					System.out.println("Opção inválida, digite novamente \n");
				}
			}while (opcao < 0 || opcao > 3);
			
			switch (opcao) {
			case 0:
				System.out.println("\n ******************* PROGRAMA ENCERRADO ******************* \n");
				break;
				
			case 1:
				leia.nextLine();
				System.out.print("Digite o código do cliente: ");
				codigoChave = leia.nextLine();
				encontrou = false;
				
				try {
					arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
					while (true) {
						posicaoRegistro = arquivo.getFilePointer();
						cliente.ativo = arquivo.readChar();
						cliente.codCliente = arquivo.readUTF();
						cliente.nomeCliente = arquivo.readUTF();
						cliente.vlrCompra = arquivo.readFloat();
						cliente.anoPrimeiraCompra = arquivo.readInt();
						cliente.emDia = arquivo.readBoolean();
						
						if ( codigoChave.equals(cliente.codCliente) && cliente.ativo == 'S') {
							encontrou = true;
							imprimirCabecalho();
							imprimirCliente(cliente);
							System.out.println("\n FIM DO RELATÓRIO - ENTER para continuar... \n");
							leia.nextLine();
							break;
						}
					}
					arquivo.close();
				}catch (EOFException e) {
					encontrou = false;
					System.out.println("Este código não foi encontrado no arquivo \n");
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				} 
			break;

			case 2:
				try {
					arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
					imprimirCabecalho();
					while (true) {
						cliente.ativo = arquivo.readChar();
						cliente.codCliente = arquivo.readUTF();
						cliente.nomeCliente = arquivo.readUTF();
						cliente.vlrCompra = arquivo.readFloat();
						cliente.anoPrimeiraCompra = arquivo.readInt();
						cliente.emDia = arquivo.readBoolean();
						if (cliente.ativo == 'S') {
							imprimirCliente(cliente);
						}
					}
				} catch (EOFException e) {
					encontrou = false;
					System.out.println("Este código não foi encontrado no arquivo \n");
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				} 
				break;

			case 3:
				do {
					System.out.print("Digite a condição de pagamento desejada (S/N): ");
					emDiaChar = leia.next().charAt(0);
					if (emDiaChar != 'S' && emDiaChar != 'N') {
						System.out.println("Condição inválida, digite S ou N");
					}
				} while (emDiaChar != 'S' && emDiaChar != 'N');

				try {
					arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
					imprimirCabecalho();
					while (true) {
						cliente.ativo = arquivo.readChar();
						cliente.codCliente = arquivo.readUTF();
						cliente.nomeCliente = arquivo.readUTF();
						cliente.vlrCompra = arquivo.readFloat();
						cliente.anoPrimeiraCompra = arquivo.readInt();
						cliente.emDia = arquivo.readBoolean();
						if (emDiaChar == 'S') {
							if (cliente.emDia = true && cliente.ativo == 'S') {
								imprimirCliente(cliente);
							}
						} else {
							if (cliente.emDia = true && cliente.ativo == 'S') {
								imprimirCliente(cliente);
							}	
						}
					}
				} catch (EOFException e) {
					System.out.println("\n FIM DO RELATÓRIO - ENTER para continuar... \n");
					leia.nextLine();
					codigoChave = leia.nextLine();
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				} 
			} 
		} while(opcao != 0);
	}


	public static void imprimirCabecalho () {
		System.out.println("-CÓDIGO- --------- NOME CLIENTE -------- --VALOR COMPRA-- -PRIMEIRA "
				+ "COMPRA- -EM DIA?- ");
	}
	
	public static void imprimirCliente (Cliente cliente) {
		char emDiaAux;
		System.out.println(formatarString(cliente.codCliente, 11) + "  "
				+ formatarString(cliente.nomeCliente, 30) + "  "
				+ formatarString(String.valueOf(cliente.anoPrimeiraCompra), 13) + "  "
				+ formatarString( String.valueOf(cliente.vlrCompra), 13) + "  ");
		if (cliente.emDia = true) {
			emDiaAux = 'S';
			System.out.println(formatarString(Character.toString(emDiaAux), 6));
		} else {
			emDiaAux = 'N';
			System.out.println(formatarString(Character.toString(emDiaAux), 6));
		}
	}
	
	public static String formatarString (String texto, int tamanho) {
		if (texto.length() > tamanho) {
			texto = texto.substring(0, tamanho);
		} else {
			while (texto.length() < tamanho) {
				texto = texto + " ";
			}
		}
		return texto;
	}
}
