<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
 <%
 	String user = request.getParameter("nome");
 	if (user == null) user = "World";
 %>
 	<h1>Hello JSP</h1>
 	<p>Hello, <%= user %></p>
</body>
</html>