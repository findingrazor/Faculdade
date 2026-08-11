import java.util.*;
public class Exercicio6_1 {

	public static void main(String[] args) {
		// 1 - variaveis
		String reservas [][] = new String [20][6];
		String nome;
		byte fileira = 0;
		byte cadeira = 0;
		float precoPassagem;
		float somaPrecos = 0;
		float somaPreços1Classe = 0;
		byte contAssentosVagos = 40;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados	
		do {
			System.out.print("Digite o nome do passageiro (digite FIM para encerrar): ");
			nome = leia.nextLine();
			
			if (nome.equals("FIM")) {
				break;
			}
			
			do {
				System.out.print("Digite a fileira: ");
				fileira = leia.nextByte();
				if (fileira < 1 || fileira > 20) {
					System.out.println("Fileira inexistente, digite um número de 1 a 20");
				}
			} while (fileira < 1 || fileira > 20);
			
			do {
				System.out.print("Digite a cadeira: ");
				cadeira = leia.nextByte();
				if (cadeira < 1 || cadeira > 6) {
					System.out.println("Cadeira inexistente, digite um número de 1 a 6");
				}
			} while (cadeira < 1 || cadeira > 6);
			
			reservas[fileira - 1][cadeira - 1] = nome;
			
			// 3 - calculos
			if (fileira <= 3) {
				precoPassagem = 900;
				somaPreços1Classe = precoPassagem + somaPreços1Classe;
			} else if (fileira <= 8) {
				precoPassagem = 700;
			} else {
				precoPassagem = 350;
			}
			
			if (cadeira == 1 || cadeira == 6) {
				contAssentosVagos --;
			}
			
			somaPrecos = somaPrecos + precoPassagem;
			
			System.out.println("Preço da passagem: " + precoPassagem);
			
			leia.nextLine();
		} while (!nome.equals("FIM")); 
		
		// 4 saida de dados
		System.out.println("Total faturado no voo: " + somaPrecos);
		System.out.println("Total faturado na primeira classe: " + somaPreços1Classe);
		System.out.println("Quantidade de assentos vagos na janela: " + contAssentosVagos);
		System.out.println("MAPA DE VOO");
		System.out.println("        1                 2                  3                   4               5               6              ");
		for (byte linha = 0; linha <= 19; linha ++) {
			System.out.print("linha " + 1 + "  ");
			for (byte coluna = 0; coluna <= 5; coluna ++) {
				if (reservas[fileira][cadeira] == null) {
					System.out.print("     X     ");
				} else {
					System.out.print(reservas[fileira][cadeira] + "     ");
				}
			}
			System.out.println();
		}
		
			
		
	

	}

}
