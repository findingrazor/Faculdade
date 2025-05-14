import java.util.*;
public class Exercicio2_1 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		byte idade;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite a idade: ");
		idade = leia.nextByte();
		
		// 3 - calculos 
		if (idade >= 18) {
			System.out.print("Você é maior de idade! ");
		} else {
			System.out.print("Você é menor de idade!");
		}
		

	}

}
