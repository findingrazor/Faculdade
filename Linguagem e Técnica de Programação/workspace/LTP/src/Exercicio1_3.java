import java.util.*;
public class Exercicio1_3 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float vlrApl;
		float taxaJuros;
		float rendim;
		float vlrTotal; 
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o valor aplicado: ");
		vlrApl = leia.nextFloat();
		System.out.print("Digite a taxa de juros (%): ");
		taxaJuros = leia.nextFloat();
		
		// 3 - calculos
		rendim = vlrApl * taxaJuros / 100;
		vlrTotal = rendim + vlrApl;
		
		// 4 - saida de dados
		System.out.println("Rendimento: " + rendim);
		System.out.println("Valor total: " + vlrTotal);

	}

}
