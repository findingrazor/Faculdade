import java.util.*;
public class Exemplo {

	public static void main(String[] args) {
		
		// 1 - Declaracao de variaveis
		float salario;
		float vlrAumento;
		float novoSalario;
		Scanner leia = new Scanner(System.in);
		
		// 2 - Entrada de dados
		System.out.print("Digite o valor do salario: ");
		salario = leia.nextFloat();
		
		System.out.print("Digite o valor do aumento: ");
		vlrAumento = leia.nextFloat();
		
		// 3 - Calculos
		novoSalario = salario + vlrAumento;
		
		// 4 - saida de dados
		System.out.println("Valor do novo salario: " + novoSalario);

	
	}

}
