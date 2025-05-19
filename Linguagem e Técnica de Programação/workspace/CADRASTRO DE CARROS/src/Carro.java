import java.io.*;

public class Carro {

	char 	ativo;
	String	codCarro;
	String 	marca;
	String 	modelo;
	char 	fabricacao;
	String 	origemMarca;
	String 	categoria;
	float 	motorizacao;
	int		potencia;
	float 	peso;
	float 	preco;
	String 	mesAnoFab;
	
	static String marcas[] = {"TOYOTA","HONDA","VOLKSWAGEN","CHEVROLET","FIAT","HYUNDAI","BMW","MERCEDES BENS","RENAULT","JEEP"};
	static String origens[] = {"JAPÃO","JAPÃO","ALEMANHA","EUA","ITÁLIA","COREIA DO SUL","ALEMANHA","ALEMANHA","FRANÇA","EUA"};

	public long pesquisarCarro(String Pesq) {	
		// metodo para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try { 
			RandomAccessFile arqCarro = new RandomAccessFile("CARROS.DAT", "rw");
			while (true) {
				posicaoCursorArquivo  = arqCarro.getFilePointer();	// posicao do inicio do registro no arquivo
				ativo		 = arqCarro.readChar();
				codCarro     = arqCarro.readUTF();
				marca 		 = arqCarro.readUTF();
				modelo       = arqCarro.readUTF();
				fabricacao	 = arqCarro.readChar();
				origemMarca  = arqCarro.readUTF();
				categoria	 = arqCarro.readUTF();
				motorizacao	 = arqCarro.readFloat();
				potencia	 = arqCarro.readInt();
				peso		 = arqCarro.readFloat();
				preco		 = arqCarro.readFloat();
				mesAnoFab	 = arqCarro.readUTF();
				

				if ( Pesq.equals(codCarro) && ativo == 'S') {
					arqCarro.close();
					return posicaoCursorArquivo;
				} 
			}
		}catch (EOFException e) {
			return -1; // registro nao foi encontrado
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
			return -1;
		}
	}

	public void salvarCarro() {	
		// metodo para incluir um novo registro no final do arquivo em disco
		try {
			RandomAccessFile arqCarro = new RandomAccessFile("CARROS.DAT", "rw");	
			arqCarro.seek(arqCarro.length());  // posiciona o ponteiro no final do arquivo (EOF)
			arqCarro.writeChar(ativo);
			arqCarro.writeUTF(codCarro);
			arqCarro.writeUTF(marca);
			arqCarro.writeUTF(modelo);
			arqCarro.writeChar(fabricacao);
			arqCarro.writeUTF(origemMarca);		
			arqCarro.writeUTF(categoria);
			arqCarro.writeFloat(motorizacao);
			arqCarro.writeInt(potencia);
			arqCarro.writeFloat(peso);
			arqCarro.writeFloat(preco);
			arqCarro.writeUTF(mesAnoFab);
			arqCarro.close();
			System.out.println("Dados gravados com sucesso! \n");
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
		}
	}

	public void desativarCarro (long posicao)	{    
		// metodo para alterar o valor do campo ATIVO para N, tornando assim o registro excluido
		try {
			RandomAccessFile arqCarro = new RandomAccessFile("CARROS.DAT", "rw");			
			arqCarro.seek(posicao);
			arqCarro.writeChar('N');   // desativar o registro antigo
			arqCarro.close();
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
		}
	}

	 // ***********************   INCLUSAO   *****************************
	public void incluir() {
		String codCarroChave;
		char confirmacao;
		long posicaoRegistro;

		do {
			do {
				Main.leia.nextLine();
				System.out.println("\n ***************  INCLUSÃO DE CARROS  ***************** ");
				System.out.print("Digite o código do carro (FIM para encerrar): ");
				codCarroChave = Main.leia.nextLine();
				if (codCarroChave.equals("FIM")) {
					break;
				}
				posicaoRegistro = pesquisarCarro(codCarroChave);

				if (posicaoRegistro >= 0) {
					System.out.println("Código de carro já cadastrado, digite outro valor\n");
				}
			}while (posicaoRegistro >= 0);

			if (codCarroChave.equals("FIM")) {
				break;
			}

			ativo = 'S';
			codCarro = codCarroChave;
			System.out.print("Digite a marca do carro........................: ");
			marca = Main.leia.nextLine();
			System.out.print("Digite o modelo do carro.......................: ");
			modelo = Main.leia.nextLine();	    	
			System.out.print("Digite o tipo de fabricação (N ou I)...........: ");
			fabricacao = Main.leia.next().charAt(0);
			Main.leia.nextLine();
			System.out.print("Digite o país de origem da marca...............: ");
			origemMarca = Main.leia.nextLine();
			System.out.print("Digite a categoria do carro....................: ");
			categoria = Main.leia.nextLine();
			System.out.print("Digite a motorização do carro (lts)............: ");
			motorizacao = Main.leia.nextFloat();
			System.out.print("Digite a potencia do carro (cv)................: ");
			potencia = Main.leia.nextInt();
			System.out.print("Digite o peso do carro (kg)....................: ");
			peso = Main.leia.nextFloat();
			System.out.print("Digite o preço do carro (R$)...................: ");
			preco = Main.leia.nextFloat();
			Main.leia.nextLine();
			System.out.print("Digite a data de fabricação (MM/AAAA)..........: ");
			mesAnoFab = Main.leia.nextLine();

			do {
				System.out.print("\nConfirma a gravacao dos dados (S/N)? ");
				confirmacao = Main.leia.next().charAt(0);
				if (confirmacao == 'S') {
					salvarCarro();
				}
			}while (confirmacao != 'S' && confirmacao != 'N');

		}while ( ! codCarroChave.equals("FIM"));	    
	}


	/* //************************  ALTERACAO  *****************************
	public void alterar() {
		String codCarroChave;
		char confirmacao;
		long posicaoRegistro = 0;
		byte opcao;

		do {
			do {
				Main.leia.nextLine();
				System.out.println("\n ***************  ALTERAÇÃO DE CARROS  ***************** ");
				System.out.print("Digite o código do carro que deseja alterar (FIM para encerrar ): ");
				codCarroChave = Main.leia.nextLine();
				if (codCarroChave.equals("FIM")) {
					break;
				}

				posicaoRegistro = pesquisarCarro(codCarroChave);
				if (posicaoRegistro == -1) {
					System.out.println("Matricula nao cadastrada no arquivo, digite outro valor\n");
				}
			}while (posicaoRegistro == -1);

			if (codCarroChave.equals("FIM")) {
				break;
			}

			ativo = 'S';

			do {
				System.out.println("[ 1 ] Marca....................: " + marca);
				System.out.println("[ 2 ] Modelo...................: " + modelo);
				System.out.println("[ 3 ] Fabricação...............: " + fabricacao);
				System.out.println("[ 4 ] Origem da Marca..........: " + origemMarca);
				System.out.println("[ 5 ] Categoria................: " + categoria);
				System.out.println("[ 6 ] Motorização..............: " + motorizacao);
				System.out.println("[ 7 ] Potência.................: " + potencia);
				System.out.println("[ 8 ] Peso.....................: " + peso);
				System.out.println("[ 9 ] Preço....................: " + preco);
				System.out.println("[ 10 ] Data de fabricação......: " + mesAnoFab);

				do{
					System.out.println("Digite o numero do campo que deseja alterar (0 para finalizar as alterações): ");
					opcao = Main.leia.nextByte();
				}while (opcao < 0 || opcao > 4);

				switch (opcao) {
				case 1:
					Main.leia.nextLine();
					System.out.print  ("Digite o NOVO NOME do Aluno..................: ");
					nomeAluno = Main.leia.nextLine();
					break;
				case 2: 
					Main.leia.nextLine();
					System.out.print  ("Digite a NOVA DATA de Nascimento (DD/MM/AAAA): ");
					dtNasc = Main.leia.nextLine();
					break;
				case 3:
					System.out.print  ("Digite o NOVO VALOR da mensalidade...........: ");
					mensalidade = Main.leia.nextFloat();
					break;
				case 4: 
					System.out.print  ("Digite o NOVO sexo do Aluno (M/F)............: ");
					sexo = Main.leia.next().charAt(0);
					break;
				}
				System.out.println();
			}while (opcao != 0);  		

			do {
				System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
				confirmacao = Main.leia.next().charAt(0);
				if (confirmacao == 'S') {
					desativarAluno(posicaoRegistro);
					salvarAluno();
					System.out.println("Dados gravados com sucesso !\n");
				}
			}while (confirmacao != 'S' && confirmacao != 'N');

		}while ( ! matricula.equals("FIM"));
	}


	//************************  EXCLUSAO  *****************************
	public void excluir() {
		String matriculaChave;
		char confirmacao;
		long posicaoRegistro = 0;

		do {
			do {
				Main.leia.nextLine();
				System.out.println(" ***************  EXCLUSAO DE ALUNOS  ***************** ");
				System.out.print("Digite a Matricula do Aluno que deseja excluir ( FIM para encerrar ): ");
				matriculaChave = Main.leia.nextLine();
				if (matriculaChave.equals("FIM")) {
					break;
				}

				posicaoRegistro = pesquisarAluno(matriculaChave);
				if (posicaoRegistro == -1) {
					System.out.println("Matricula nao cadastrada no arquivo, digite outro valor\n");
				}
			}while (posicaoRegistro == -1);

			if (matriculaChave.equals("FIM")) {
				System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
				break;
			}

			System.out.println("Nome do aluno.......: " + nomeAluno);
			System.out.println("Data de nascimento..: " + dtNasc);
			System.out.println("Valor da mensalidade: " + mensalidade);
			System.out.println("Sexo do aluno.......: " + sexo);
			System.out.println();

			do {
				System.out.print("\nConfirma a exclusao deste aluno (S/N) ? ");
				confirmacao = Main.leia.next().charAt(0);
				if (confirmacao == 'S') {
					desativarAluno(posicaoRegistro);
				}
			}while (confirmacao != 'S' && confirmacao != 'N');

		}while ( ! matricula.equals("FIM"));
	}
*/
	//************************  CONSULTA  *****************************
	public void consultar() 	{
		RandomAccessFile arqCarro;
		byte opcao;
		String codCarroChave;
		String marcaAux;
		float precoAuxMax;
		float precoAuxMin;
		String dataFabAux;
		long posicaoRegistro;

		do {
			do {
				System.out.println(" ***************  CONSULTA DE CARROS  ***************** ");
				System.out.println(" [1] LISTA DE TODOS OS CARROS DE 1 MARCA ");
				System.out.println(" [2] LISTA DE TODOS OS CARROS DE UM ANO DE FABRICAÇÃO ESPECÍFICO ");
				System.out.println(" [3] LISTA DE TODOS OS CARROS DE UMA MESMA FAIXA DE PREÇO ");
				System.out.println(" [4] LISTA DE TODOS OS CARROS ");
				System.out.println(" [0] SAIR");
				System.out.print("\n Digite a opção desejada: ");
				opcao = Main.leia.nextByte();
				if (opcao < 0 || opcao > 4) {
					System.out.println("Opção inválida, digite novamente.\n");
				}
			}while (opcao < 0 || opcao > 4);

			switch (opcao) {
			case 0:
				System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
				break;

			case 1: 
				Main.leia.nextLine();  // limpa buffer de memoria
				System.out.print("Digite a marca desejada: ");
				marcaAux = Main.leia.nextLine();
				
				try { 
					arqCarro = new RandomAccessFile("CARROS.DAT" , "rw");
					imprimirCabecalho();
					while (true) {
						ativo 		= arqCarro.readChar();
						codCarro 	= arqCarro.readUTF();
						marca 		= arqCarro.readUTF();
						modelo 		= arqCarro.readUTF();
						fabricacao	= arqCarro.readChar();
						origemMarca = arqCarro.readUTF();		
						categoria 	= arqCarro.readUTF();
						motorizacao = arqCarro.readFloat();
						potencia    = arqCarro.readInt();
						peso 		= arqCarro.readFloat();
						preco 		= arqCarro.readFloat();
						mesAnoFab 	= arqCarro.readUTF();
						if (marcaAux.equals(marca) && ativo == 'S') {
							imprimirCarro();
						}
					}
				// arqCarro.close();	
				} catch (EOFException e) {
					System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
					Main.leia.nextLine();
					codCarroChave = Main.leia.nextLine();
				} catch (IOException e) { 
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
				break;

			case 2: 
				Main.leia.nextLine(); 
				System.out.print("Digite o ano de fabricação desejado: ");
				dataFabAux = Main.leia.nextLine();
				
				try { 
					arqCarro = new RandomAccessFile("CARROS.DAT" , "rw");
					imprimirCabecalho();
					while (true) {
						ativo 		= arqCarro.readChar();
						codCarro 	= arqCarro.readUTF();
						marca 		= arqCarro.readUTF();
						modelo 		= arqCarro.readUTF();
						fabricacao	= arqCarro.readChar();
						origemMarca = arqCarro.readUTF();		
						categoria 	= arqCarro.readUTF();
						motorizacao = arqCarro.readFloat();
						potencia    = arqCarro.readInt();
						peso 		= arqCarro.readFloat();
						preco 		= arqCarro.readFloat();
						mesAnoFab 	= arqCarro.readUTF();
						if (dataFabAux.equals(mesAnoFab.substring(3)) && ativo == 'S') {
							imprimirCarro();
						}
					}
					//    arqCarro.close();
				} catch (EOFException e) {
					System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
					Main.leia.nextLine();
					codCarroChave = Main.leia.nextLine();
				} catch (IOException e) { 
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
				break;

			case 3:  // imprime carros de uma mesma faixa de preço
				System.out.print("Digite o preço mínimo: ");
				precoAuxMin = Main.leia.nextFloat();
				System.out.print("Digite o preço máximo: ");
				precoAuxMax = Main.leia.nextFloat();

				try { 
					arqCarro = new RandomAccessFile("CARROS.DAT" , "rw");
					imprimirCabecalho();
					while (true) {
						ativo 		= arqCarro.readChar();
						codCarro 	= arqCarro.readUTF();
						marca 		= arqCarro.readUTF();
						modelo 		= arqCarro.readUTF();
						fabricacao	= arqCarro.readChar();
						origemMarca = arqCarro.readUTF();		
						categoria 	= arqCarro.readUTF();
						motorizacao = arqCarro.readFloat();
						potencia    = arqCarro.readInt();
						peso 		= arqCarro.readFloat();
						preco 		= arqCarro.readFloat();
						mesAnoFab 	= arqCarro.readUTF();
						if (precoAuxMin <= preco && preco <= precoAuxMax && ativo == 'S') {
							imprimirCarro();
						}
					}
					//arqCarro.close();
				} catch (EOFException e) {
					System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
					Main.leia.nextLine();
					codCarroChave = Main.leia.nextLine();
				} catch (IOException e) { 
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
				break;


			case 4:
				try { 
					arqCarro = new RandomAccessFile("CARROS.DAT" , "rw");
					imprimirCabecalho();
					while (true) {
						ativo 		= arqCarro.readChar();
						codCarro 	= arqCarro.readUTF();
						marca 		= arqCarro.readUTF();
						modelo 		= arqCarro.readUTF();
						fabricacao	= arqCarro.readChar();
						origemMarca = arqCarro.readUTF();		
						categoria 	= arqCarro.readUTF();
						motorizacao = arqCarro.readFloat();
						potencia    = arqCarro.readInt();
						peso 		= arqCarro.readFloat();
						preco 		= arqCarro.readFloat();
						mesAnoFab 	= arqCarro.readUTF();
						if ( ativo == 'S') {
							imprimirCarro();
						}
					}
					//    arqCarro.close();
				} catch (EOFException e) {
					System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
					Main.leia.nextLine();
					codCarroChave = Main.leia.nextLine();
				} catch (IOException e) { 
					System.out.println("Erro na abertura do arquivo - programa será finalizado");
					System.exit(0);
				}
				break;
			}
			

		} while ( opcao != 0 );
	}

	public void imprimirCabecalho () {
		System.out.println("--CÓDIGO CARRO--      --MARCA--      --MODELO--      --ORIGEM--"
				+ "      --FABRICAÇÃO--      --CATEGORIA--      --MOTORIZAÇÃO--      --POTÊNCIA--"
				+ "      --PESO--     --PREÇO--      --DATA DE FABRICAÇÃO--");
	}

	public void imprimirCarro () {
		System.out.println("    " +	formatarString(codCarro, 17 ) + "  " +
				formatarString(marca, 13) + "  " + 
				formatarString(modelo, 15) + "  " + 
				formatarString(origemMarca, 18 )  + "  " +
				formatarString(Character.toString(fabricacao), 16) + "  " +
				formatarString(categoria, 19)  + "  " +
				formatarString(String.valueOf(motorizacao), 18) + "  " + 
				formatarString(String.valueOf(potencia), 12) + "  " + 
				formatarString(String.valueOf(peso), 11) + "  " + 
				formatarString(String.valueOf(preco), 19) + "  " + 
				formatarString(mesAnoFab, 10) + "  ")  ; 
	}

	public static String formatarString (String texto, int tamanho) {	
		// retorna uma string com o numero de caracteres passado como parametro em TAMANHO
		if (texto.length() > tamanho) {
			texto = texto.substring(0,tamanho);
		}else{
			while (texto.length() < tamanho) {
				texto = texto + " ";
			}
		}
		return texto;
	}
}
