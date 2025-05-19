package estatico;

import java.util.Scanner;

public class Estatico {
	//atributos
	private int naoEstatico = 0;
	private static int estatico = 0;
	public final int id = 100;
	
	//construtor
	public Estatico() {
		super();
		this.naoEstatico ++;
		Estatico.estatico ++;
		//id = 10; constante n altera, pode atribuir o valor depois, mas so atribui uma vez
	}
	
	//getters e setters
	public int getNaoEstatico() {
		return naoEstatico;
	}

	public void setNaoEstatico(int naoEstatico) {
		this.naoEstatico = naoEstatico;
	}

	public static int getEstatico() {
		return estatico;
	}

	public static void setEstatico(int estatico) {
		Estatico.estatico = estatico;
	}

	@Override
	public String toString() {
		return "naoEstatico = " + naoEstatico + " estatico = " + getEstatico();
	}
	
	
	
}
