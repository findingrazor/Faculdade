package revisao01;

public class SensorUmidade extends SensorBase implements Sensor {
	private double umidadeAtual; 
	
	public SensorUmidade(String localizacao, double limiteAlerta, int idSensor, double umidadeAtual) {
		super(localizacao, limiteAlerta, idSensor);
		this.setUmidadeAtual(umidadeAtual);
	}	
	
	public double getUmidadeAtual() {
		return umidadeAtual;
	}
	public void setUmidadeAtual(double umidadeAtual) {
		this.umidadeAtual = umidadeAtual;
	}

	@Override
	public void ativar() {
		this.setAtivo(true);
	}
	
	@Override
	public void desativar() {
		this.setAtivo(false);
	}
	
	@Override
	public void coletarDados() {
		this.setUmidadeAtual(70);
		System.out.println("Umidade atual atualizada: " + this.getUmidadeAtual());
	}
	
	public void coletarDados(double umidadeManual) {
		this.setUmidadeAtual(umidadeManual);
		System.out.println("Umidade atual atualizada: " + this.getUmidadeAtual());
	}

}
