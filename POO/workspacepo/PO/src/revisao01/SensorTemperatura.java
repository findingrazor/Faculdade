package revisao01;

public class SensorTemperatura extends SensorBase implements Sensor {
	private double temperaturaAtual;
	
	public SensorTemperatura(String localizacao, double limiteAlerta, int idSensor, double temperaturaAtual) {
		super(localizacao, limiteAlerta, idSensor);
		this.setTemperaturaAtual(temperaturaAtual);
	}
	
	
	public double getTemperaturaAtual() {
		return temperaturaAtual;
	}
	public void setTemperaturaAtual(double temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
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
		this.setTemperaturaAtual(30);
		System.out.println("Temperatura atual atulizada: " + this.getTemperaturaAtual());
	}
	
	public void coletarDados (double temperaturaManual) {
		this.setTemperaturaAtual(temperaturaManual);
		System.out.println("Temperatura atual atulizada: " + this.getTemperaturaAtual());
	}

}
