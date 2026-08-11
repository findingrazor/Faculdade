import java.util.*;
public class Exercicio10_1 {

	public static void main(String[] args) {
		// 1 - variaveis
		String nomeDigitado;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o nome em letras minúsculas: ");
		nomeDigitado = leia.nextLine();
		
		// 3 - saida de dados 
		System.out.println("Nome alterado: " + alterarPrimLetraMaiusc(nomeDigitado));
		
		nomeDigitado = alterarPrimLetraMaiusc(nomeDigitado);

	}
	
	public static String alterarPrimLetraMaiusc (String nome1) {
		nome1 = Character.toUpperCase(nome1.charAt(0)) + nome1.substring(1);
		return nome1;
	}
	
	public static String alterarTodasPrimLetraMaiusc (String nome2) {
		nome2 = alterarPrimLetraMaiusc(nome2);
		for (int x = 1; x < nome2.length(); x++) {
			if (nome2.charAt(x+1) == ' ') {
				nome2 = nome2.substring(0, x + 1) + Character.toUpperCase(nome2.charAt(x+1)) + nome2.substring(x + 2);
			}
		}
		return nome2;
	}
	
	public static String contarEspacoEsquerda (String nome3) {
		while (nome3.charAt(0) == ' ') {
			nome3 = nome3.substring(1);
			nome3 = nome3.replaceFirst(" ", "");
		}
		return nome3;
	}
}
