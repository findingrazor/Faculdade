package aula;

public class Endereco {
	//atributos
	public String cep;
	public String rua;
	public int numero;
	public String bairro;
	public boolean ativo;
	
	//contrutores
	public Endereco() {
		super();
		this.ativo = true;
		System.out.println("eu estou construíndo pela superclass");
	}

	public Endereco(String cep, String rua, int numero, String bairro) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", ativo="
				+ ativo + "]";
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAtivo() { //is = boolean
		return ativo;
	}
	
	
	
}
