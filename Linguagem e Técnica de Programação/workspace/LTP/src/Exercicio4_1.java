import java.util.*;
public class Exercicio4_1 {

	public static void main(String[] args) {
		
		// 1 - variaveis
		String nomeEmpregado;
		float salario;
		byte numeroDependentes;
		float novoSalario;
		float somaNovosSalarios = 0;
		byte contSalarioAcima1700 = 0;
		float mediaNovosSalarios;
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados 
		for (byte cont = 1; cont <= 10; cont ++) {
			System.out.print("Digite o nome do empregado: ");
			nomeEmpregado = leia.nextLine();
			System.out.print("Digite o salario do empregado: ");
			salario = leia.nextFloat();
			System.out.print("Digite o numero de dependentes: ");
			numeroDependentes = leia.nextByte();
			
			if (salario < 1000) {
				novoSalario = salario + salario * 0.30f;
			} else if (salario <= 2000) {
				novoSalario = salario + salario * 0.20f;
			} else {
				novoSalario = salario + salario * 0.10f;
			}
			
			novoSalario = novoSalario + numeroDependentes * 50;
			System.out.println("Novo salario: " + novoSalario);
			
			somaNovosSalarios = somaNovosSalarios + novoSalario;
			
			if (novoSalario > 1700) {
				contSalarioAcima1700 ++;
			}
			
			leia.nextLine();
		}
		
		// 3 - calculos 
		mediaNovosSalarios = somaNovosSalarios / 10;
		
		// 4 - saida de dados 
		System.out.println("Soma dos novos salarios: " + somaNovosSalarios);
		System.out.println("Media dos novos salarios: " + mediaNovosSalarios);
		System.out.println("Quantidade de empregados com salario maior que R$1700,00: " + contSalarioAcima1700);

	}

}
