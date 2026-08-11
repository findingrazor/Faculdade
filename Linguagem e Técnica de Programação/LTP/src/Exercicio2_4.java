import java.util.*;
public class Exercicio2_4 {

	public static void main(String[] args) {
		
		// 1 - variaveis 
		int numeroVotosA1;
		int numeroVotosB1;
		int numeroVotosC1;
		int numeroVotosA2;
		int numeroVotosB2;
		int numeroVotosC2;
		int somaVotosA;
		int somaVotosB;
		int somaVotosC;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		System.out.print("Digite o numero de votos do candidato A na primeira seção: ");
		numeroVotosA1 = leia.nextInt();
		System.out.print("Digite o numero de votos do candidato B na primeira seção: ");
		numeroVotosB1 = leia.nextInt();
		System.out.print("Digite o numero de votos do candidato C na primeira seção: ");
		numeroVotosC1 = leia.nextInt();
		System.out.print("Digite o numero de votos do candidato A na segunda seção: ");
		numeroVotosA2 = leia.nextInt();
		System.out.print("Digite o numero de votos do candidato B na segunda seção: ");
		numeroVotosB2 = leia.nextInt();
		System.out.print("Digite o numero de votos do candidato C na segunda seção: ");
		numeroVotosC2 = leia.nextInt();
		
		// 3 calculos 
		somaVotosA = numeroVotosA1 + numeroVotosA2;
		somaVotosB = numeroVotosB1 + numeroVotosB2;
		somaVotosC = numeroVotosC1 + numeroVotosC2;
		if (somaVotosA > somaVotosB && somaVotosA > somaVotosC) {
			System.out.println("Candidato A é o vencedor!");
		} else if (somaVotosB > somaVotosA && somaVotosB > somaVotosC) {
			System.out.println("Candidato B é o vencedor!");
		} else {
			System.out.println("Candidato C é o vencedor!");
		}
		

	}
}
