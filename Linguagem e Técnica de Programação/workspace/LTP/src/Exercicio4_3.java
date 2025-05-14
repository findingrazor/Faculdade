import java.util.*;
public class Exercicio4_3 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float altura;
		char sexo;
		float maiorAltura = 0;
		float menorAltura = 3;
		float alturaM = 0;
		float alturaGeral = 0;
		int contAtletasF = 0;
		int contAtletasM = 0;
		int contGeral = 0;
		float mediaAlturaM;
		float mediaGeral;
		Scanner leia = new Scanner (System.in);
		
		
		
		// - 2 entrada de dados
		do {
			do {
				System.out.print("Digite a altura (m) do(a) atleta (Digite 0 para terminar): ");
				altura = leia.nextFloat();
				
				if (altura < 0 || altura > 2.5) {
					System.out.println("Digite uma altura entre 0 e 2.5 metros! ");
				}
			} while (altura < 0 || altura > 2.5);
			
			if (altura == 0) {
				break;
			}
			
			do {
				System.out.print("Digite o sexo do(a) atleta (F ou M): ");
				sexo = leia.next().charAt(0);
				
				if (sexo != 'M' && sexo != 'F') {
					System.out.println("Digite F ou M para o sexo do(a) atleta! ");				
				}
			} while (sexo != 'M' && sexo != 'F');
			
			if (sexo == 'F') {
				contAtletasF ++;
			} else {
				contAtletasM ++;
				alturaM = alturaM + altura;
			}
			
			if (altura > maiorAltura) {
				maiorAltura = altura;
			}

			if (altura < menorAltura) {
				menorAltura = altura;
			}
			
			contGeral ++;
			alturaGeral = alturaGeral + altura;
		
		} while (altura != 0);
		
		// 3 - calculos 
		mediaAlturaM = alturaM / contAtletasM;
		mediaGeral = alturaGeral / contGeral;
		
		// 4 - saida de dados
		System.out.println("Maior altura: " + maiorAltura);
		System.out.println("Menor altura: " + menorAltura);
		System.out.println("Quantidade de atletas femininas: " + contAtletasF);
		System.out.println("Media de altura masculina: " + mediaAlturaM);
		System.out.println("Media de altura geral: " + mediaGeral);
		

	}
	
}	
