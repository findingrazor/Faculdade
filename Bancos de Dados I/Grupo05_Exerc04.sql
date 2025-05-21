/*
Exercicio 04 - SELECT ATÉ HAVING

Nome: GRUPO 5 - Camila Fortes, Clarisse Amaral e Yanamel Ferreira

*/



--1)
SELECT C.cliente, SUM(P.vlrtotal_pedido) AS Total
FROM cliente C INNER JOIN pedido P ON C.codcliente = P.codcliente
WHERE C.pais = 'Germany' 
GROUP BY C.cliente
HAVING SUM(P.vlrtotal_pedido) > 1100



--2)
SELECT C.categoria, PR.produto, AVG(pd.preco_unit * pd.qtde - pd.desconto) AS Media
FROM categoria C INNER JOIN produto PR ON C.codcategoria = PR.codcategoria
	INNER JOIN pedido_detalhe PD ON PR.codproduto = PD.codproduto
	INNER JOIN pedido PE ON PE.codpedido = PD.codpedido
WHERE YEAR(PE.dt_pedido) = 1997  
GROUP BY PR.produto, C.categoria
HAVING AVG(pd.preco_unit * pd.qtde - pd.desconto)> 1000
ORDER BY Media;




--3)
SELECT Cl.pais, C.categoria, SUM(pd.preco_unit * pd.qtde * (1 - pd.desconto)) AS 'TotalGasto'
FROM cliente Cl INNER JOIN pedido P ON Cl.codcliente = P.codcliente
	INNER JOIN pedido_detalhe pd ON P.codpedido = pd.codpedido
	INNER JOIN produto pr ON pr.codproduto = pd.codproduto
	INNER JOIN categoria c ON c.codcategoria = pr.codcategoria
WHERE MONTH(P.dt_pedido) = 3 AND YEAR(P.dt_pedido) = 1997
GROUP BY Cl.pais, C.categoria
HAVING SUM(pd.preco_unit * pd.qtde * (1 - pd.desconto)) < 100
ORDER BY Cl.pais
