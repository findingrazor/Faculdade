import java.util.*;
public class Exercicio6_2 {

	public static void main(String[] args) {
		// 1 - variaveis
		char palpite [][] = new char [3][13];
		float preco;
		float valorBase = 10;
		int duplos = 0;
		int triplos = 0;
		byte numJogo, aposta = 0;
		byte contX = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (numJogo = 0; numJogo <= 12; numJogo ++) {
			for (aposta = 0; aposta <= 2; aposta ++) {
				System.out.print("Para o jogo " + (numJogo + 1) + " coluna " + (aposta + 1) + " digite a opção escolhida (. ou X): " );
				palpite[aposta][numJogo] = leia.next().charAt(0);
				
				if (palpite[aposta][numJogo] == 'X') {
					contX ++;
				}			
			}
			
			// 3 - calculos
			if (contX == 2) {
				duplos ++;
			} else if (contX == 3) {
				triplos ++;
			}
			
			contX = 0;
		}
		
		preco = (float) (valorBase * Math.pow(2, duplos) * Math.pow(3, triplos));
		
		// 4 - saida de dados 
		System.out.println("Valor do bilhete: " + preco);
		System.out.println("BILHETE");
		
		System.out.println("     1   2   3   4   5   6   7   8   9   10  11  12  13   ");
		for (aposta = 0; aposta <= 2; aposta ++) {
			
			if (aposta == 0) {
				System.out.print("Time 1");
			} else if (aposta == 1) {
				System.out.print("Empate");
			} else if (aposta == 2) {
				System.out.print("Time 2");
			}
			for (numJogo = 0; numJogo <= 12; numJogo ++) {
				System.out.print(palpite[aposta][numJogo] + " ");
			}
			
			System.out.println();
		}
	}

}
