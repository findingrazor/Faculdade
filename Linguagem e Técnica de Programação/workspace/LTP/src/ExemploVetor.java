import java.util.*;
public class ExemploVetor {
public static void main(String[] args) {
	
	// 1 – Declaração e inicialização de variáveis
	int x; // contador
	String nomes[] = new String[10];
	float notas[] = new float[10];
	Scanner leia = new Scanner(System.in);
	
	// 2 – Entrada de dados
	for (x = 0; x <= 9; x++) {
		System.out.print("Digite o nome " + x + ": ");
		nomes[x] = leia.nextLine();
		System.out.print("Digite a nota " + x + ": ");
		notas[x] = leia.nextFloat();
	}
}

}