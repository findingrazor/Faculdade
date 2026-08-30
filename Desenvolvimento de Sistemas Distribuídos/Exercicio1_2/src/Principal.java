import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		int[] lista = new int[10000];
		int elemento = 0; 
		int numThreads = 0; 
		int resultado = 0;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("----------- BUSCA PARALELA -----------\n");
		System.out.println("\nPor favor, digite o número que se deseja buscar: ");
		elemento = leia.nextInt();
		System.out.println("\nPor favor, digite o número de threads para a busca: ");
		numThreads = leia.nextInt();
		
		for (int i = 0; i < 10000; i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt(10000);
	        lista[i] = randomNum;
	        System.out.println(randomNum);
	    }
		
		resultado = parallelSearch(elemento, lista, numThreads);
		
		if(resultado == 1) {
			System.out.println("O elemento " + elemento + " existe na lista\n");
		}else {
			System.out.println("O elemento " + elemento + " não existe na lista\n");
		}
	}
	
	public static int parallelSearch(int x, int[] A, int numThreads) {
		List<Paralelo> listaThreads = new ArrayList<>();
		int tamanho = A.length / numThreads;
		int resto = A.length % numThreads;
		int posicaoA = 0;
		int tamanhoParte = tamanho + 1;
		
		while(numThreads > 0) {
			if(resto > 0) {
				int[] listaParte = new int[tamanhoParte];
				for(int i = 0; i < tamanhoParte; i++) {
					listaParte[i] = A[posicaoA + i];
				}
				Paralelo t = new Paralelo(x, listaParte);
				listaThreads.addLast(t);
				posicaoA += tamanhoParte;
				numThreads --;
				resto --;
			} else {
				int[] listaParte = new int[tamanho];
				for(int i = 0; i < tamanho; i++) {
					listaParte[i] = A[posicaoA + i];
				}
				Paralelo t = new Paralelo(x, listaParte);
				listaThreads.addLast(t);
				posicaoA += tamanho;
				numThreads --;
			}
			
		}	
		
		for(Paralelo thread : listaThreads) {
			thread.setListaThreads(listaThreads);
		}
		
		for(Paralelo thread : listaThreads) {
			thread.start();
		}
		
		try {
			for(Paralelo thread : listaThreads) {
				thread.join();
			}
		} catch(InterruptedException e) {
			System.out.println("Erro " + e + " durante o bloqueio das threads\n");
		}
		
		// Teste
//		for(Paralelo thread : listaThreads) {
//			if(thread.isEncontrado()) System.out.println("Encontrado");
//			else System.out.println("Não encontrado");
//		}
		
		for(Paralelo thread : listaThreads) {
			if(thread.isEncontrado()) return 1;
		}
		
		return 0;
	}

}
