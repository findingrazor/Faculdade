package trabalho;

public class Carro extends Veículo implements Alugavel{
	//atributos
	private int quantidadePortas;
		
	//contrutores
	public Carro(String modelo, String marca, int ano, double precoDiaria,  int quantidadePortas) {
		super(modelo, marca, ano, precoDiaria);
		setQuantidadePortas(quantidadePortas);
	}
		
	public Carro() {
		super();
	}


	//getters e setters
	public int getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(int quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}
	
	//métodos
	public void exibirDetalhes() {
		System.out.println("Veículo Cadastrado: "
				+ "\nMarca: " + getMarca()
				+ "\nModelo: " + getModelo()
				+ "\nAno: " + getAno()
				+ "\nPreço Diária: " + getPrecoDiaria()
				+"\nQuantidade de Portas: " + getQuantidadePortas());
	}
	@Override
	public double calcularAluguel(int dias) {
		double vlrTotal;
		
		vlrTotal = dias * getPrecoDiaria();
		return vlrTotal;
	}

}
