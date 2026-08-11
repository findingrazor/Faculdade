import java.util.*;
public class Exercicio2_5 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float lado1;
		float lado2;
		float lado3;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		System.out.print("Digite a medida do primeiro lado: ");
		lado1 = leia.nextFloat();
		System.out.print("Digite a medida do segundo lado: ");
		lado2 = leia.nextFloat();
		System.out.print("Digite a medida do terceiro lado: ");
		lado3 = leia.nextFloat();
		
		// 3 - calculos 
		if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado3 + lado2 <= lado1) {
			System.out.println("Não é um triângulo! ");
		} else if (lado1 == lado2 && lado2 == lado3) {
			System.out.println("É um triângulo equilátero! ");
		} else if (lado1 == lado2 || lado2 == lado3 || lado3 == lado1) {
			System.out.println("É um triângulo isósceles! ");
		} else {
			System.out.println("É um triângulo escaleno! ");
		}
	}
}
