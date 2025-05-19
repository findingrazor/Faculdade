package aula;

public class Principal {

	public static void main(String[] args) {
		//instanciar objetos
		//Endereco endereco = ;
		Aluno aluno = new Aluno("Amanda", 1226, new Endereco(), "Computação", 3);
		
		System.out.println("Aluno" + aluno);
		System.out.print("Endereço aluno " + aluno.end.getRua());
		
		System.out.println("Aluno" + aluno.toString());
		
		/*Pessoa professor = new Pessoa("Prof Amanda");
		
		System.out.println("Professor " + professor);
		aluno.setNome("Testando"); 
		System.out.println("Nome: " + aluno.getNome());
		//como nome é privado, o get é usado pra pegar ela e tornar publica
		System.out.println("Professor" + aluno.toString());*/
//		System.out.println("Nome: " + aluno.nome);
		//"Fernando", 7852, new Endereco()

	}

}
