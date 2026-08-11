import java.util.*;
public class Exercicio2_7 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		int tempoDeCasa;
		float salario;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o tempo de casa (anos): ");
		tempoDeCasa = leia.nextInt();
		System.out.print("Digite o salario do empregado: ");
		salario = leia.nextFloat();
		
		// 3 - calculos 
		if (tempoDeCasa <= 5 && salario <= 300) {
			System.out.println("Bonus: R$50,00 ");
			System.out.println("Vale Trasnporte: " + salario * (5f / 100));
		} else if (tempoDeCasa <= 5 && salario > 300) {
			System.out.println("Bonus: R$80,00 ");
			System.out.println("Vale trasnporte: " + salario * (6f / 100));
		} else if (tempoDeCasa <= 10 && salario <= 500) {
			System.out.println("Bonus: " + salario * (15f / 100));
			System.out.println("Vale transporte: R$70,00 ");
		} else if (tempoDeCasa <= 10 && salario <= 2000) {
			System.out.println("Bonus: " + salario * (13f / 100));
			System.out.println("Vale transporte: R$90,00 ");
		} else if (tempoDeCasa <= 10 && salario > 2000) {
			System.out.println("Bonus: " + salario * (12f / 100));
			System.out.println("Vale transporte: " + salario * (8f / 100));
		} else {
			System.out.println("Bonus: R$300,00");
			System.out.println("Vale transporte: " + salario * (4f / 100));
		}

	}

}
