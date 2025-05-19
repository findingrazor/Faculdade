import java.util.*;
public class Exercicio3_1 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		byte notaAluno;
		byte cont = 1;
		byte contAprovados = 0;
		byte contReprovados = 0;
		Scanner leia = new Scanner(System.in);

		// 2 - entrada de dados
		while (cont <= 10) {
			System.out.println("Digite a nota do aluno: " + cont + ": ");
			notaAluno = leia.nextByte();			
				
			
		// 3 - calculos
		if (notaAluno >= 60) {
			System.out.println("Aprovado! ");
			contAprovados ++;
		} else {
			System.out.println("Reprovado! ");
			contReprovados ++;
		}
		cont ++;
		
	}	
		// 4 - saida de dados
		System.out.println("Numero de Aprovados: " + contAprovados);
		System.out.println("Numero de Reprovados: " + contReprovados);
	}
	
	
	
}	

