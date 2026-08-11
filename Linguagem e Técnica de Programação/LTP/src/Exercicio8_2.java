import java.util.*;
public class Exercicio8_2 {

	public static void main(String[] args) {
		// 1 - variaveis
		String nomeEmp[] = new String[100];
		int codigoEmp;
		int numPecas;
		float salario[] = new float[100];
		float somaSalarios = 0;
		byte contEmp = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (contEmp = 0; contEmp <= 99; contEmp ++) {
				System.out.print("Digite o nome do empregado ('fim' para encerrar a digitação): ");
				nomeEmp[contEmp] = leia.nextLine();
				
				if (nomeEmp[contEmp].equalsIgnoreCase("fim")) {
					break;
				}	
			
			do {
				System.out.print("Digite o código do empregado (1 a 999): ");
				codigoEmp = leia.nextInt();
				
				if (codigoEmp < 1 || codigoEmp > 999) {
					System.out.println("Código inválido, digite um número entre 1 e 999");
				}
			} while (codigoEmp < 1 || codigoEmp > 999);
			
			do {
				System.out.print("Digite o número de peças fabricadas: ");
				numPecas = leia.nextInt();
				
				if (numPecas <= 0) {
					System.out.println("Quantidade inválida, digite um número maior que 0");
				}
			} while (numPecas <= 0);
			
			// 3 - calculos
			salario[contEmp] = calcularSalarioDoEmpBaseadoPecas(numPecas);
			somaSalarios = somaSalarios + salario[contEmp];
			
			leia.nextLine();
		}
		
		// 4 - saida de dados 
		System.out.println("RELATÓRIO");
		System.out.println("NOME                SALÁRIO");
		for (byte x = 0; x < contEmp; x ++) {
			System.out.println(nomeEmp[x] + "       " + salario[x]);
		}
		System.out.println("Soma total dos salários: " + somaSalarios);
		System.out.println("Média salários: " + somaSalarios / contEmp);	
	}
	
	// 5 - metodo
	public static float calcularSalarioDoEmpBaseadoPecas (int a) {
		float calculoSalario;
		
		if (a <= 200) {
			calculoSalario = a * 2f;
		} else if (a <= 400) {
			calculoSalario = a * 2.30f;
		} else {
			calculoSalario = a * 2.50f;
		}
		
		return calculoSalario;
	}
		
}
