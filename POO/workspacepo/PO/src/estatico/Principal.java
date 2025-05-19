package estatico;

public class Principal {

	public static void main(String[] args) {
		Estatico.setEstatico(9);		
		System.out.println("Valor do estatico: " + Estatico.getEstatico());
		
		Estatico obj1 = new Estatico();
		obj1.setNaoEstatico(5);
		System.out.println("obj1 = " + obj1);
		
		Estatico obj2 = new Estatico();
		obj2.setNaoEstatico(12);
		// obj2.setEstatico(150); !errado não chama o obj e sim a classe
		Estatico.setEstatico(150);
		
		System.out.println("obj2 = " + obj2);
		System.out.println("obj1 = " + obj1);

	}

}
