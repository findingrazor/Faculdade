USE controlevendas;

CREATE TABLE cliente(
	
	codCliente int identity not null,
    nome varchar (30) not null,
    cpf char (11) not null,
    endereço varchar(40) null,
    telefone char(12) not null,
    email varchar (20) null
);

CREATE TABLE pedido(
	codPedido int identity not null,
    codCliente int not null,
    codPag int not null
);

CREATE TABLE pagamento(
	codPag int identity not null,
    formaPag varchar (11) not null
);

CREATE TABLE detalhes(
	codPedido int not null,
    codProduto int not null,
    qntdProd int not null,
	valorUni float not null,
    desconto float null,
    valorTotal float not null
);

CREATE TABLE produto(
	codProduto int identity not null,
    codMidia int not null,
    codGenero int not null,
    qntdEstoque int not null,
    preco float not null
);

CREATE TABLE midia(
	codMidia int identity not null,
    tipo varchar(5) not null
);

CREATE TABLE genero(
	codGenero int identity not null,
    genero varchar(7)
);

ALTER TABLE cliente ADD CONSTRAINT pk_cliente_codCliente PRIMARY KEY (codCliente);
ALTER TABLE pedido ADD CONSTRAINT pk_pedido_codPedido PRIMARY KEY (codPedido);
ALTER TABLE pagamento ADD CONSTRAINT pk_pagamento_codPag PRIMARY KEY (codPag);
ALTER TABLE detalhes ADD CONSTRAINT pk_detalhes_codPedCodProd PRIMARY KEY (codPedido, codProduto);
ALTER TABLE produto ADD CONSTRAINT pk_produto_codProduto PRIMARY KEY (codProduto);
ALTER TABLE midia ADD CONSTRAINT pk_midia_codMidia PRIMARY KEY (codMidia);
ALTER TABLE genero ADD CONSTRAINT pk_genero_codGenero PRIMARY KEY (codGenero);

ALTER TABLE pedido ADD CONSTRAINT fk_pedido_codCliente FOREIGN KEY (codCliente) REFERENCES cliente (codCliente);
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_codPag FOREIGN KEY (codPag) REFERENCES pagamento (codPag);
ALTER TABLE detalhes ADD CONSTRAINT fk_detalhes_codPedido FOREIGN KEY (codPedido) REFERENCES pedido (codPedido);
ALTER TABLE detalhes ADD CONSTRAINT fk_detalhes_codProduto FOREIGN KEY (codProduto) REFERENCES produto (codProduto);
ALTER TABLE produto ADD CONSTRAINT fk_produto_codMidia FOREIGN KEY (codMidia) REFERENCES midia (codMidia);
ALTER TABLE produto ADD CONSTRAINT fk_produto_codGenero FOREIGN KEY (codGenero) REFERENCES genero (codGenero);

ALTER TABLE cliente ADD CONSTRAINT uq_cliente_cpf UNIQUE (cpf);
ALTER TABLE pagamento ADD CONSTRAINT uq_pagamento_formaPag UNIQUE (formaPag);
ALTER TABLE midia ADD CONSTRAINT uq_midia_tipo UNIQUE (tipo);
ALTER TABLE genero ADD CONSTRAINT uq_genero_genero UNIQUE (genero);

ALTER TABLE cliente ADD CONSTRAINT df_cliente_email DEFAULT 'sememail@nada.com' FOR email;

ALTER TABLE detalhes ADD CONSTRAINT vlrTotal_ck CHECK (valorTotal > 0);

ALTER TABLE produto ADD produto varchar(40) not null;
