import java.util.*;
import java.io.*;
public class Exercicio11_2E {
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
		char confirmacao;
		
		do {
			do {
				System.out.println(" ***************** EXCLUSÃO DE CLIENTES ***************** ");
				System.out.println("Digite o código do cliente para excluir (FIM para encerrar): ");
				codigoChave = leia.nextLine();
				
				if (codigoChave.equalsIgnoreCase("FIM")) {
					break;
				}
				
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
						if (codigoChave.equals(cliente.codCliente) && cliente.ativo == 'S') {
							encontrou = true;
							break;
						}
					}
					arquivo.close();
				} catch (EOFException e) {
					encontrou = false;
					System.out.println("Este código não foi encontrado no arquivo \n");
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
			} while (!encontrou);
			
			if (codigoChave.equalsIgnoreCase("FIM")) {
				System.out.println("\n ******************* PROGRAMA ENCERRADO ******************* \n");
				break;
			}
			cliente.ativo = 'N';
			System.out.println("Nome do cliente...............: " + cliente.nomeCliente);
			System.out.println("Valor da compra...............: " + cliente.vlrCompra);
			System.out.println("Ano da primeira compra........: " + cliente.anoPrimeiraCompra);
			if (cliente.emDia = true) {
				System.out.println("Condição de pagamento.........: S ");
			} else {
				System.out.println("Condição de pagamento.........: N ");
			}
			System.out.println();
			
			do {
				System.out.print("\n Confirma a exclusão deste cliente (S/N)? ");
				confirmacao = leia.next().charAt(0);
				if (confirmacao == 'S') {
					try {
						arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
						arquivo.seek(posicaoRegistro);
						arquivo.writeChar(cliente.ativo);
						arquivo.close();
						System.out.println("Cliente excluído com sucesso! \n");
					} catch (IOException e) {
						System.out.println("Erro na gravação do arquivo - programa será finalizado");
						System.exit(0);
					}
				}
			} while (confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while (! cliente.codCliente.equalsIgnoreCase("FIM"));
		leia.close();
	}

}