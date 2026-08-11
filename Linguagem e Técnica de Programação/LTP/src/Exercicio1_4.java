import java.util.*;
public class Exercicio1_4 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		float distancia;
		float tempo;
		float velocidade;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		System.out.print("Digite a distancia (km): ");
		distancia = leia.nextFloat();
		System.out.print("Digite o tempo (hrs): ");
		tempo = leia.nextFloat();
		
		// 3 - calculos
		velocidade = distancia / tempo;
		
		// 4 - saida de dados 
		System.out.println("Velocidade do veículo (km/h): " + velocidade);
		

	}

}
