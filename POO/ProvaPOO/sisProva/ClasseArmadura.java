package sisProva;

import java.util.Scanner;

public class ClasseArmadura extends Equipamento {
	private String tipoProtecao;
	
	public ClasseArmadura(String codigo, String nome, int durabilidade, double valor, String tipoProtecao) {
		super(codigo, nome, durabilidade, valor);
		setTipoProtecao(tipoProtecao);
	}
	
	
	public String getTipoProtecao() {
		return tipoProtecao;
	}
	public void setTipoProtecao(String tipoProtecao) {
		Scanner leia = new Scanner(System.in);
		while(tipoProtecao.isBlank()) {
			System.out.println("Tipo de proteção inválido, por favor, digite uma proteção que seja não nula");
			System.out.println("Digite o tipo de proteção: ");
			tipoProtecao = leia.next();
		}
		this.tipoProtecao = tipoProtecao;
	}
	private void settipoProtecao(String tipoProtecao) {//Amanda - não pode ter dois métodos idênticos, vai quebrar a regra da sobrecarga. 
		this.tipoProtecao = tipoProtecao;
	}


	@Override
	public void descrever() {
		System.out.println("Nome: " + getNome() + " Tipo de Proteção: " + getTipoProtecao());
	}
	
	@Override
	public void usar() {
		System.out.println("Defesa ativada!");
		setDurabilidade(getDurabilidade()-1);
	}

}
