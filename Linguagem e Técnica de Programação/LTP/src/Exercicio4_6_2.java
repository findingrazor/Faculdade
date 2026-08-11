import java.util.*;
public class Exercicio4_6_2 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		byte numeroVoo;
		byte quantPassagens;
		float precoPassagem;
		float vlrArrecadado = 0;
		float maiorArrecadacao = 0;
		byte vooMaiorArrecadacao = 0;
		float somaArrecadacao = 0;
		float menorPrecoPassagem = 200;
		byte vooMenorPrecoPassagem = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (byte cont = 1; cont <= 3; cont++) {
			do {
				System.out.print("Digite o número do voo: ");
				numeroVoo = leia.nextByte();
				if (numeroVoo < 1 || numeroVoo > 3) {
					System.out.println("Número de voo invalido, digite 1, 2 ou 3! ");
				}
			} while (numeroVoo < 1 || numeroVoo > 3);
			
			do {
				System.out.print("Digite a quantidade de passagens vendidas: ");
				quantPassagens = leia.nextByte();
				if (quantPassagens < 0 || quantPassagens > 100) {
					System.out.println("Quantidade de passagens invalida, digite um número entre 0 e 100! ");
				}
			} while (quantPassagens < 0 || quantPassagens > 100);
			
			// 3 - calculos 
			if (numeroVoo == 1) {
				precoPassagem = 100;
			} else if (numeroVoo == 2) {
				precoPassagem = 150;
			} else {
				precoPassagem = 200;
			}
			
			if (quantPassagens >= 70) {
				precoPassagem = precoPassagem - (float)0.6 * precoPassagem;
			} else if (quantPassagens >= 50) {
				precoPassagem = precoPassagem - (float)0.3 * precoPassagem;
			} 
			
			vlrArrecadado = precoPassagem * quantPassagens;
			if (vlrArrecadado > maiorArrecadacao) {
				maiorArrecadacao = vlrArrecadado;
				vooMaiorArrecadacao = numeroVoo;
			}
			
			somaArrecadacao = somaArrecadacao + vlrArrecadado;
			if (precoPassagem < menorPrecoPassagem) {
				menorPrecoPassagem = precoPassagem;
				vooMenorPrecoPassagem = numeroVoo;
			}
			
			System.out.println("Preço da passagem: " + precoPassagem);
		}
		
		// 4 - saida de dados
		System.out.println("Maior valor arrecadado: " + maiorArrecadacao);
		System.out.println("Número do voo de maior valor arrecadado: " + vooMaiorArrecadacao);
		System.out.println("Média de arrecadação: " + somaArrecadacao / 3);
		System.out.println("Passagem de preço mais barato: " + menorPrecoPassagem);
		System.out.println("Número do voo de preço mais barato: " + vooMenorPrecoPassagem);
	}

}
