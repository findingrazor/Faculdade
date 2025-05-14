import java.util.*;
public class Exercicio10_2 {

	public static void main(String[] args) {
		// 1 - variaveis
		String nome;
		String login;
		String senha;
		boolean erro;
		Scanner leia = new Scanner (System.in);
		
		// 2 - entrada de dados
		for (int x = 1; x <= 30; x ++) {
			do {
				System.out.print("Digite o nome (FIM p encerrar): ");
				nome = leia.nextLine().toUpperCase();

				if (nome.equalsIgnoreCase("FIM")) {
					break;
				}
				erro = true;
				if (nome.length() < 15) {
					System.out.println("Digitação inválida, por favor digite o nome completo ou um nome maior (min. 15 caracteres)! ");
					erro = false;
				} else if (nome.charAt(0) == ' ' || nome.charAt(nome.length() - 1) == ' ' ){
					System.out.println("Digitação inválida, não podem haver espaços antes nem depois do nome! ");
					erro = false;
				} else if (! nome.contains(" ")) {
					System.out.println("Digitação inválida, deve haver pelo menos 1 sobrenome! ");
					erro = false;
				} else if (nome.contains("   ")) {
					System.out.println("Digitação inválida, entre nome e sobrenome deve haver apenas um espaço! ");
				}
				for (byte y = 0; y < nome.length(); y++) {
					if ((nome.charAt(y) < 'A' || nome.charAt(y) > 'Z') && nome.charAt(y) != ' '){
						System.out.println("Digitação inválida, o nome deve conter apenas letras! ");
						erro = false;
					}
				}

				// 3 - saida de dados
				login = criarLogin(nome);
				senha = criarSenha(login);
				System.out.println("Login: " + login);
				System.out.println("Senha: " + senha);
			} while (! erro );


		}
	}


	public static String criarLogin (String nome) {
		String login = nome.substring(0,1);
		// String login = nome.charAt(0) + "";
		
		for (int x = 1; x < nome.length(); x++) {
			if (nome.charAt(x) == ' ') {
				login = login + nome.charAt(x+1);
			}
		}
		return login;
	}
	
	public static String criarSenha (String login) {
		String senha = "";
		int codDecCaracter;
		// String codDecimalString;
		
		for (int x = 1; x < login.length(); x++) {
			codDecCaracter = (int) login.charAt(x);
			codDecCaracter = codDecCaracter / 10;
			senha = senha + codDecCaracter;
			//codDecimalString = Srting.valueof(codDecimalString);
			// senha = senha + codDecimalString.charAt(0);
		}
		return senha;
	}

}