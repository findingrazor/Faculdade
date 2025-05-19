package trabalho;

import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		//Veículo modelo = new Veículo("Prisma", "Chevrolet", 2021, 2, 0);
		
		Carro modelo1 = new Carro("Prisma", "Chevrolet", 2021, 400, 4);
		Moto modelo2 = new Moto("R6", "Yamaha", 2025, 700, 100);
		modelo1.exibirDetalhes();
		modelo2.exibirDetalhes();
	}

}
