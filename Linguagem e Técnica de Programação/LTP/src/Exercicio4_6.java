import java.util.*;
public class Exercicio4_6 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		String nomePassageiro;
		byte numeroVoo;
		byte quantPassagens;
		byte contPassageiros = 0;
		float vlrDaPassagem;
		float vlrArrecadadoVoo1 = 0;
		float vlrArrecadadoVoo2 = 0;
		float vlrArrecadadoVoo3 = 0;
		byte contPassageirosVoo1 = 0;
		byte contPassageirosVoo2 = 0;
		byte contPassageirosVoo3 = 0;
		float vlrPassagemMaisBarata = 200;
		byte numeroVooPassMaisBarata = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		do {
			System.out.print("Digite o nome do passageiro (digite FIM para encerrar a digitação): ");
			nomePassageiro = leia.nextLine();
			if (nomePassageiro.equals("FIM")) {
				break;
			}
			do {
				System.out.print("Digite o número do voo (1, 2 ou 3): ");
				numeroVoo = leia.nextByte(); 
				if (numeroVoo != 1 && numeroVoo != 2 && numeroVoo != 3) {
					System.out.println("Voo inexistente, digite 1, 2 ou 3 para escolher o voo! ");
				}
			} while (numeroVoo != 1 && numeroVoo != 2 && numeroVoo != 3);
			
			System.out.print("Digite o número de passagens que foram compradas: ");
			quantPassagens = leia.nextByte();
			contPassageiros = (byte) (contPassageiros + quantPassagens);
			
			// 3 - calculos
			if (numeroVoo == 1){
				contPassageirosVoo1 = (byte) (contPassageirosVoo1 + quantPassagens);
				
				if (contPassageiros < 50) {
					vlrArrecadadoVoo1 = vlrArrecadadoVoo1 + quantPassagens * 100;
					vlrDaPassagem = 100;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else if (contPassageiros <= 69) {
					vlrArrecadadoVoo1 = vlrArrecadadoVoo1 + quantPassagens * (100 * 0.3f);
					vlrDaPassagem = 100 * 0.3f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else {
					vlrArrecadadoVoo1 = vlrArrecadadoVoo1 + quantPassagens * (100 * 0.6f);
					vlrDaPassagem = 100 * 0.6f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				}
				
			} else if (numeroVoo == 2) {
				contPassageirosVoo2 = (byte) (contPassageirosVoo2 + quantPassagens);
				
				if (contPassageiros < 50) {
					vlrArrecadadoVoo2 = vlrArrecadadoVoo2 + quantPassagens * 150;
					vlrDaPassagem = 150;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else if (contPassageiros <= 69) {
					vlrArrecadadoVoo2 = vlrArrecadadoVoo2 + quantPassagens * (150 * 0.3f);
					vlrDaPassagem = 150 * 0.3f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else {
					vlrArrecadadoVoo2 = vlrArrecadadoVoo2 + quantPassagens * (150 * 0.6f);
					vlrDaPassagem = 150 * 0.6f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				}
				
			} else {
				contPassageirosVoo3 = (byte) (contPassageirosVoo3 + quantPassagens);
				
				if (contPassageiros < 50) {
					vlrArrecadadoVoo3 = vlrArrecadadoVoo3 + quantPassagens * 200;
					vlrDaPassagem = 200;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else if (contPassageiros <= 69) {
					vlrArrecadadoVoo3 = vlrArrecadadoVoo3 + quantPassagens * (200 * 0.3f);
					vlrDaPassagem = 200 * 0.3f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				} else {
					vlrArrecadadoVoo3 = vlrArrecadadoVoo3 + quantPassagens * (200 * 0.6f);
					vlrDaPassagem = 200 * 0.6f;
					System.out.println("Valor da passagem: " + vlrDaPassagem);
				}
			}
			
			if (vlrDaPassagem < vlrPassagemMaisBarata) {
				vlrPassagemMaisBarata = vlrDaPassagem;
				numeroVooPassMaisBarata = numeroVoo;
			}
			
		} while (!nomePassageiro.equals("FIM"));
		
		// 4 - saida de dados
		if (vlrArrecadadoVoo1 > vlrArrecadadoVoo2 && vlrArrecadadoVoo1 > vlrArrecadadoVoo3) {
			System.out.println("O voo 1 foi o que mais arrecadou dinheiro, arrecadando: " + vlrArrecadadoVoo1);
		} else if (vlrArrecadadoVoo2 > vlrArrecadadoVoo1 && vlrArrecadadoVoo2 > vlrArrecadadoVoo3) {
			System.out.println("O voo 2 foi o que mais arrecadou dinheiro, arrecadando: " + vlrArrecadadoVoo2);
		} else {
			System.out.println("O voo 3 foi o que mais arrecadou dinheiro, arrecadando: " + vlrArrecadadoVoo3);
		}
		
		System.out.println("Média de arrecadação: " + (vlrArrecadadoVoo1 + vlrArrecadadoVoo2 + vlrArrecadadoVoo3) / 3);
		System.out.println("O valor da passagem mais barata: " + vlrPassagemMaisBarata + "Número do voo: " + numeroVooPassMaisBarata);
	}

}