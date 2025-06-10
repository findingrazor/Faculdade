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
	codcontrato int NOT NULL,
	codformapgto int NOT NULL,
	dtvenc date NOT NULL,
	vlrparcela numeric NOT NULL,
	dtpgto date NULL
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
VALUES ('credito'), ('debito'), ('pix'), ('dinheiro');

--Contratrante = no mínimo 3 linhas
INSERT INTO contratante
VALUES ('Felipe Andrade', '11122233344', '988776655'),
	('Camila Rezende', '22233344455', '987665544'),
	('Gustavo Moreira', '33344455566', '986554433'),
	('Larissa Almeida', '44455566677', '985443322'),
	('Rodrigo Teixeira', '55566677788', '984332211'),
	('Beatriz Figueiredo', '66677788899', '983221100');

--Hóspede = no mínimo 10 linhas
INSERT INTO hospede
VALUES ('José Ferreira', '1971-03-15', '12345678901', '998765432', 'MG1234567890', 'M'),
	('Maria Aparecida', '1962-07-22', '23456789012', '997654321', 'SP2345678901', 'F'),
	('Antonio Barros', '1963-02-10', '34567890123', '996543210', 'RJ3456789012', 'M'),
	('Helena Ribeiro', '1964-05-18', '45678901234', '994321098', 'PR4567890123', 'F'),
	('Paulo Henrique', '1965-11-26', '56789012345', '994321098', 'BA567890123', 'M'),
	('Sandra Gomes',	'1966-01-26', '67890123456', '993210987', 'RS6789012345', 'F'),
	('Luiz Carlos', '1967-06-03', '78901234567', '992109876', 'SC7890123456', 'M'),
	('Fátima Duarte', '1968-04-14', '89012345678', '991098765', 'PE8901234567', 'F'),
	('Ricardo Souza', '1969-09-30', '90123456789', '990987654', 'CE9012345678', 'M'),
	('Tereza Machado', '1970-12-21', '01234567890', '989876543', 'DF0123456789', 'F');
	
	
--Contrato = no mínimo 15 linhas
INSERT INTO contrato 
VALUES (1, 1, '2021-04-01', '2021-10-01', 1600, 2),
	(2,2, '2021-09-10', '2021-10-10', 400, 2),
	(3,3, '2021-03-20', '2021-11-20', 1800, 2),
	(3,3, '2021-12-01', '2022-12-01', 2400, 3),
	(4,1, '2022-02-01', '2022-05-01', 800, 1),
	(5,2, '2022-03-01', '2022-09-01', 1400, 1),
	(1,1, '2022-06-01', '2022-12-01', 1200, 2),
	(8, 4, '2021-02-17', '2021-12-04', 2000.00, 2),
	(7, 5, '2021-06-20', '2021-08-29', 400.00, 2),
	(10, 6, '2021-01-01', '2021-02-10', 200.00, 2),
	(9, 6, '2021-05-23', '2021-08-21', 600.00, 3),
	(6, 4,'2021-01-10', '2021-05-15', 800.00, 3),
	(6, 4,'2021-07-10', '2021-10-15', 600.00, 3),
	(9, 6,'2021-09-01', '2021-12-25', 600.00, 3),
	(10, 6,'2022-07-10', '2022-12-18', 1000.00, 4);
	

--Parcelas = no mínimo 30 linhas
INSERT INTO parcela
VALUES (1,1, '2021-05-01', 800, '2021-05-01'),
	(1,1, '2021-06-01', 800, '2021-06-01'),
	(2,2, '2021-10-10', 200, '2021-09-20'),
	(2,2, '2021-11-10', 200, '2021-10-18'),
	(3,3, '2021-04-20', 900, '2021-04-06'),
	(3,3, '2021-05-20', 900, '2021-05-08'),
	(4,4, '2022-01-02', 800, null),
	(4,4, '2022-02-01', 800, null),
	(4,4, '2022-03-01', 800, null),
	(5,1,'2022-04-01', 800, null),
	(6,2, '2022-04-01', 1400, null),
	(7,3, '2022-07-01', 600, null),
	(7,3, '2022-08-01', 600, null),
	(8, 1, '2021-03-17', 1000.00, '2021-03-10'),
	(8, 1, '2021-04-17', 1000.00, '2021-04-08'),
	(9, 2, '2021-07-20', 200.00, '2021-07-12'),
	(9, 2, '2021-08-20', 200.00, '2021-08-02'),
	(10, 4, '2021-01-01', 100.00, '2021-01-01'),
	(10, 4, '2021-02-10', 100.00, '2021-02-10'),
	(11, 3, '2021-06-01', 200, '2021-05-17'),
	(11,3, '2021-07-01', 200, '2021-06-09'),
	(11,3, '2021-08-01', 200, '2021-07-03'),
	(12,4, '2021-01-10', 266.67, '2021-01-06'),
	(12, 4, '2021-02-10', 266.67, '2021-02-02'),
	(12, 4, '2021-03-10', 266.66, '2021-03-09'),
	(13,1, '2021-08-10', 200, '2021-08-02'),
	(13,1, '2021-09-10', 200, '2021-09-04'),
	(13,1, '2021-10-10', 200, '2021-09-30'),
	(14,2, '2021-10-01', 200, '2021-09-22'),
	(14,2, '2021-11-01', 200, '2021-10-18'),
	(14,2, '2021-12-01', 200, '2021-11-15'),
	(15, 3, '2022-08-10', 250, null),
	(15, 3, '2022-09-10', 250, null),
	(15, 3, '2022-10-10', 250, null),
	(15, 3, '2022-11-10', 250, null);

