import java.util.LinkedList;

public class DoublyLinked extends Thread {
	LinkedList<Integer> list = new LinkedList<>();
	int position;
	boolean found = false;
	
	public DoublyLinked(LinkedList<Integer> list, int position) {
		this.list = list;
		this.position = position;
	}
	
	public void run() {
		
	}
}
