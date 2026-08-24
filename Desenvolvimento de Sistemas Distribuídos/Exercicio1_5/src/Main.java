import java.util.LinkedList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Random rand = new Random();
		
		for (int i = 0; i < 10000; i++) {
            list.add(0);
        }
		
		int randomNum = rand.nextInt(10000);
		list.set(randomNum, 1);

	}

}
