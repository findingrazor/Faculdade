package trabalho;
import java.util.Scanner;

public abstract class Veículo {
	
		//atributos
		private String modelo;
		private String marca; 
		private int ano;
		private double precoDiaria;
		
		
		//construtor
		public Veículo(String modelo, String marca, int ano, double precoDiaria) {
			super();
			setModelo(modelo);
			setMarca(marca);
			setAno(ano);
			setPrecoDiaria(precoDiaria); //não permite alteração do atributo
		}	
		
		public Veículo() {
			super();
			
		}

		//métodos

		//getters e setters
		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public double getPrecoDiaria() {
			return precoDiaria;
		}
		
		public void setPrecoDiaria (double precoDiaria) {
			this.precoDiaria = precoDiaria;
		}

		
		public void setprecoDiaria (double precoDiaria){
			Scanner leia = new Scanner (System.in);
			//nesse caso é melhor o while, pois com o do ele vai pedir a digitação pelo menos uma vez mesmo que o user ja tenha digitado
			//se não passar parâmetro usar do while (a variável teria que ser passada dentro do set)
			
			/*while (precoDiaria < 0) {
				System.out.println("Preço inválido, por favor, digite um preço acima de $0");
				System.out.println("Digite o preço da diária: ");
				precoDiaria = leia.nextDouble();
			}*/
			
			//do
			
			do {
				System.out.println("Digite o preço da diária: ");
				precoDiaria = leia.nextDouble();
				
				if (precoDiaria < 0) {
					System.out.println("Preço inválido, por favor, digite um preço acima de $0");
				}
			} while (precoDiaria < 0);
			
			//atribuir a variável
			this.precoDiaria = precoDiaria;
		}
		
		//toString	
		@Override
		public String toString() {
			return "Veículo [getModelo()=" + getModelo() + ", getMarca()=" + getMarca() + ", getAno()=" + getAno()
					+ ", getPrecoDiaria()=" + getPrecoDiaria() + "]";
		}

		public abstract void exibirDetalhes();
		
		// do while: executa uma ou mais vezes
		//while: executa zero ou mais vezes
}