/*
++++++++++++++++++++++++++++++++++++++
III)COMANDOS SELECT
++++++++++++++++++++++++++++++++++++++
*/
--A)
SELECT C.codhospede AS 'Código do Hóspede', H.hospede AS 'Hóspede', C.codcontrato AS 'Código do Contrato', 
	CT.contratante AS 'Contratante', C.dtinicio AS 'Data de Início do Contrato', C.dtfim AS 'Data de Fim do Contrato',
	C.vlrtotal AS 'Valor Total do Contrato', C.qtdeparcelas AS 'Quantidade de Parcelas' 
	FROM contrato C INNER JOIN hospede H ON C.codhospede = H.codhospede
	INNER JOIN contratante CT ON C.codcontratante = CT.codcontratante
    WHERE C.codhospede IN (10, 9, 6, 1, 3)
	ORDER BY C.codcontrato DESC;
 
 
/*Léo fizemos a mesma consulta com subconsulta
SELECT C.codhospede AS 'Código do Hóspede', H.hospede AS 'Hóspede', C.codcontrato AS 'Código do Contrato', 
	CT.contratante AS 'Contratante', C.dtinicio AS 'Data de Início do Contrato', C.dtfim AS 'Data de Fim do Contrato',
	C.vlrtotal AS 'Valor Total do Contrato', C.qtdeparcelas AS 'Quantidade de Parcelas' 
	FROM contrato C INNER JOIN hospede H ON C.codhospede = H.codhospede
	INNER JOIN contratante CT ON C.codcontratante = CT.codcontratante
	WHERE C.codhospede IN (
    SELECT codhospede
    FROM contrato
    GROUP BY codhospede
    HAVING COUNT(*) > 1)
	ORDER BY C.codcontrato DESC;*/

--B)
SELECT MONTH(con.dtinicio) AS Mes, fp.formapgto AS 'Forma de Pgto', SUM(par.vlrparcela) AS 'Total das Parcelas'
FROM contrato con INNER JOIN parcela par ON con.codcontrato = par.codcontrato
	INNER JOIN formapgto fp ON par.codformapgto = fp.codformapgto
	INNER JOIN  hospede h ON con.codhospede = h.codhospede
WHERE YEAR(con.dtinicio) = 2021 AND h.sexo = 'F'
GROUP BY month(con.dtinicio), fp.formapgto
ORDER BY MONTH(con.dtinicio);



/*
++++++++++++++++++++++++++++++++++++++
IV)Criar uma VIEW à sua escolha que tenha um SELECT o mais complicado que você puder imaginar.
++++++++++++++++++++++++++++++++++++++
*/
CREATE VIEW vw_contratos_parcelas AS
SELECT ct.contratante AS 'Nome contratante',
    h.hospede AS 'Nome hospede',
    c.dtinicio AS 'Data inicio',
    c.dtfim AS 'Data fim',
    c.vlrtotal AS 'Valor Total',
    c.qtdeparcelas AS 'Total parcelas',
    p.dtvenc AS Vencimento,
    p.vlrparcela AS 'Valor Parcela',
    p.dtpgto AS 'Data de Pagamento',
    fp.formapgto AS 'Forma Pagamento',
    
    CASE 
        WHEN p.dtpgto IS NOT NULL THEN 'PAGA'
        WHEN p.dtvenc < '2021-12-31' THEN 'VENCIDA'
        ELSE 'PENDENTE'
    END AS 'Status',
    
    COUNT(p.codparcela) OVER (
        PARTITION BY c.codhospede, c.codcontratante, c.dtinicio
    ) AS 'Parcelas lançadas',
    
    COUNT(p.dtpgto) OVER (
        PARTITION BY c.codhospede, c.codcontratante, c.dtinicio
    ) AS 'Parcelas Pagas'

FROM contrato c
    INNER JOIN contratante ct ON c.codcontratante = ct.codcontratante
    INNER JOIN hospede h ON c.codhospede = h.codhospede
    LEFT  JOIN parcela p ON (c.codhospede = h.codhospede AND c.codcontrato = p.codcontrato)
    LEFT  JOIN formapgto fp ON p.codformapgto = fp.codformapgto;

/*
++++++++++++++++++++++++++++++++++++++
V)Fazer um UPDATE de algum dado da tabela hóspede
++++++++++++++++++++++++++++++++++++++
*/

UPDATE hospede
SET hospede = 'Luiz Carlos Andrade'
WHERE codhospede = 7;

/*
++++++++++++++++++++++++++++++++++++++
VI)Fazer um DELETE de um contrato finalizado
++++++++++++++++++++++++++++++++++++++
*/

--Deleta os registros do contrato na tabela parcela
DELETE FROM parcela
WHERE codcontrato = 1;
--Deleta o contrato da tabela contrato
DELETE FROM contrato
WHERE codcontrato = 1;

