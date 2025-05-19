package list;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTeste {

	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<String>();
		//lista em vetor indexada
		
		
		nomes.add("Fulano");
		nomes.add("Ciclano");
		nomes.add(0, "Beltrano");
		System.out.println(nomes);
		System.out.println(nomes.contains("Solano"));
		
		
		for(String item: nomes) {
			if(item == "Solano") {
				System.out.println("Encontrei");
			}
			System.out.println("Nome: " + item);
		}
		
		Collections.sort(nomes);
		nomes.forEach(item -> {
			System.out.println("Nome: " + item);
		});
		
		
	}

}
