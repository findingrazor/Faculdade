import java.util.*;
public class Exercicio7_1 {

	public static void main(String[] args) {
		// 1 - variaveis
		String cidades[] = new String[20];
		String pesquisa;
		int distancias[] = new int [20];
		boolean encontrou;
		int x;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados
		for (x = 0; x <= 19; x ++) {
			do {
				System.out.print("Digite o nome da cidade (campo obrigatório/FIM para encerrar): ");
				cidades[x] = leia.nextLine();
				
				if (cidades[x].equals("")) {
					System.out.println("Campo obrigatório, por favor digite o nome de uma cidade ou FIM para encerrar a digitação");
				}
			} while (cidades[x].equals(""));
			
			if (cidades[x].equals("FIM")) {
				break;
			}
			
			do {
				System.out.print("Digite a distancia dessa cidade a Belo Horizonte (km): ");
				distancias[x] = leia.nextInt();
				
				if (distancias[x] < 500) {
					System.out.println("Valor invalido, digite uma distancia acima de 500 km");
				}
			} while (distancias[x] < 500);
			
			leia.nextLine();
		}
		
		// 3 - pesquisa
		do {
			System.out.print("Digite a cidade para qual se deseja ir (FIM para encerrar a consulta): ");
			pesquisa = leia.nextLine();
			
			if (pesquisa.equals("FIM")) {
				break;
			}
			
			encontrou = false;
			
			// 4 - saida de dados
			for (x = 0; x <= 19; x ++) {
				if (pesquisa.equals(cidades[x])) {
					encontrou = true;					
					System.out.println("Cidade encontrada");
					System.out.println("Preço da passagem: " + (distancias[x] * 0.25f));
					System.out.println("Tempo de voo: " + (float) distancias[x] / (800 * 60));
					System.out.println("Quantidade de escalas: " + (float) (distancias[x] / (800 * 60)) / 3);
					break;
				} else {
					System.out.println("Erro, cidade não encontrada");
				}
				
				if (pesquisa.equals(cidades[x])) {
					break;
				}
		}

	} while (!pesquisa.equals("FIM"));

	}
}