import java.util.*;
public class Exercicio4_4 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		int codigoOp;
		char classeOp;
		int contOpB = 0;
		int pecasFabriB = 0;
		int numeroDePecasFabri;
		int opMenosProduziu = 0;
		int menorProducao = 1000;
		int totalPecas = 0;
		float salario;
		float somaSalarios = 0;
		float mediaPecasB;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados 
		do {
			System.out.print("Digite o código do operário (Digite 0 para terminar): ");
			codigoOp = leia.nextInt();
			
			if (codigoOp == 0) {
				break;
			}
			
			do {
				System.out.print("Digite a classe do operário (A, B ou C): ");
				classeOp = leia.next().charAt(0);
				
				if (classeOp != 'A' && classeOp != 'B' && classeOp != 'C')
					System.out.println("Classe invalida, digite A, B ou C para selecionar a classe!" );
				
				if (classeOp == 'B') {
					contOpB ++;					
				}
				
			} while (classeOp != 'A' && classeOp != 'B' && classeOp != 'C');
			
			do {
				System.out.print("Digite o número de peças fabricadas por este funcionário: ");
				numeroDePecasFabri = leia.nextInt();
				
				if (numeroDePecasFabri <= 0) {
					System.out.println("digite um número maior que 0 para validar o número de peças validadas! ");
				}
				
				if (classeOp == 'B') {
					pecasFabriB = pecasFabriB + numeroDePecasFabri;
				}
				
			} while (numeroDePecasFabri < 0);
			
			if (classeOp == 'A' && numeroDePecasFabri <= 30) {
				salario = 500 + 2 * numeroDePecasFabri;
			} else if (classeOp == 'A' && numeroDePecasFabri <= 40) {
				salario = 500 + 2.30f * numeroDePecasFabri;
			} else if (classeOp == 'A' && numeroDePecasFabri > 40) {
				salario = 500 + 2.80f * numeroDePecasFabri;
			} else if (classeOp == 'B') {
				salario = 1200;
			} else if (classeOp == 'C' && numeroDePecasFabri <= 50) {
				salario = 40 * numeroDePecasFabri;
			} else {
				salario = 45 * numeroDePecasFabri;
			}
			
			if (numeroDePecasFabri < menorProducao) {
				opMenosProduziu = codigoOp;
			}
			System.out.println("Salário do empregado: " + salario);
			
			somaSalarios = somaSalarios + salario;
			totalPecas = totalPecas + numeroDePecasFabri;
			
			
						
		} while (codigoOp != 0);
		
		// 3 - calculos 
		mediaPecasB = pecasFabriB / contOpB;
		
		// 4 - saida de dados
		System.out.println("Total gasto com salarios: " + somaSalarios);
		System.out.println("Total de peças fabricadas: " + totalPecas);
		System.out.println("Operário que fabricou menos: " + opMenosProduziu);
		if (contOpB > 0) {
			System.out.println("Media de peças fabricadas por empregados da calsse B: " + mediaPecasB);
		}
	}

}
