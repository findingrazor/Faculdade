import java.util.List;
import java.util.ListIterator;

public class Paralelo extends Thread {
	private int elemento;
	private int lista[];
	private boolean encontrado = false;
	private List<Paralelo> listaThreads;
	
	public Paralelo(int elemento, int[] lista) {
		super();
		this.elemento = elemento;
		this.lista = lista;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setListaThreads(List<Paralelo> listaThreads) {
		this.listaThreads = listaThreads;
	}
	
	public void run() {
		for(int e : lista) {
			if(this.isInterrupted()) break;
			if(e == this.elemento) {
				for(Paralelo thread : listaThreads) {
					if(thread != Thread.currentThread()) thread.interrupt();
				}
				this.encontrado = true;
				break;
			}
		}
	}
}
