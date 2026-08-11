import java.util.*;
public class Exercicio2_2 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		String nomeEmpregado;
		float salario;
		float novoSalario;
		Scanner leia = new Scanner(System.in);
		
		
		// 2 - entrada de dados
		System.out.print("Digite o nome do empregado: ");
		nomeEmpregado = leia.nextLine();
		System.out.print("Digite o salario atual do empregado: ");
		salario = leia.nextFloat();
		
		// 3 - calculos 
		if (salario < 1000) {
			novoSalario = salario + (float) 15 / 100 * salario;
		} else {
			novoSalario = salario + (float) 10 / 100 * salario;
			
		}
		
		// 4 - saida de dados 
		System.out.print("Novo salario: " + novoSalario);

	}

}
