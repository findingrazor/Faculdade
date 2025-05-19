import java.util.*;
public class Exercicio9_4 {

	public static void main(String[] args) {
		// 1 - variaveis
		String placa;
		String dataMulta;
		float vlrMulta;
		float somaMultas = 0;
		int cont = 0;
		float menorVlrMulta = 99999;
		boolean erro;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		do {
			do {
				System.out.print("Digite a placa do veículo (formato XXX9999 / FIM p encerrar): ");
				placa = leia.next();
				
				if (placa.equalsIgnoreCase("FIM")) {
					break;
				}
				erro = false;
				
				if (placa.length() != 7) {
					System.out.println("Tamanho inválido, a placa deve ter 7 dígitos! ");
					erro = true;
				} else {
					for (byte x = 0; x <= 6; x++) {
						if (x < 3) {
							if (placa.charAt(x) < 'A' || placa.charAt(x) > 'Z') {
								System.out.println("Placa inválida, os 3 primeiros caracteres devem ser letras maiúsculas! ");
								erro = true;
								break;
							}
						} else {
							if (placa.charAt(x) < '0' || placa.charAt(x) > '9') {
								System.out.println("Placa inválida, os 4 últimos caracteres devem ser números! ");
								erro = true;
								break;
							}
						}
					}
				}
						
			} while (erro);
			
			if (placa.equalsIgnoreCase("FIM")) {
				break;
			}
			
			do {
				System.out.print("Digite a data da multa: ");
				dataMulta = leia.next();
				
			} while (!dataEhValida(dataMulta));
			
			do {
				System.out.print("Digite o valor da multa: ");
				vlrMulta = leia.nextFloat();
				
				if (vlrMulta <= 0) {
					System.out.println("Valor inválido, a multa deve ter um valor acima de 0! ");
				}
				
			} while (vlrMulta <= 0);
			
			// 3 - calculos
			somaMultas = somaMultas + vlrMulta;
			cont ++;
			if (vlrMulta < menorVlrMulta) {
				menorVlrMulta = vlrMulta;
			}
			
			
		} while (!placa.equalsIgnoreCase("FIM"));
		
		// 4 - saida de dados
		System.out.println("Soma dos valores das multas: " + somaMultas);
		System.out.println("Valor médio das multas: " + somaMultas / cont);
		System.out.println("Valor da menor multa: " + menorVlrMulta);

	}
	
	// 5 - metodo
	public static boolean dataEhValida (String data) {
		int dia, mes, ano;

		if (data.length() != 10 || data.charAt(2) != '/' ||  data.charAt(5) != '/' ) {
			System.out.println("Data inválida, a data deve ter 10 caracteres no formato DD/MM/AAAA");
			return false;
		}

		try {
			dia = Integer.parseInt(data.substring(0, 2));
			mes = Integer.parseInt(data.substring(3, 5));
			ano =  Integer.parseInt(data.substring(6));
		} catch (NumberFormatException e) {
			System.out.println("Data inválida, o dia, mes e ano devem ser números");
			return false;
		}

		if (ano > 2024) {
			System.out.println("Ano inválido, digite um ano menor ou igual a 2024! ");
			return false;
		}

		if (mes < 1 || mes > 12) {
			System.out.println("Mês inválido, digite um mês entre 1 e 12! ");
			return false;
		}

		if (dia < 1 || dia > 31) {
			System.out.println("Dia inválido, digite um dia entre 1 e 31! ");
			return false;
		}

		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
			System.out.println("Data inválida, para os meses 4, 6, 9 e 11 o dia deve ser entre 1 e 30! ");
			return false;
		}

		if (mes == 2) {
			if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
				if (dia > 29) {
					System.out.println("Data inválida, para ano bissexto e mes 2, o dia deve ser entre 1 e 29! ");
					return false;
				} else {
					if (dia > 28) {
						System.out.println("Data inválida, para mes 2, o dia deve ser entre 1 e 28! ");
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
