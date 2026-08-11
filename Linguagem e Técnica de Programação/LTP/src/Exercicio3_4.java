import java.util.*;
public class Exercicio3_4 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		String nomeAluno;
		String nomeMaiorNota = " ";
		int nota1 = 0, nota2, nota3;
		int quantidadeAlunos = 0;
		int notaFinal;
		int somaNotas = 0;
		float mediaNotas;
		int maiorNota = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		while (nota1 != -1) {
			System.out.print("Digite o nome do aluno: " );
			nomeAluno = leia.nextLine();			
			System.out.print("Digite a primeira nota do aluno (-1 para parar): ");
			nota1 = leia.nextInt();
			if (nota1 < 0) {
				break;
			}		
			System.out.print("Digite a segunda nota do aluno: ");
			nota2 = leia.nextInt();			
			System.out.print("Digite a terceira nota do aluno: ");
			nota3 = leia.nextInt();
			
			// 3 - calculos
			notaFinal = nota1 + nota2 + nota3;			
			if (notaFinal >= 60) {
				System.out.println("Aluno aprovado! ");
			} else {
				System.out.println("Aluno reprovado! ");
			}
			System.out.println("Nota final: " + notaFinal);
			
			quantidadeAlunos ++;
			somaNotas = somaNotas + notaFinal;
			if (notaFinal > maiorNota) {
				maiorNota = notaFinal;
				nomeMaiorNota = nomeAluno;								
			}
				
			leia.nextLine();
		}

		mediaNotas = somaNotas / quantidadeAlunos;
		
		// 4 - saida de dados
		System.out.println("Quantidade total de alunos: " + quantidadeAlunos);
		System.out.println("Media das notas dos alunos: " + mediaNotas);
		System.out.println("Maior nota da turma: " + nomeMaiorNota + " Nota: " + maiorNota);
		

		
		
		
		

	}

}
