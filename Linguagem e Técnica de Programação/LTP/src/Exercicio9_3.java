import java.util.*;
public class Exercicio9_3 {

	public static void main(String[] args) {
		// 1 - variaveis
		String horarioInicial;
		String horarioFinal;
		int horasInicial = 0, horasFinal = 0;
		int minutosInicial = 0, minutosFinal = 0;
		float vlrConta;
		float somaConta = 0;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		do {
			do {
				do {
					System.out.print("Digite o horário inicial da chamada "
							+ "(Formato hrs e min / 00:00) (FIM para encerrar a digitação): ");
					horarioInicial = leia.nextLine();

					if (horarioInicial.equalsIgnoreCase("fim")) {
						break;
					}
				} while (!horaEhValida(horarioInicial));
				
				if (horarioInicial.equalsIgnoreCase("fim")) {
					break;
				}
				
				do {
					System.out.print("Digite o horário final da chamada "
							+ "(Formato hrs e min / 00:00) (deve ser maior que o horário inicial): ");
					horarioFinal = leia.nextLine();

				} while (!horaEhValida(horarioFinal));

				// 3 - calculos
				
				horasInicial = Integer.parseInt(horarioInicial.substring(0, 2));
				minutosInicial = Integer.parseInt(horarioInicial.substring(4));
				horasFinal = Integer.parseInt(horarioFinal.substring(0, 2));
				minutosFinal = Integer.parseInt(horarioFinal.substring(4));

				if (horasInicial > horasFinal || horasInicial == horasFinal && minutosInicial >= minutosFinal) {
					System.out.println("Horas inválidas, o horario final deve ser maior que o inicial! ");
				}
				
			}while (horasInicial > horasFinal || horasInicial == horasFinal && minutosInicial >= minutosFinal);

			if (horarioInicial.equalsIgnoreCase("fim")) {
				break;
			}
			
			vlrConta = calcularValorConta(horasInicial, horasFinal, minutosInicial, minutosFinal);
			System.out.println("Valor da conta: " + vlrConta);
			somaConta = somaConta + vlrConta;

		} while (!horarioInicial.equalsIgnoreCase("Fim"));

		// 4 - saida de dados
		System.out.println("Valor total da conta: " + somaConta);

	}	
	
	
	// 5 - metodos
	public static float calcularValorConta (int horaIn, int horaFim, int minIn, int minFim) {
		int minutos;
		float vlrConta;
		
		minutos = ((horaFim - horaIn) * 60) + (minFim - minIn);
		
		if (horaIn < 6) {
			vlrConta = minutos * 0.10f;
		} else if (horaIn < 8) {
			vlrConta = minutos * 0.15f;
		} else if (horaIn < 18) {
			vlrConta = minutos * 0.20f;
		} else {
			vlrConta = minutos * 0.15f;
		}
		
		return vlrConta;
	}
	
	public static boolean horaEhValida (String horario) {
		int hora;
		int minuto;
		
		if (horario.length() != 5 || horario.charAt(2) != ':') {
			System.out.println("Horário inválido, digite 5 caracteres no formato HH:MM! ");
			return false;
		}
		
		try {
			hora = Integer.parseInt(horario.substring(0, 2));
			minuto = Integer.parseInt(horario.substring(3));
		} catch (NumberFormatException e) {
			System.out.println("Horário inválido, digite hora e minuto numérico! ");
			return false;
		}
		
		if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
			System.out.println("Hora inválida, digite hora entre 0 e 23 e minuto entre 0 e 59! ");
			return false;
		}
		
		return true;
	}

}
