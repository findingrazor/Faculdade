<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="catalogo.Personagem" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Editar Personagem</title>
</head>
<body>
 <h2>Editar Personagem do Catálogo</h2>
 <%
 // Pega o produto que o Servlet enviou
 Personagem p = (Personagem) request.getAttribute("personagemEditar");
 %>
 
 <form action="atualizar" method="POST">
 <input type="hidden" name="id" value="<%= p.getId() %>">
 
 <label>Nome do Personagem:</label><br>
 <input type="text" name="nome" value="<%= p.getNome() %>" required><br><br>
 
 <label>Classe:</label><br>
 <textarea name="descricao" rows="3"><%= p.getClasse() %></textarea><br><br>
 
 <label>Raça:</label><br>
 <textarea name="descricao" rows="3"><%= p.getRaca() %></textarea><br><br>
 
 <label>Preço (R$):</label><br>
 <input type="number" step="0.01" name="preco" value="<%= 
String.valueOf(p.getPreco()).replace(",", ".") %>" required><br><br>
 
 <label>URL da Imagem do Personagem:</label><br>
 <input type="url" name="urlImagem" value="<%= p.getUrlImagem() != null ? p.getUrlImagem() : "" %>"><br><br>
 
 <button type="submit">Salvar Alterações</button>
 <a href="vitrine">Cancelar</a>
 </form>
</body>
</html>