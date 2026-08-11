<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="catalogo.Personagem" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Vitrine do Catálogo</title>
<style>
	 body { font-family: Arial, sans-serif; padding: 20px; }
	 .container { display: flex; flex-wrap: wrap; gap: 20px; }
	 .card { 
	 border: 1px solid #ccc; 
	 border-radius: 8px; 
	 padding: 15px; 
	 background-color: #f9f9f9;
	 width: 280px;
	 box-shadow: 0 4px 6px rgba(0,0,0,0.1);
	 }
	 .foto-personagem {
	 width: 100%;
	 height: 180px;
	 object-fit: cover;
	 border-radius: 4px;
	 margin-bottom: 10px;
	 }
	 .preco { color: green; font-weight: bold; font-size: 18px; }
	 .btn-comprar {
	 display: block; text-align: center; padding: 10px;
	 background-color: #28a745; color: white;
	 text-decoration: none; border-radius: 5px; margin-top: 10px;
	 }
	 .btn-editar {
	 display: block; text-align: center; padding: 10px;
	 background-color: #28a745; color: white;
	 text-decoration: none; border-radius: 5px; margin-top: 10px;
	 }
	 .btn-apagar {
	 display: block; text-align: center; padding: 10px;
	 background-color: #28a745; color: white;
	 text-decoration: none; border-radius: 5px; margin-top: 10px;
	 }
</style>
</head>
<body>
 <h2>Catálogo</h2>
 <a href="novo-item.html"> + Cadastrar Novo Personagem</a>
 <hr><br>
 <div class="container">
 <%
 List<Personagem> personagens = (List<Personagem>) request.getAttribute("itens");
 
 if (personagens != null && !personagens.isEmpty()) {
 for (Personagem p : personagens) {
 %>
 <div class="card">
 <%-- Só exibe a imagem se o campo não estiver vazio no banco --%>
 <% if (p.getUrlImagem() != null && !p.getUrlImagem().trim().isEmpty()) { 
%>
 <img src="<%= p.getUrlImagem() %>" alt="<%= p.getNome() %>" 
class="foto-produto">
 <% } %>
 <h3><%= p.getNome() %></h3>
<p><%= p.getClasse() %></p>
<p><%= p.getRaca() %></p>
 <p class="preco">R$ <%= String.format("%.2f", p.getPreco()) %></p>

<div style="display: flex; gap: 10px; margin-top: 15px;">
 <a href="preparar-edicao?id=<%= p.getId() %>" class="btn-comprar" style="background-color: #007bff; flex: 1;">Editar</a>
 
 <a href="apagar?id=<%= p.getId() %>" class="btn-comprar" style="background-color: #dc3545; flex: 1;" 
 onclick="return confirm('Tem certeza que deseja remover este item do catálogo?');">Apagar</a>
</div>

 <a href="#" class="btn-comprar">Tenho Interesse</a>
 </div>
 <% }
 } else {
 %>
 <p>O catálogo ainda está vazio. Cadastre o primeiro personagem!</p>
 <%
 }
 %>
 </div>
</body>
</html>