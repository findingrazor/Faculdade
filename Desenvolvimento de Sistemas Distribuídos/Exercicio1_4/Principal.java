import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int tamanho = 0;
		int elemento = 0;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("----------- MERGE SORT MULTITHREAD -----------\n");
		System.out.println("\nPor favor, digite o tamanho do vetor que se deseja organizar: ");
		tamanho = leia.nextInt();
		
		int[] vetor = new int[tamanho];
		
		for(int i = 0; i < tamanho; i++) {
			System.out.println("\nPor favor, digite o elemento "+ (i+1) +" do vetor: ");
			elemento = leia.nextInt();
			vetor[i] = elemento;
		}
		
		System.out.println("Vetor original: " + Arrays.toString(vetor));
		
		MergeSort t = new MergeSort(vetor, 0, vetor.length - 1);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("Erro " + e + " durante o bloqueio das threads\n");
		}
		
		System.out.println("Vetor organizado: " + Arrays.toString(vetor));
		
	}

}
