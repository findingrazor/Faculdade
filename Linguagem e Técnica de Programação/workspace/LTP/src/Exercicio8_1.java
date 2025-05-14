import java.util.*;
public class Exercicio8_1 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		int numA, numB, numC;
		int retorno;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o valor do número A: ");
		numA = leia.nextInt();
		
		System.out.print("Digite o valor do número B: ");
		numB = leia.nextInt();
		
		System.out.print("Digite o valor do número C: ");
		numC = leia.nextInt();
		
		// 3 - execução
		retorno = somarIntEntreAB(numA, numB);
		System.out.println("Soma dos inteiros entre A e B: " + retorno);
			
		exibirIntEntreABDivisPorC(numA, numB, numC);
			
		System.out.println("Percentual de C sobre A: " + calcularPercentualAC(numA, numC) +"%");
	}
	
	// 4 - metodos
	public static int somarIntEntreAB (int a, int b) {
		int soma = 0;
		for (int x = a + 1; x < b; x ++) {
			soma = soma + x;
		}		
		return soma;
	}
	
	public static void exibirIntEntreABDivisPorC (int a, int b, int c) {
		for (int x = a + 1; x < b; x++) {
			if (x % c == 0) {
				System.out.println("Número " + x + " é divisivel por " + c);
			}
		}
		
	}
	
	public static float calcularPercentualAC (int a, int c) {
		float percentual;
		percentual = c * 100f / a;
		
		return percentual;
	}
	
	
	

}
