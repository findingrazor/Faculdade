package trabalho;

public class Moto extends Veículo implements Alugavel {
	//atributos
	private int cilindrada;
	
	//contrutor
	
	public Moto() {
		super();
		
	}

	public Moto(String modelo, String marca, int ano, double precoDiaria, int cilindrada) {
		super(modelo, marca, ano, precoDiaria);
		setCilindrada(cilindrada);
	}

	//getters e setters
	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	//métodos	
	public void exibirDetalhes() {
		System.out.println("Veículo Cadastrado: "
				+ "\nMarca: " + getMarca()
				+ "\nModelo: " + getModelo()
				+ "\nAno: " + getAno()
				+ "\nPreço Diária: " + getPrecoDiaria()
				+"\nCilindradas: " + getCilindrada());
	}
	@Override
	public double calcularAluguel(int dias) {
		double vlrTotal;
		
		vlrTotal = dias * getPrecoDiaria();
		return vlrTotal;
	}
	
	public double calcularAluguel (float desconto) {
		double vlrTotal;
		
		vlrTotal = (desconto/100) * calcularAluguel(10);
		return vlrTotal;
	}

}
