package sisProva;

public final class InventarioJogo {

	public static void main(String[] args) {
		ClasseArma arma = new ClasseArma("13", "Razor", 22, 6.0, 100);
		ClasseArmadura armadura = new ClasseArmadura("22", "Karira", 13, 6.0, "Manto Invisível");
		
		//teste das validações
		//ClasseArma arma = new ClasseArma("", "", 0, 0, 0, "");
		//ClasseArmadura armadura = new ClasseArmadura("", "", 0, 0, "");
		
		arma.usar();
		arma.usar("Lâmina Flamenjante");
		arma.verificarDurabilidade();
		arma.descrever();
		arma.inspecionar();
		
		armadura.usar();
		armadura.verificarDurabilidade();
		armadura.descrever();
		armadura.inspecionar();

	}

}
