package interfaceExemplo;

public interface ControleRemoto {
	public abstract void controlarVolume(int valor);
	public int verificarCanal();
	public void controlarCanal(int canal);
	
	public default void ligarDesligar(boolean ativo) {
		System.out.println("Situação :" + ativo);
	}
	
}
