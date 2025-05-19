/*
Exercicio 03 - SELECT ATÉ DUAS TABELAS

Nome:

*/

USE pedidos;

--1)
SELECT cliente FROM cliente WHERE cliente LIKE 'J%';


--2)
SELECT pais, cliente FROM cliente WHERE pais IN ('France','Mexico') ORDER BY pais, cliente ASC;


--3)
SELECT * FROM pedido WHERE vlrtotal_pedido IS NULL ORDER BY codpedido ASC; 


--4)
SELECT AVG(vlrtotal_pedido) AS 'Média' FROM pedido WHERE YEAR(dt_pedido) > 1997;


--5)
SELECT MIN(codpedido) AS 'Pedido Menor' FROM pedido;


--6)
SELECT codpedido, preco_unit, codproduto, qtde FROM pedido_detalhe WHERE qtde BETWEEN 100 AND 101 ORDER BY codproduto ASC;


--7)
SELECT COUNT(*) AS 'Qtde de Produtos' FROM produto WHERE codcategoria IN(3,5);


--8)
SELECT cliente, cidade FROM cliente WHERE cliente LIKE 'Mar%s' OR cidade IN ('London');


--9)
SELECT codcliente, codpedido, vlrtotal_pedido FROM pedido WHERE YEAR(dt_pedido)>=1998 AND MONTH(dt_pedido)>=4 AND (vlrtotal_pedido < 7.30 OR vlrtotal_pedido > 800);


--10)



--11)
SELECT C.cliente AS 'Cliente', C.tel AS 'Telefone', P.dt_pedido AS 'Data do Pedido', P.vlrtotal_pedido AS 'Valor Total'
FROM cliente C INNER JOIN pedido P ON  C.codcliente = P.codcliente WHERE (MONTH(P.dt_pedido) = 04 AND YEAR(P.dt_pedido) = 1996) OR P.vlrtotal_pedido > 800;


--12)
SELECT C.categoria AS 'Categoria', COUNT(P.produto) AS 'Total de Produtos' FROM categoria C INNER JOIN produto P ON C.codcategoria = P.codcategoria
WHERE P.preco_unit < 100 GROUP BY C.categoria;


--13)
SELECT C.cliente AS 'Cliente', SUM(P.vlrtotal_pedido) AS 'Total' FROM cliente C INNER JOIN pedido P ON C.codcliente = P.codcliente
WHERE YEAR(P.dt_pedido) = 1998 AND C.regiao IN('SP') GROUP BY C.cliente;


--14)
SELECT P.produto AS 'Produto', AVG(D.qtde) AS 'Qtde Média Vendida' FROM produto P INNER JOIN pedido_detalhe D ON P.codproduto = D.codproduto
WHERE D.preco_unit = 120 OR P.codcategoria IN(5) GROUP BY P.produto ORDER BY P.produto ASC;

--15)
SELECT P.codcliente AS 'Cód Cliente', PD.codproduto AS 'Cód Produto', ROUND(SUM((PD.preco_unit*PD.qtde)-PD.desconto),2) AS 'Total' FROM pedido P INNER JOIN pedido_detalhe PD ON P.codpedido = PD.codpedido
WHERE PD.qtde <= 3 AND (YEAR(P.dt_pedido) = 1997 AND MONTH(P.dt_pedido) = 12 AND DAY(P.dt_pedido) BETWEEN 15 AND 31) GROUP BY P.codcliente, PD.codproduto
ORDER BY PD.codproduto ASC;


--16)
SELECT C.pais AS 'País', C.cliente AS 'Cliente', COUNT(P.codpedido) AS 'Qtde de Pedidos' FROM cliente C INNER JOIN pedido P ON C.codcliente = P.codcliente 	
WHERE C.regiao IS NOT NULL OR (C.pais = 'Brazil' OR C.pais = 'France') GROUP BY C.cliente, C.pais ORDER BY C.pais ASC;