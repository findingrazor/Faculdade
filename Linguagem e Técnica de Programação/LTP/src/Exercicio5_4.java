import java.util.*;
public class Exercicio5_4 {

	public static void main(String[] args) {		
		// 1 - variaveis
		char gabarito[] = new char [11];
		int contQuestoes;
		int matricula[] = new int [49];
		int contAlunos = 0;
		char respostasDoAluno;
		int nota = 0;
		int contAprovados = 0;
		float percentualAprovados;
		int frequencia [] = new int[11];
		byte maiorFrequencia = 0;
		byte notaMaiorFrequencia = 0;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados
		System.out.println("GABARITO");
		for (contQuestoes = 1; contQuestoes <= 10; contQuestoes ++) {
			System.out.print("Digite a resposta da questão " + contQuestoes + ": ");
			gabarito[contQuestoes] = leia.next().charAt(0);
		}
		
		do {
			System.out.print("Digite a matrícula do aluno: ");
			matricula[contAlunos] = leia.nextInt();
			
			if (matricula[contAlunos] == 999) {
				break;
			}
			
			for (contQuestoes = 1; contQuestoes <= 10; contQuestoes ++) {
			System.out.print("Digite a resposta dada para a questão " + contQuestoes + ": ");
			respostasDoAluno = leia.next().charAt(0);
				
			// 3 - calculos
				if (respostasDoAluno == gabarito[contQuestoes]) {
					nota = nota + 1;
				}
			}
			
			System.out.println("Nota do aluno: " + nota);
			if (nota >= 6) {
				contAprovados ++;
			}
			contAlunos ++;			
			frequencia[nota] ++;
			
			nota = 0;
		} while (matricula[contAlunos] != 999);
		
		// 4 - saida de dados
		System.out.println("Percentual de aprovados: " + contAprovados * 100 / contAlunos + "%");
		for (int cont = 0; cont <= 10; cont ++) {
			if (frequencia[cont] > maiorFrequencia) {
				maiorFrequencia = (byte) frequencia[cont];
				notaMaiorFrequencia = (byte) cont;
			}
		}
		System.out.println("Nota que apareceu com maior frequencia na turma: " + notaMaiorFrequencia);

	}

}
