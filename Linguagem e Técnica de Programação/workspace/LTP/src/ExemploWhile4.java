import java.util.*;
public class ExemploWhile4 {
	public static void main(String[] args) {
		// 1 – Declaração e inicialização de variáveis
		int numeroPar = 2;
		int valorFinal;
		int somaDosPares = 0;
		Scanner leia = new Scanner(System.in);
		// 2 – Entrada de dados
		System.out.print("Digite o valor final para a serie: ");
		valorFinal = leia.nextInt();
		// 3 – Cálculos
		while (numeroPar <= valorFinal) {
			somaDosPares = somaDosPares + numeroPar;
			numeroPar = numeroPar + 2;
		}
		// 4 – Saída de dados
		System.out.print("A soma dos números pares entre 2 e " +
				valorFinal + " é: " + somaDosPares);
	}
}





