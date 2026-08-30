import java.util.LinkedList;
import java.util.ListIterator;

public class PesquisaDireita extends Thread {
	private LinkedList<Integer> lista = new LinkedList<>();
	private boolean encontrado = false;
	private int elemento;
	private PesquisaEsquerda colega;
	
	
	public PesquisaDireita(LinkedList<Integer> lista, int elemento) {
		super();
		this.lista = lista;
		this.elemento = elemento;
	}
	
	public boolean isEncontrado() {
		return encontrado;
	}

	public void setColega(PesquisaEsquerda colega) {
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
