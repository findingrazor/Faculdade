import java.util.*;
import java.io.*;
public class Exercicio11_1 {
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
		char emDiaChar;
		boolean encontrou;
		String codigoChave;
		char confirmacao;
		
		do {
			do {
				System.out.println(" *************** INCLUSÃO DE CLIENTES *************** ");
					System.out.print("Digite o códidgo do cliente (FIM para encerrar): ");
					codigoChave = leia.nextLine();
					
				if (codigoChave.equalsIgnoreCase("FIM")) {
					break;
				}
				encontrou = false;
				
				try {
					arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
					while (true) {
						cliente.ativo = arquivo.readChar();
						cliente.codCliente = arquivo.readUTF();
						cliente.nomeCliente = arquivo.readUTF();
						cliente.vlrCompra = arquivo.readFloat();
						cliente.anoPrimeiraCompra = arquivo.readInt();
						cliente.emDia = arquivo.readBoolean();
						
						if (codigoChave.equals(cliente.codCliente) && cliente.ativo == 'S') {
							System.out.println("Cliente já cadastrado, digite outro número\n");
							encontrou = true;
							break;
						}
					}
					arquivo.close();
				} catch (EOFException e) {
					encontrou = false;
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
			} while (encontrou);
			
			if (codigoChave.equalsIgnoreCase("FIM")) {
				System.out.println("\n ***************** PROGRAMA ENCERRADO ***************** \n");
				break;
			}
			
			cliente.ativo = 'S';
			cliente.codCliente = codigoChave;
			do {
				System.out.print("Digite o nome do cliente.........................: ");
				cliente.nomeCliente = leia.nextLine();
				
				if (cliente.nomeCliente.length() < 10) {
					System.out.println("Nome inválido, o nome deve conter no mínimo 10 caracteres!");
				}
			} while (cliente.nomeCliente.length() < 10);
			do {
				System.out.print("Digite o valor da compra.........................: ");
				cliente.vlrCompra = leia.nextFloat();
				
				if (cliente.vlrCompra <= 0) {
					System.out.println("Valor inválido, a compra deve ter um valor maior que zero! ");
				}
			} while (cliente.vlrCompra <= 0);
			do {
				System.out.print("Digite o ano da primeira compra..................: ");
				cliente.anoPrimeiraCompra = leia.nextInt();
				
				if (cliente.anoPrimeiraCompra > 2013) {
					System.out.println("Ano inválido, o ano da primeira compra deve ser menor ou igual a 2013!");
				}
			} while (cliente.anoPrimeiraCompra > 2013);
			System.out.print("O pagamento está em dia (S/N)?.......................: ");
			emDiaChar = leia.next().charAt(0);
			if (emDiaChar == 'S') {
				cliente.emDia = true;
			} else {
				cliente.emDia = false;
			}
			
			do {
				System.out.print("\n Confirma a gravação dos dados (S/N)? ");
				confirmacao = leia.next().charAt(0);
				
				if (confirmacao == 'S') {
					try {
						arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
						arquivo.seek(arquivo.length());
						arquivo.writeChar(cliente.ativo );
						arquivo.writeUTF(cliente.codCliente);
						arquivo.writeUTF(cliente.nomeCliente);
						arquivo.writeFloat(cliente.vlrCompra);
						arquivo.writeInt(cliente.anoPrimeiraCompra);
						arquivo.writeBoolean(cliente.emDia);
						arquivo.close();
						System.out.println("Dados gravados com sucesso !\n");
					} catch (IOException e) {
						System.out.println("Erro na grvação do registro - programa será finalizado");
						System.exit(0);
					}
				}
			} while (confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while (!cliente.codCliente.equalsIgnoreCase("FIM"));

	}

}
