import java.util.*;
public class Exercicio5_3 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		int matriculasLTP[] = new int[149];
		int contLTP;
		int matriculasCalculo[] = new int[219];
		int contCalculo;
		int contMatriculadosEmAmbas = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (contLTP = 0; contLTP <= 149; contLTP ++) {
			System.out.print("Digite o número de matrícula do aluno " + (contLTP + 1) + " de LTP (Digite 999 para encerrar a digitação): ");
			matriculasLTP[contLTP] = leia.nextInt();
			
			if (matriculasLTP[contLTP] == 999) {
				break;
			}
		}
		
		for (contCalculo = 0; contCalculo <= 219; contCalculo ++) {
			System.out.print("Digite o número de matrículo do aluno " + (contCalculo + 1) + " de Cálculo (Digite 999 para encerrar a digitação): ");
			matriculasCalculo[contCalculo] = leia.nextInt();
			
			if (matriculasCalculo[contCalculo] == 999) {
				break;
			}						
		}
		
		// 3 - calculos
		if (matriculasLTP[contLTP] == matriculasCalculo[contCalculo]) {
			contMatriculadosEmAmbas ++;
		}
					
		// 4 - saida de dados 
		System.out.println("Quantidade de alunos matrículados em ambas as disciplinas: " + contMatriculadosEmAmbas);
	}

}
