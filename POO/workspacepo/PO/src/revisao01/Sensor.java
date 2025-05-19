package revisao01;

public interface Sensor {
	public final static String unidadeTemperatura = "Celsius";
	
	public abstract void ativar();
	
	public abstract void desativar();
	//REDUNDANCIA COLOCAR ABSTRACT NOS METODOS DA INTERFACE
}
