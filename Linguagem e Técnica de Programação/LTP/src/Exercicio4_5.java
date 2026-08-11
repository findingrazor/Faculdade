import java.util.*;
public class Exercicio4_5 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		String escolha1;
		String escolha2;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		do {
			System.out.print("Digite a jogada do jogador 1: ");
			escolha1 = leia.nextLine();
						
			System.out.print("Digite a jogada do jogador 2: ");
			escolha2 = leia.nextLine();
			
			if (!escolha1.equals("pedra") && !escolha1.equals("papel") && !escolha1.equals("tesoura")) {
				System.out.println("Jogo terminado! ");
				break;					
			}
			
			// 3 - calculos
			if (escolha1.equals("pedra") && escolha2.equals("tesoura")) {
				System.out.println("O jogador 1 venceu! ");
			} else if (escolha1.equals("tesoura") && escolha2.equals("papel")) {
				System.out.println("O jogador 1 venceu! ");
			} else if (escolha1.equals("papel") && escolha2.equals("pedra")) {
				System.out.println("O jogador 1 venceu! ");
			} else if (escolha2.equals("pedra") && escolha1.equals("tesoura")) {
				System.out.println("O jogador 2 venceu! ");
			} else if (escolha2.equals("tesoura")  && escolha1.equals("papel")) {
				System.out.println("O jogador 2 venceu! ");
			} else if (escolha2.equals("papel")  && escolha1.equals("pedra")){
				System.out.println("O jogador 2 venceu! ");
			}
			
			if (escolha1.equals(escolha2)) {
				System.out.println("Empate! ");
			}
						
		} while (escolha1.equals("pedra") || escolha1.equals("papel") || escolha1.equals("tesoura"));
			

	}

}
