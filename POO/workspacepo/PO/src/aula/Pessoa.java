package aula;
import java.util.Scanner;

public abstract class Pessoa {
	//atributos
	private String nome;
	public int matricula;
	public Endereco end = new Endereco();
	public Scanner leia = new Scanner(System.in);
	
	//construtores
	public Pessoa(String nome, int matricula, Endereco end) {
		super();
		System.out.println("Parâmetros completos");
		this.nome = nome;
		this.matricula = matricula;
		this.end = end; 
	}
	
	public Pessoa() {
		super();
		System.out.println("Construi sem parâmetros");
	}

	public Pessoa(String nome) {
		super();
		System.out.println("Passei apenas o nome da pessoa");
		this.nome = nome;
	}

	//métodos	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	private void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setMatricula() { //validar a matricula			
		int matricula;
		
		do {
			System.out.println("Matrícula: ");
			matricula = leia.nextInt();
			
			if (matricula < 0 || matricula > 10000) {
				System.out.println("Valor inválido, por favor, digite um número entre 0 e 10000");
			} 
		} while (matricula < 0 || matricula > 10000);
		setMatricula(matricula);
	}
	
	
	public abstract void exibirDetalhes(String nome);//abstract pq é classe
	//as filhas implementam
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", matricula=" + matricula + ", endereço=" + end + "]";
	}

	

}
