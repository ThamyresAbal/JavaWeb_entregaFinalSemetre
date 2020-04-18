<%@page import="negocio.Endereco"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Endereco</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
<%
	List <String> listaUF = (List<String>)request.getAttribute("listaUF");
	Endereco e = (Endereco)request.getAttribute("endereco");
%>
	<form action = "EnderecoController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->
		
		<h3>Rua</h3>
		<input type="text" name="rua" value="<%=e == null ? "" : e.getRua()%>">
		
		<h3>Complemento</h3>
		<input type="text" name="complemento" value="<%=e == null ? "" : e.getComplemento()%>">
		
	    <h3>Bairro</h3>
		<input type="text" name="bairro" value="<%=e == null ? "" : e.getBairro()%>">
		
		<h3>Cidade</h3>
		<input type="text" name="cidade" value="<%=e == null ? "" : e.getCidade()%>">
		
		<h3>UF</h3>
		<select name ="uf" value="<%=e == null ? "" : e.getUf()%>">
			<% for(String uf : listaUF){ %>
			
			<option><%=uf %></option>
			<%} %>
		</select>
		
		<h3>Cep</h3>
		<input type="text" name="cep" value="<%=e == null ? "" : e.getCep()%>">
		
		<hr>
		<input type = "submit" value = "Cadastrar">
                                            
	</form>

</body>
</html>