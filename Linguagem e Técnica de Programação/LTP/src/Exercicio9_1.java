import java.util.*;
public class Exercicio9_1 {

	public static void main(String[] args) {
		// 1 - variaveis
		String dataNascimento;
		String dataHoje;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite a data de nascimento: ");
		dataNascimento = leia.next();
		
		System.out.print("Digite a data de hoje: ");
		dataHoje = leia.next();
		
		// 3 - saida de dados
		System.out.println("Idade: " + calcularIdade(dataNascimento, dataHoje));
		
	}
	
	// 4 - metodo
	public static int calcularIdade (String nascimento, String hoje) {
		int idade;
		int anoNasc, anoHoje;
		int mesNasc, mesHoje;
		int diaNasc, diaHoje;
		
		anoNasc = Integer.parseInt(nascimento.substring(6));
		anoHoje = Integer.parseInt(hoje.substring(6));
		
		idade = anoHoje - anoNasc;
		
		mesHoje = Integer.parseInt(hoje.substring(3,5));
		mesNasc = Integer.parseInt(hoje.substring(3,5));
		
		diaHoje = Integer.parseInt(hoje.substring(1,3));
		diaNasc = Integer.parseInt(hoje.substring(1,3));
		
		if (mesNasc > mesHoje) {
			idade --;
		} else if (diaNasc > diaHoje && mesNasc == mesHoje) {
			idade --;
		}				
		
		return idade;
	}

}
