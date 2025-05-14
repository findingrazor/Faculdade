import java.util.*;
public class Exercicio3_3 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		char tipoVinho = ' ';
		int quantidadeC = 0;
		int quantidadeM = 0;
		int quantidadeT = 0;
		int quantidadeTotal = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		while (tipoVinho != 'F') {
			System.out.println("Digite o tipo de vinho (C, M ou T / F para parar): ");
			tipoVinho = leia.next().charAt(0);
			if (tipoVinho == 'F') {
				break;
			}else if (tipoVinho == 'C') {
				quantidadeC ++;
			} else if (tipoVinho == 'M') {
				quantidadeM ++;
			} else if (tipoVinho == 'T') {
				quantidadeT ++;
			}
			
			quantidadeTotal ++;	
		}
			
		// 4 - saida de dados
		System.out.println("Quantidade total de vinhos: " + quantidadeTotal);
		System.out.println("Quantidade total de Cabernet Savion: " + quantidadeC);
		System.out.println("Quantidade total de Malbec: " + quantidadeM);
		System.out.println("Quantidade total de Tanat: " + quantidadeT);
	}

}
