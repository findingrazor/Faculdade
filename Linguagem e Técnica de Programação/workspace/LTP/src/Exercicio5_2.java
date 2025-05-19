import java.util.*;
public class Exercicio5_2 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		byte nota;
		byte cont;
		byte contNotas []  = new byte[11];
		Scanner leia = new Scanner (System.in);
		
		// - 2 entrada de dados
		for (cont = 1; cont <= 100; cont ++) {
			System.out.print("Digite a nota do aluno " + cont + ": ");
			nota = leia.nextByte();
			
			// 3 - calculos
			contNotas[nota] ++;
		}
		
		// 4 - saida de dados 
		System.out.println("    Tabela de Notas e Frequência");
		System.out.println("Nota      Frequência Absoluta");
		for (byte x = 0; x <=10; x ++) {
			System.out.println("   " + x + "             " + contNotas[x]);
		}
	}	

}
