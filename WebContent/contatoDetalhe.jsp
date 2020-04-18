<%@page import="negocio.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contato Detalhe</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<%
	Contato c = (Contato)request.getAttribute("contato");
%>

	<form action = "ContatoController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->
		
		<h3>E-mail</h3>
		<input type="text" name="email" value="<%=c == null ? "" : c.getEmail()%>">
		
		<h3>Telefone</h3>
		<input type="text" name="telefone" value="<%=c == null ? "" : c.getTelefone()%>">>
		
	    <h3>Celular</h3>
		<input type="text" name="celular" value="<%=c == null ? "" : c.getCelular()%>">>
		
		<hr>
		<input type = "submit" value = "Cadastrar">
                                            
	</form>
</body>
</html>
</body>
</html>