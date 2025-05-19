import java.util.*;
public class Exercicio9_2 {

	public static void main(String[] args) {
		// 1 - variaveis
		String codigo;
		boolean valido;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		do {
			System.out.print("Digite o código: ");
			codigo = leia.nextLine();
			valido = true;
			
			if (codigo.length() != 11) {
				System.out.println("O código deve conter 11 dígitos!");
				valido = false;
			} else {
				//try {
				//cod = Long.parseLong(codigo);
				//}catch (NumberFormatException e) {
				//System.out.println("Digitação inválida, o código deve conter apenas dígitos!");
				//}
				
				//for (byte x = 0; x <= 10; x++) {
				//if (Character.forDigit(codigo.charAt(x), 10) == -1){
				//System.out.println("Digitação inválida, o código deve conter apenas dígitos!");
				//break;
				//}	
				//}	
				
				for (byte x = 0; x <= 10; x++) {
					if (codigo.charAt(x) < '0' || codigo.charAt(x) > '9'){
						System.out.println("Digitação inválida, o código deve conter apenas dígitos!");
						valido = false;
						break;
					}	
				}
			}

			leia.nextLine();
		} while (! valido);
		
		// 3 - saida de dados
		if (calcularDigVerif(codigo).equals(codigo.substring(9))) {
			System.out.println("Dígitos corretos");
		} else {
			System.out.println("Dígitos inválidos");
		}

	}

	// 4 - metodos
	public static String calcularDigVerif (String codigo) {
		int soma = 0;
		int multiplicacao = 1;
		int numero;
		String multStr;
		String digito1;
		String digito2;		

		for (byte x = 0; x <= 10; x++) {
			numero = Character.forDigit(codigo.charAt(x), 10);
			soma = soma + numero;
			
			// soma = soma + Integer.parseInt(codigo.substring(x,x+1));
			
			multiplicacao = multiplicacao * numero;
		}
		
		digito1 = String.valueOf(soma / 10);
		
		multStr = String.valueOf(multiplicacao);
		digito2 = multStr.substring(multStr.length() - 1);
		
		//digito2 = "" + multStr.charAt(multStr.length() - 1);
		
		// digito2 = multiplicacao % 10;                                                                                                                                                              
		
		return digito1 + digito2;
		
		// digito1 + "" + digito2;
	}

}
