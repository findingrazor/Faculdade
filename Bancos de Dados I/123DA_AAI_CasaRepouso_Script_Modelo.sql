/*
AUTO INSTRUCIONAL
Aluno: 
*/

/*
++++++++++++++++++++++++++++++++++++++
I)Criar as tabelas e as constraints
++++++++++++++++++++++++++++++++++++++
*/

--A)Cria as tabelas
CREATE TABLE hospede (
	codhospede int identity NOT NULL,
	hospede varchar(50) NOT NULL,
	dtnasc date NOT NULL,
	cpf char(11) NOT NULL,
	tel char (9) NULL,
	ci char (12) NOT NULL
);

CREATE TABLE contrato (
	codcontrato int identity NOT NULL,
	codhospede int NOT NULL,
	codcontratante int NOT NULL,
	dtinicio date NOT NULL,
	dtfim date NOT NULL,
	vlrtotal numeric NOT NULL,
	qtdeparcelas int NOT NULL
);

CREATE TABLE contratante (
	codcontratante int identity NOT NULL,
	contratante varchar(50) NOT NULL,
	cpf char(11) NOT NULL,
	tel char (9) NULL
);

CREATE TABLE parcela (
	codparcela int identity NOT NULL,
	codformapgto int NOT NULL,
	dtvenc date NOT NULL,
	vlrparcela numeric NOT NULL,
	dtpgto date NOT NULL
);

CREATE TABLE formapgto (
	codformapgto int identity NOT NULL,
	formapgto varchar(45) NOT NULL
);

--B)CRIA AS PKs
ALTER TABLE hospede ADD CONSTRAINT hospede_codhospede_pk PRIMARY KEY (codhospede);
ALTER TABLE contrato ADD CONSTRAINT contrato_codcontrato_pk PRIMARY KEY (codcontrato);
ALTER TABLE contratante ADD CONSTRAINT contratante_codcontratante_pk PRIMARY KEY (codcontratante);
ALTER TABLE parcela ADD CONSTRAINT parcela_codparcela_pk PRIMARY KEY (codparcela);
ALTER TABLE formapgto ADD CONSTRAINT formapgto_codformapgto_pk PRIMARY KEY (codformapgto);

--C)CRIA A FK
ALTER TABLE contrato ADD CONSTRAINT contrato_codhospede_fk FOREIGN KEY (codhospede) REFERENCES hospede (codhospede);
ALTER TABLE contrato ADD CONSTRAINT contrato_codcontratante_fk FOREIGN KEY (codcontratante) REFERENCES contratante (codcontratante);
ALTER TABLE parcela ADD CONSTRAINT parcela_codcontrato_fk FOREIGN KEY (codcontrato) REFERENCES contrato (codcontrato);
ALTER TABLE parcela ADD CONSTRAINT parcela_codformapgto_fk FOREIGN KEY (codformapgto) REFERENCES formapgto (codformapgto);

--D)Os campos codhospede e dtinicio não podem repetir
ALTER TABLE contrato ADD CONSTRAINT contrato_dtinicio_uq UNIQUE (dtinicio);

--E)O campo DT_INICIO da tabela contrato, deverá receber a data do dia da digitação do contrato
ALTER TABLE contrato ADD CONSTRAINT contrato_dtinicio_df DEFAULT GETDATE() FOR dtinicio;

--F)O campo DTNASC da tabela hóspede deverá ser maior ou igual a 1960 
ALTER TABLE hospede ADD CONSTRAINT hospede_dtnasc_ck CHECK(YEAR(dtnasc) > 1960);

--G)Na tabela hóspede incluir o campo SEXO com tipo CHAR de tamanho 1
ALTER TABLE hospede ADD sexo char(1) NOT NULL;

--H)O campo SEXO poderá receber apenas dois valores: M ou F
ALTER TABLE hospede ADD CONSTRAINT hospede_sexo_ck CHECK (sexo = 'M' OR sexo = 'F');


/*
++++++++++++++++++++++++++++++++++++++
II)Povoar as tabelas
++++++++++++++++++++++++++++++++++++++
*/

--Forma_Pgto = no mínimo 4 linhas
INSERT INTO formapgto
VALUES (1, 'credito'), (2, 'debito'), (3, 'pix'), (4, 'dinheiro');

--Contratrante = no mínimo 3 linhas
INSERT INTO contratante
VALUES (1, 'Felipe Andrade', '11122233344', '988776655'),
	(2, 'Camila Rezende', '22233344455', '987665544'),
	(3, 'Gustavo Moreira', '33344455566', '986554433'),
	(4, 'Larissa Almeida', '44455566677', '985443322'),
	(5, 'Rodrigo Teixeira', '55566677788', '984332211'),
	(6, 'Beatriz Figueiredo', '66677788899', '983221100');

--Hóspede = no mínimo 10 linhas
INSERT INTO hospede
VALUES (1, 'José Ferreira', '1971-03-15', '12345678901', '998765432', 'MG1234567890'),
	(2, 'Maria Aparecida', '1962-07-22', '23456789012', '997654321', 'SP2345678901'),
	(3, 'Antonio Barros', '1963-02-10', '34567890123', '996543210', 'RJ3456789012'),
	(4, 'Helena Ribeiro', '1964-05-18', '45678901234', '994321098', 'PR4567890123'),
	(5, 'Paulo Henrique', '1965-11-26', '56789012345', '9943210987', 'BA567890123'),
	(6,	'Sandra Gomes',	'1966-01-26', '67890123456', '993210987', 'RS6789012345'),
	(7, 'Luiz Carlos', '1967-06-03', '78901234567', '992109876', 'SC7890123456'),
	(8, 'Fátima Duarte', '1968-04-14', '89012345678', '991098765', 'PE8901234567'),
	(9, 'Ricardo Souza', '1969-09-30', '90123456789', '990987654', 'CE9012345678'),
	(10, 'Tereza Machado', '1970-12-21', '01234567890', '989876543', 'DF0123456789');
	
	
--Contrato = no mínimo 15 linhas

--Parcelas = no mínimo 30 linhas


/*
++++++++++++++++++++++++++++++++++++++
III)COMANDOS SELECT
++++++++++++++++++++++++++++++++++++++
*/
--A)


--B)


/*
++++++++++++++++++++++++++++++++++++++
IV)Criar uma VIEW à sua escolha que tenha um SELECT o mais complicado que você puder imaginar.
++++++++++++++++++++++++++++++++++++++
*/



/*
++++++++++++++++++++++++++++++++++++++
V)Fazer um UPDATE de algum dado da tabela hóspede
++++++++++++++++++++++++++++++++++++++
*/


/*
++++++++++++++++++++++++++++++++++++++
VI)Fazer um DELETE de um contrato finalizado
++++++++++++++++++++++++++++++++++++++
*/