package catalogo;

public class Personagem {
	private int id;
	private String nome;
	private String classe;
	private String raca;
	private double preco;
	private String urlImagem;
	 
	 public Personagem() {}
	 
	 public Personagem(int id, String nome, String classe, String raca, double preco, String urlImagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.classe = classe;
		this.raca = raca;
		this.preco = preco;
		this.urlImagem = urlImagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	 
}
