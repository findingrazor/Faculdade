import java.util.*;
public class Exercicio8_3 {
	
	static String vetCidades[] = {"BELO HORIZONTE", "SÃO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"};

	public static void main(String[] args) {
		// 1 - variaveis
		String nomeHospede[] = new String[100];
		byte diaEntrada, diaSaida;
		String tipoQuarto;
		String cidade;
		byte contHosp = 0;
		float vlrConta[] = new float[100];
		float somaContas = 0;
		boolean encontrou;
		float mediaContas;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (contHosp = 0; contHosp <= 100; contHosp++) {
			System.out.print("Digite o nome do Hóspede (FIM para encerrar a digitação): ");
			nomeHospede[contHosp] = leia.nextLine();
			
			if (nomeHospede[contHosp].equalsIgnoreCase("FIM")) {
				break;
			}
			
			System.out.print("Digite o dia de entrada (check-in): ");
			diaEntrada = leia.nextByte();
			
			do {
				System.out.print("Digite o dia de saida (check-out): ");
				diaSaida = leia.nextByte();
				
				if (diaSaida <= diaEntrada) {
					System.out.println("O dia (número) do check-out deve ser maior que o dia do check-in!");
				}
			} while (diaSaida <= diaEntrada);
			
			leia.nextLine();
			
			do {
				System.out.print("Digite o tipo de quarto: ");
				tipoQuarto = leia.nextLine();
				
				if (!tipoQuarto.equalsIgnoreCase("STANDARD") && !tipoQuarto.equalsIgnoreCase("LUXO") && !tipoQuarto.equalsIgnoreCase("SUPER-LUXO"));
				System.out.println("Tipo de quarto inexistente, por favor, digite standard, luxo ou super-luxo para escolher um tipo de quarto!");
				
			} while (!tipoQuarto.equalsIgnoreCase("STANDARD") && !tipoQuarto.equalsIgnoreCase("LUXO") && !tipoQuarto.equalsIgnoreCase("SUPER-LUXO"));
			
			do {
				System.out.print("Digite o nome da cidade: ");
				cidade = leia.nextLine();
				encontrou = cidadeEhValida(cidade);
				if (!encontrou) {
					System.out.println("Não há hotéis disponíveis nesta cidade");
				}
			} while (!encontrou);
			
			// 3 - calculos
			vlrConta[contHosp] = calcularConta(diaEntrada, diaSaida, tipoQuarto);
			somaContas = somaContas + vlrConta[contHosp];
			System.out.println("Valor da conta: " + vlrConta[contHosp]);
			
			leia.nextLine();
		}
		
		mediaContas = somaContas / contHosp;
		
		// 4 - saida de dados
		System.out.println("RELATÓRIO DE CONTAS ACIMA DA MÉDIA");
		System.out.println("Nome do Hóspede             Valor da conta");
		System.out.println("------------------------------------------");
		for (byte x = 0; x < contHosp; x++) {
			if (vlrConta[x] > mediaContas) {
				System.out.println(nomeHospede[contHosp] + "               " + vlrConta[contHosp]);
			}
		}
		
	}
	
	// 5 - metodos
	public static float calcularConta (byte entrada, byte saida, String quarto) {
		float calculo;
		float vlrDiaria;
		
		if (quarto.equalsIgnoreCase("STANDARD")) {
			vlrDiaria = 120;
		} else if (quarto.equalsIgnoreCase("LUXO")) {
			vlrDiaria = 150;
		} else {
			vlrDiaria = 180;
		}
		calculo = (entrada - saida) * vlrDiaria; 
		
		return calculo;
	}
	
	public static boolean cidadeEhValida (String cidade) {
		boolean validade = false;
		
		for (byte x = 0; x <= 4; x++) {
			if (cidade.equalsIgnoreCase(vetCidades[x])) {
				validade = true;
				break;
			}
		}
		return validade;
	}
}
