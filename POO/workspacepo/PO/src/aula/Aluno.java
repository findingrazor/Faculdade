package aula;

import java.util.Set;

public class Aluno extends Pessoa {
	//atributos
	private String curso;
	private int periodo;
	
	//construtor (constroi objeto)
	public Aluno(String nome, int matricula, Endereco end, String curso, int periodo) {
		super(nome, matricula, end);
		this.setCurso(curso);
		this.setPeriodo(periodo); //não precisa do this
	}
	
	//getters e setters
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	@Override
	public void exibirDetalhes(String nome) {
		System.out.println("Aluno " + nome + "Seja bem-vindo. ");
		
	}

	@Override
	public String toString() {
		return "Aluno [getCurso()=" + getCurso() + ", getPeriodo()=" + getPeriodo() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
}
