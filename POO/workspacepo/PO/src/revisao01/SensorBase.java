package revisao01;

import java.util.Scanner;

public abstract class SensorBase implements Sensor {
	private String localizacao;
	private boolean ativo;
	private double limiteAlerta;
	private final int idSensor;
	
	public SensorBase(String localizacao, double limiteAlerta, int idSensor) {
		super();
		this.setLocalizacao(localizacao);
		this.setAtivo(true);
		this.setLimiteAlerta(limiteAlerta);
		this.idSensor = idSensor; //NÃO TEM SET
	}
	
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setlocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		Scanner leia = new Scanner (System.in);
		do {
			System.out.println("Digite a localizacao: ");
			localizacao = leia.next();
			//PODERIA SER ISBLANK OU ISEMPTY (LENGHT = 0)
			if(localizacao.equalsIgnoreCase(" ")) {
				System.out.println("Digitacao invalida, por favor, digite uma localizacao nao nula");
			}
			//if(!localizacao.isBlank()) {
				//this.localizacao = localizacao;
			//} else com do dentro ou while
		}while(localizacao.equalsIgnoreCase(" "));
		
		this.localizacao = localizacao;
	}



	public boolean isAtivo() {
		return ativo;
	} //GET VIRA IS PQ É BOOLEAN
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}



	public double getLimiteAlerta() {
		return limiteAlerta;
	}
	public void setlimiteAlerta(double limiteAlerta) {
		this.limiteAlerta = limiteAlerta;
	}
	
	public void setLimiteAlerta(double limiteAlerta) {
		Scanner leia = new Scanner (System.in);
		do {
			System.out.println("Digite o limite da area: ");
			limiteAlerta = leia.nextDouble();
			
			if (limiteAlerta <= 0) {
				System.out.println("Digitacao invalida, por favor, digite um valor maior que 0");
			}
		}while(limiteAlerta <= 0);
		
		this.limiteAlerta = limiteAlerta;
	}



	public int getIdSensor() {
		return idSensor;
	} //NÃO TEM SET PQ É FINAL

	public abstract void coletarDados();

	@Override
	public void ativar() {
	}

	@Override
	public void desativar() {
	}
	
	public final void status() {
		System.out.println("Status [localizacao: " + localizacao + ", ativo: " + ativo + "]");
	} //+ ((isAtivo)) ? "Ativado" :"Desativado"));
	//isAtivo e getLocalização

}
