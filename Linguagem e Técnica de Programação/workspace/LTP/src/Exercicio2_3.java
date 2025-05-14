import java.util.*;
public class Exercicio2_3 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		String nomeAluno;
		float nota1;
		float nota2;
		float nota3;
		float mediaNotas;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o nome do aluno: ");
		nomeAluno = leia.nextLine();
		System.out.print("Digite a primeira nota: ");
		nota1 = leia.nextFloat();
		System.out.print("Digite a segunda nota: ");
		nota2 = leia.nextFloat();
		System.out.print("Digite a terceira nota: ");
		nota3 = leia.nextFloat();
		
		// 3 - calculos 
		mediaNotas = (nota1 + nota2 + nota3) / 3;
		if (mediaNotas <= 4) {
			System.out.println("Aluno reprovado!");
		} else if (mediaNotas < 7) {
			System.out.println("Aluno em recuperação!");
		} else {
			System.out.println("Aluno aprovado!");
		}
		
		// 4 - saida de dados
		System.out.println("Média das notas: " + mediaNotas);

	}

}
