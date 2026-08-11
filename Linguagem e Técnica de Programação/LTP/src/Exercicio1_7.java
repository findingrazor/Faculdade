import java.util.*;
public class Exercicio1_7 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float vlrDepo;
		float vlrCheque1;
		float vlrCheque2;
		float taxa1;
		float taxa2;
		float saldoFinal;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		System.out.print("Digite o valor do deposito: ");
		vlrDepo = leia.nextFloat();
		System.out.print("Digite o valor do primeiro cheque: ");
		vlrCheque1 = leia.nextFloat();
		System.out.print("Digite o valor do segundo cheque: ");
		vlrCheque2 = leia.nextFloat();
		
		// 3 - calculos
		taxa1 = vlrCheque1 * (float) 0.02 / 100;
		taxa2 = vlrCheque2 * (float) 0.02 / 100;
		saldoFinal = vlrDepo - (vlrCheque1 + taxa1 + vlrCheque2 + taxa2);
		
		// 4 - saida de dados
		System.out.println("Saldo final: " + saldoFinal);
		

	}

}
