
public class PetersonN extends Thread{
	private volatile boolean wantCS[];
	private volatile int turn[][];
	private boolean bloqueada = false;
	private boolean executando = false;
	
	public PetersonN(int num) {
		super();
		this.wantCS = new boolean [num];
		this.turn = new int[num][num];
		for (int i = 0; i < num ; i++) { 
			wantCS[i] = false;
			for (int j = 0; j < num ; j++) {
				turn[i][j] = 0;
			}
		}	
	}

	public void requestCS(int i) {
	    wantCS[i] = true;
	    for (int j = 0; j < wantCS.length; j++) {
	        if (i == j) {continue;}
	        
	        turn[Math.min(i, j)][Math.max(i, j)] = j;
	        
	        while (wantCS[j] && turn[Math.min(i, j)][Math.max(i, j)] == j) {
	        	bloqueada = true; 	
	        }
	        bloqueada = false;
	    }
	    executando = true;
	}
	
	public void releaseCS(int i) {
		wantCS[i] = false;
		bloqueada = false;
		executando = false;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public boolean isExecutando() {
		return executando;
	}	
}
