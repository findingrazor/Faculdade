import java.util.LinkedList;
import java.util.ListIterator;

public class PesquisaEsquerda extends Thread {
	private LinkedList<Integer> lista = new LinkedList<>();
	private boolean encontrado = false;
	private int elemento;
	private PesquisaDireita colega;
	
	
	public PesquisaEsquerda(LinkedList<Integer> lista, int elemento) {
		super();
		this.lista = lista;
		this.elemento = elemento;
	}
	
	public boolean isEncontrado() {
		return encontrado;
	}

	public void setColega(PesquisaDireita colega) {
		this.colega = colega;
	}

	public void run() {
		
		ListIterator<Integer> iterador = lista.listIterator(0);

		while(iterador.hasNext()) {	
			if(this.isInterrupted()) break;
				
			if(iterador.next() == this.elemento) {
				this.colega.interrupt();
				this.encontrado = true;
				break;
			}
		}
		
	}
}
