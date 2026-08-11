import java.util.*;
public class Exercicio5_1 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float nota;
		float somaNotasAluno = 0;
		float mediaNotasAlunos[] = new float [30];
		float somaMediasNotasAlunos = 0;
		byte contNotas;
		byte contAlunos;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados 
		for (contAlunos = 0; contAlunos <= 29; contAlunos ++) {
			
			for (contNotas = 1; contNotas <= 5; contNotas ++) {
				System.out.print("Digite a nota " + contNotas + " do aluno " + (contAlunos + 1) + ": "); 
				nota = leia.nextFloat();
				
				
				// 3 - calculos
				somaNotasAluno = somaNotasAluno + nota;
			}
			
			mediaNotasAlunos[contAlunos] = somaNotasAluno / 5;
			somaMediasNotasAlunos = somaMediasNotasAlunos + mediaNotasAlunos[contAlunos];
			somaNotasAluno = 0;
				
		}
		
		// 4 - saida de dados
		System.out.println("Número do aluno        Média do aluno");
		for (byte x = 0; x <= 3; x ++) {
			System.out.println("   " + (x = 1) + "               " + mediaNotasAlunos[x]);
		}
		
		System.out.println("Média da turma: " + somaMediasNotasAlunos / 30);
		

	}

}
