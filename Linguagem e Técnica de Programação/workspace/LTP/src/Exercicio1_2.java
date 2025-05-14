import java.util.*;
public class Exercicio1_2 {

	public static void main(String[] args) {
		
		// 1 - declarar variaveis
		String nomeEmp;
		float salario;
		float novoSal;
		Scanner leia = new Scanner(System.in);
		
		// 2 - Entrada de dados 
		System.out.print("Digite o nome do empregado: ");
		nomeEmp = leia.nextLine();
		System.out.print("Digite o salario: ");
		salario = leia.nextFloat();
		
		// 3 - calculos
		novoSal = salario + (float) 15 / 100 * salario;
		
		// 4 - saida de dados
		System.out.println("Novo salario: " + novoSal);
		
		
	}

}
