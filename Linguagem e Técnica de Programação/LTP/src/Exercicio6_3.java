import java.util.*;
public class Exercicio6_3 {

	public static void main(String[] args) {
		// 1 - variaveis
		float custoProd[] = new float [3];
		int quantProd[][] = new int [3][3];
		int maiorNumProd = 0;
		byte armazemMaisProd = 0;
		float custoProdArmazem;
		float custoArmazem = 0;
		float custoTotal = 0;
		int somaQuantArma = 0;
		byte linha, coluna;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados
		for (byte x = 0; x <= 2; x ++) {
			System.out.print("Digite o valor do produto " + (x + 1) + ": ");
			custoProd[x] = leia.nextFloat();
		}
		
		for (linha = 0; linha <= 2; linha ++) {
			for (coluna = 0; coluna <= 2; coluna ++) {
				System.out.print("Digite a quantidade do produto " + (coluna + 1) + " no armazem " + (linha + 1) + ": ");
				quantProd[linha][coluna] = leia.nextInt();
				
				// 3 - calculos
							
				custoProdArmazem = quantProd[linha][coluna] * custoProd[coluna];
				System.out.println("Custo do produto: " + custoProdArmazem);
				
				custoArmazem = custoProdArmazem * custoArmazem;
				
				somaQuantArma = somaQuantArma + quantProd[linha][coluna];
				
				}
				
			}
			
			System.out.println("Custo do estoque do armazem: " + custoArmazem);
			
			custoTotal = custoTotal + custoArmazem;
			
			if (somaQuantArma > maiorNumProd){
				maiorNumProd = somaQuantArma;
				armazemMaisProd = (byte) (linha + 1);	
			}
			
			somaQuantArma =  0;
			custoArmazem = 0;
		
		// 4 - saida de dados
		System.out.println("Armazem com maior numero de produtos armazenados: " + armazemMaisProd);
		System.out.println("Custo total de estoque: " + custoTotal);
	}

}
