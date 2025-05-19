import java.util.*;
import java.io.*;
public class Exercicio11_2A {
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
		char confirmacao;
		long posicaoRegistro = 0;
		byte opcao;
		
		do {
			do {
				System.out.println(" ****************** ALTERAÇÃO DE ALUNOS ****************** ");
				System.out.print("Digite o código do cliente (FIM para encerrar): ");
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
					System.out.println("Este código de cliente não foi encontrado no arqueivo! \n");
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
			} while (! encontrou);

			if (codigoChave.equalsIgnoreCase("FIM")) {
				System.out.println("\n ***************** PROGRAMA ENCERRADO ***************** \n");
				break;
			}

			cliente.ativo = 'S';
			cliente.codCliente = codigoChave;

			do {
				System.out.println("[ 1 ] Nome do cliente...............: " + cliente.nomeCliente);
				System.out.println("[ 2 ] Valor da compra...............: " + cliente.vlrCompra);
				System.out.println("[ 3 ] Ano da primeira compra........: " + cliente.anoPrimeiraCompra);
				if (cliente.emDia = true) {
					System.out.println("[ 4 ] Condição de pagamento.........: " + cliente.emDia);
				}
				

				do {
					System.out.print("Digite o número do campo que deseja alterar (0 para finalizar as alterações): ");
					opcao = leia.nextByte();
				} while (opcao < 0 || opcao > 4);

				switch (opcao) {
				case 1:
					leia.nextLine();
					System.out.println("Digite o NOVO NOME do cliente.....................: ");
					cliente.nomeCliente = leia.nextLine();
					break;
				case 2:
					leia.nextLine();
					System.out.println("Digite o NOVO VALOR da compra.....................: ");
					cliente.vlrCompra = leia.nextFloat();
					break;
				case 3:
					leia.nextLine();
					System.out.println("Digite o NOVO ANO da primeira compra..............: ");
					cliente.anoPrimeiraCompra = leia.nextInt();
					break;
				case 4:
					leia.nextLine();
					System.out.println("Digite a NOVA CONDIÇÃO de pagamento...............: ");
					cliente.emDia = leia.nextBoolean();
					break;
				}
				System.out.println();
			} while (opcao != 0);
			
			do {
				System.out.print("Confirma as alterações (S/N) ?");
				confirmacao = leia.next().charAt(0);
				if (confirmacao == 'S') {
					try {
						arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
						arquivo.seek(posicaoRegistro);
						arquivo.writeChar('N');
						arquivo.seek(arquivo.length());
						arquivo.writeChar(cliente.ativo );
						arquivo.writeUTF(cliente.codCliente);
						arquivo.writeUTF(cliente.nomeCliente);
						arquivo.writeFloat(cliente.vlrCompra);
						arquivo.writeInt(cliente.anoPrimeiraCompra);
						arquivo.writeBoolean(cliente.emDia);
						arquivo.close();
						System.out.println("Dados alterados com sucesso! \n");
					} catch (IOException e) {
						System.out.println("Erro na gravação do registro - programa será finalizado");
						System.exit(0);
					}
				}
				System.out.println();
			} while (confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while (!cliente.codCliente.equalsIgnoreCase("FIM"));
		
		leia.close();

	}

}
