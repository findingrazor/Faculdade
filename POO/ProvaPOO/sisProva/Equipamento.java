package sisProva;
import java.util.*;

public abstract class Equipamento implements Utilizavel {
	private final String codigo; //atribuir no construtor
	private String nome;
	private int durabilidade;
	private double valor;/
	
	
	public Equipamento(String codigo, String nome, int durabilidade, double valor) {
		super();
		this.codigo = codigo;
		this.setNome(nome);
		this.setDurabilidade(durabilidade);;
		this.setValor(valor);;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		Scanner leia = new Scanner(System.in);
		while(nome.isBlank()) {
			System.out.println("Nome inválido, por favor, digite um nome não nulo");
			System.out.println("Digite o nome: ");
			nome = leia.next();
		}
		
		this.nome = nome;
	}
	private void setnome(String nome) { //Amanda - não pode ter dois métodos idênticos, vai quebrar a regra da sobrecarga. 
		this.nome = nome;
	}

	

	public int getDurabilidade() {
		return durabilidade;
	}
	
	public void setDurabilidade(int durabilidade) {
		Scanner leia = new Scanner(System.in);
		while(durabilidade<=0){
			System.out.println("Durabilidade inválida, por favor, digite um valor acima de 0");
			System.out.println("Digite a durabilidade: ");
			durabilidade = leia.nextInt();
		}
		
		this.durabilidade = durabilidade;
	}
	private void setdurabilidade(int durabilidade) {//Amanda - não pode ter dois métodos idênticos, vai quebrar a regra da sobrecarga. 
		this.durabilidade = durabilidade;
	}

	

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		Scanner leia = new Scanner(System.in);
		while(valor<VALOR_MINIMO) {
			System.out.println("Valor inválido, por favor, digite um valor maior que 1 (valor minimo)");
			System.out.println("Digite um valor: ");
			valor = leia.nextDouble();
		}
		
		this.valor = valor;
	}
	private void setvalor(double valor) {//Amanda - não pode ter dois métodos idênticos, vai quebrar a regra da sobrecarga. 
		this.valor = valor;
	}
	


	public String getCodigo() {
		return codigo;
	}

	public abstract void descrever();
	
	public final void inspecionar() {
		System.out.println("Nome: " + getNome() + " Durabilidade: " + getDurabilidade());
	}


	@Override
	public void usar() {
		setdurabilidade(getDurabilidade()-1);
	}

	@Override
	public void verificarDurabilidade() {
		if(this.durabilidade<=0) {
			System.out.println("Este equipamento não é utilizavel");
		} else {
			System.out.println("Este equipamento é utilizavel");
		}
	}

}
