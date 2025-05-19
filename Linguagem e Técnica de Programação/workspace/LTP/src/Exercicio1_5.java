import java.util.*;
class Exercicio1_5 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float pe;
		float polegada;
		float cm;
		float jarda;
		float milha;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite a medida em pes: ");
		pe = leia.nextFloat();
		
		// 3 - calculos 
		polegada = 12 * pe;
		cm = (float) 2.54 * polegada;
		jarda = pe / 3;
		milha = jarda / 1760;
		
		// 4 - saida de dados
		System.out.println("Polegadas: " + polegada);
		System.out.println("Centimetros: " + cm);
		System.out.println("Jardas: " + jarda);
		System.out.println("Milhas: " + milha);

	}

}
