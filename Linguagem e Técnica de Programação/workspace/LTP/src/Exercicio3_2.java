import java.util.*;
public class Exercicio3_2 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		int numero;
		long fatorial = 1;
		int cont = 1;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		System.out.print("Digite o numero: ");
		numero = leia.nextInt();
		
		// 3 - calculos 
		
		while (cont <= numero) {
			fatorial = cont * fatorial;
			cont ++;
		}
		
		// 4 - saida de dados 
		System.out.println("Resultado: " + fatorial);
 
	}

}
