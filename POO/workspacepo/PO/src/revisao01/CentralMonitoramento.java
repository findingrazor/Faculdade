package revisao01;

public final class CentralMonitoramento {

	public static void main(String[] args) {
		SensorTemperatura sensor1 = new SensorTemperatura("BH", 6, 13, 24);
		SensorUmidade sensor2 = new SensorUmidade("SP", 10, 22, 24);
		
		sensor1.ativar();
		sensor2.ativar();
		
		sensor1.coletarDados();
		sensor1.coletarDados(25);
		
		sensor2.coletarDados();
		sensor2.coletarDados(100);
		
		sensor1.status();
		sensor2.status();
	}

}
