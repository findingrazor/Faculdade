
public class MergeSort extends Thread {
	private int vetor[];
	private int esquerda;
	private int direita;
	
	public MergeSort(int[] vetor, int esquerda, int direita) {
		super();
		this.vetor = vetor;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public void run() {
		if(esquerda < direita) {
			int meio = 	esquerda + (direita - esquerda) / 2;
			
			MergeSort t1 = new MergeSort(vetor, esquerda, meio);
			MergeSort t2 = new MergeSort(vetor, meio + 1, direita);
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				System.out.println("Erro " + e + " durante o bloqueio das threads\n");
			}
			
			int tamSubVetor1 = meio - esquerda + 1;
			int tamSubVetor2 = direita - meio;
			
			int[] subVetor1 = new int[tamSubVetor1];
			int[] subVetor2 = new int[tamSubVetor2];
			
			for (int i = 0; i < tamSubVetor1; ++i) {
	            subVetor1[i] = vetor[esquerda + i];
	        }
	        for (int j = 0; j < tamSubVetor2; ++j) {
	        	subVetor2[j] = vetor[meio + 1 + j];
	        }
	        
	        int i = 0, j = 0;
	        int k = esquerda;
	        
	        while (i < tamSubVetor1 && j < tamSubVetor2) {
	            if (subVetor1[i] <= subVetor2[j]) {
	                vetor[k] = subVetor1[i];
	                i++;
	            } else {
	                vetor[k] = subVetor2[j];
	                j++;
	            }
	            k++;
	        }
	        
	        while (i < tamSubVetor1) {
	            vetor[k] = subVetor1[i];
	            i++;
	            k++;
	        }
	        
	        while (j < tamSubVetor2) {
	            vetor[k] = subVetor2[j];
	            j++;
	            k++;
	        }

		}

	}
}
