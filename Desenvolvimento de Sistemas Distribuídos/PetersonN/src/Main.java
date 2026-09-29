import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numThreads = 0;
		Scanner leia = new Scanner(System.in);
		 
		System.out.println("----------- PETERSON N THREADS -----------\n");
		System.out.println("\nPor favor, digite o número de Threads que disputarão a CS: ");
		numThreads = leia.nextInt();
		
	    PetersonN peterson = new PetersonN(numThreads);
	    Thread[] threads = new Thread[numThreads];

	        for (int i = 0; i < numThreads; i++) {
	            final int id = i;
	            int k = numThreads;
	            threads[i] = new Thread(() -> {
	            for (int j = 0; j < k; j++) {
	                    System.out.println("Thread " + id + " solicitando CS");
	                    peterson.requestCS(id);
	                    
	                    System.out.println("Thread " + id + " está executando a CS");
	                    peterson.releaseCS(id);
	                    
	                    System.out.println("Thread " + id + " liberou a CS");
	                }
	            });
	        }
	        for (Thread thread : threads) {
	            thread.start();
	        }
	        try {
	        	for (Thread thread : threads) {
		            thread.join();
		        }
			} catch(InterruptedException e) {
				System.out.println("Erro " + e + " durante o bloqueio das threads\n");
			}
	        System.out.println("Todas as threads finalizaram."); 
	}

}
