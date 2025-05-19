import java.util.*;
public class Exercicio4_2 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		byte voto;
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int contNulo = 0;
		int contBranco = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.println("Digite 1 para votar no candidato 1");
		System.out.println("Digite 2 para votar no candidato 2");
		System.out.println("Digite 3 para votar no candidato 3");
		System.out.println("Digite 4 para votar nulo");
		System.out.println("Digite 5 para votar em branco");
		
		for (int cont = 1; cont <= 150; cont ++) {
			
			do {
				System.out.print("Digite o voto: ");
				voto = leia.nextByte();
				if (voto < 1 || voto > 5) {
					System.out.println("Voto inválido, digite um numero entre 1 e 5 para votar! ");
				} 
			} while (voto < 1 || voto > 5);
			
			// 3 - calculos
			if (voto == 1) {
				cont1 ++;
			} else if (voto == 2) {
				cont2 ++;
			} else if (voto == 3) {
				cont3 ++;
			} else if (voto == 4) {
				contNulo ++;
			} else if (voto == 5) {
				contBranco ++;
			}
		}
		
		// 4 - saida de dados
		if (cont1 > cont2 && cont1 > cont3) {
			System.out.println("O candidato 1 é o vencedor! ");
		} else if (cont2 > cont2 && cont2 > cont3) {
			System.out.println("O candidato 2 é o vencedor! ");
		} else {
			System.out.println("O candidato 3 é o vencedor! ");
		}
		
		System.out.println("Votos nulos: " + contNulo);
		System.out.println("Votos em branco: " + contBranco);

	}

}
