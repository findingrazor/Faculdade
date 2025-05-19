package sisProva;

import java.util.Scanner;

public class ClasseArma extends Equipamento {
	private int dano;
	
	public ClasseArma(String codigo, String nome, int durabilidade, double valor, int dano) {
		super(codigo, nome, durabilidade, valor);
		setDano(dano);
	}
	
	


	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		Scanner leia = new Scanner(System.in);
		while(dano<=0) {
			System.out.println("Dano inválido, por favor, digite um valor possitivo");
			System.out.println("Digite o dano: ");
			dano = leia.nextInt();
		}
		this.dano = dano;
	}
	private void setdano(int dano) {//Amanda - não pode ter dois métodos idênticos, vai quebrar a regra da sobrecarga. 
		this.dano = dano;
	}
	

	@Override
	public void descrever() {
		System.out.println("Nome: " + getNome() + " Dano: " + getDano());
	}
	
	@Override
	public void usar() {
		System.out.println("Ataque realizado!");
		setDurabilidade(getDurabilidade()-1);
	}
	
	public void usar(String habilidade) {
		System.out.println("Habilidade especial: " + habilidade);
		setDurabilidade(getDurabilidade()-2);
	}

}
