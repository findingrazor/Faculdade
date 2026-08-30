import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<>();
		int elemento = 0; 
		Scanner leia = new Scanner(System.in);
		
		System.out.println("----------- BUSCA PELOS EXTREMOS -----------\n");
		System.out.println("\nPor favor, digite o número que se deseja buscar: ");
		elemento = leia.nextInt();
		
		for (int i = 0; i < 10000; i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt(10000);
            lista.add(randomNum);
            System.out.println(randomNum);
        }
		
		PesquisaDireita t1 = new PesquisaDireita(lista, 0);
		PesquisaEsquerda t2 = new PesquisaEsquerda(lista, 0);
		
		t1.setColega(t2);
		t2.setColega(t1);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			System.out.println("Erro " + e + " durante o bloqueio das threads\n");
		}
		
		// Teste
//		if(t1.isEncontrado())
//			System.out.println("Thread direta encontrou o elemento");
//		else
//			System.out.println("Thread direta não encontrou o elemento");
//		if(t2.isEncontrado())
//			System.out.println("Thread reversa encontrou o elemento");
//		else
//			System.out.println("Thread reversa não encontrou o elemento");
//		
		if(t1.isEncontrado() || t2.isEncontrado()) {
			System.out.println("O elemento " + elemento + " existe na lista\n");
		} else {
			System.out.println("O elemento " + elemento + " não existe na lista\n");
		}
	}

}
