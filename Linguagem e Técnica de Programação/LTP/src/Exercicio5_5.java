import java.util.*;
public class Exercicio5_5 {

	public static void main(String[] args) {
		// 1 - variaveis
		String nomeAluno;
		byte nota;
		char sexo;
		byte contAlunos;
		byte contMAprov = 0;
		byte contF = 0;
		int notasF = 0;
		byte contFReprov = 0;
		byte contAprov = 0;
		String aprovados[]= new String[50];
		byte notaAprovados[] = new byte[50];
		int somaNotas = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		for (contAlunos = 1; contAlunos <= 50; contAlunos ++) {
			System.out.print("Digite o nome do aluno: ");
			nomeAluno = leia.nextLine();
			
			do {
				System.out.print("Digite a nota do aluno: ");
				nota = leia.nextByte();			
				
				if (nota < 0 || nota > 100) {
					System.out.println("Nota inválida, digite um número de 0 a 100!");
				}
			} while (nota < 0 || nota > 100);
			
			
			do {
				System.out.print("Digite o sexo do aluno: ");
				sexo = leia.next().charAt(0);
				
				if (sexo != 'M' && sexo != 'F'){
					System.out.println("Sexo inválido, digite M ou F!");
				}		
				
			} while (sexo != 'M' && sexo != 'F');
			
			// 3 - calculos
			if (sexo == 'F') {
				contF ++;
				notasF = (byte) (notasF + nota);
			}
			
			if (nota >= 60) {
				System.out.println("Aluno aprovado!");				
				aprovados[contAprov] = nomeAluno;
				notaAprovados[contAprov] = nota;
				contAprov ++;
				
				if (sexo == 'M') {
					contMAprov ++;
				}	
			}
			
			else {
				System.out.println("Aluno reprovado!");
				if (sexo == 'F') {
					contFReprov ++;
				}				
			}
			somaNotas = somaNotas + nota;
			
			leia.nextLine();
		}
		
		// 4 - saida de dados
		System.out.println("Quantidade de aprovados do sexo masculino: " + contMAprov);
		System.out.println("Quantidade de reprovadas do sexo feminino: " + contFReprov);
		if (contF > 0) {
			System.out.println("Média das notas femininas: " + notasF / contF);
		}
		System.out.println("Média geral: " + somaNotas / contAlunos );
		System.out.println("Relatório dos aprovados");
		System.out.println("    NOME        NOTA");
		for (byte x = 0; x < contAprov; x ++) {
			System.out.println(aprovados[x] + "        " + notaAprovados[x]);
		}
		
	}
}
				