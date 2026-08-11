import java.util.*;
public class Exercicio2_6 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float peso;
		float altura;
		float imc;
		float pesoIdealMin;
		float pesoIdealMax;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o peso do atleta (kg): ");
		peso = leia.nextFloat();
		System.out.print("Digite a altura do atleta (m): ");
		altura = leia.nextFloat();
		
		// 3 - calculos 
		imc = peso / (altura * altura);
		if (imc < 20) {
			System.out.println("Situação: abaixo do peso");
		} else if (imc <= 25) {
			System.out.println("Situação: peso ideal");
		} else {
			System.out.println("Situação: acima do peso");
		}
		
		pesoIdealMin = 20 * (altura * altura);
		pesoIdealMax = 25 * (altura * altura);
		
		// 4 - saida de dados 
		System.out.println("Índice de Massa Corporal: " + imc);
		System.out.println("Peso ideal mínimo: " + pesoIdealMin);
		System.out.println("Peso ideal máximo: " + pesoIdealMax);
	}

}
