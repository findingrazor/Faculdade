import java.util.*;
public class Exercicio1_1 {

	public static void main(String[] args) {
		
		// 1 - declarar variaveis
		String nomeAluno;
		int nota1;
		int nota2;
		int nota3;
		int somaNotas;
		float mediaNotas;
		Scanner leia = new Scanner(System.in);
		
		// 2 - Entrada de dados
		System.out.print("Digite o nome do aluno: ");
        nomeAluno = leia.nextLine();
        System.out.print("Digite a primeira nota: ");
        nota1 = leia.nextInt();
        System.out.print("Digite a segunda nota: ");
        nota2 = leia.nextInt();
        System.out.print("Digite a terceira nota: ");
        nota3 = leia.nextInt();
        
        // 3 - calculos
        somaNotas = nota1 + nota2 + nota3;
        mediaNotas = (float) somaNotas / 3;
        
        // 4 - saida de dados
        System.out.println("Nota final do aluno: " + somaNotas);
        System.out.println("Media das notas: " + mediaNotas);
        
	}

}
