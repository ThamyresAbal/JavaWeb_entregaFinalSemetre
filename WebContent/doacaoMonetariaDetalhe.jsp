<%@page import="negocio.DoacaoMonetaria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doacao</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
<%
	DoacaoMonetaria d = (DoacaoMonetaria)request.getAttribute("doacao");
%>
<form action = "DoacaoMonetariaController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->	
		<h3>Nome Atividade</h3>
		<input type="text" name="nomeAtividade" value="<%=d == null ? "" : d.getNomeAtividade()%>">
		
		<h3>Data Atividade</h3>
		<input type="text" name="dataAtividade" value="<%=d == null ? "" : d.getDataAtividade()%>">
		
	    <h3>Hora</h3>
		<input type="text" name="hora" value="<%=d == null ? "" : d.getHora()%>">
		
		<h3>Categoria</h3>
		<input type="text" name="categoria" value="<%=d == null ? "" : d.getCategoria()%>">
		
		<h3>Descrição</h3>
		<input type = "text" name="descricao" value="<%=d == null ? "" : d.getDescricao()%>">
		
		<h3>Valor Doacao</h3>
		<input type="text" name="valorDoacao" value="<%=d == null ? "" : d.getValorDoacao()%>">>
		
		<h3>Meta Arrecadação</h3>
		<input type="text" name="metaArrecadacao" value="<%=d == null ? "" : d.getMetaArrecadacao()%>">>
		
		<h3>Valor Arrecadado</h3>	
		<input type="text" name="valorArrecadado" value="<%=d == null ? "" : d.getValorArrecadado()%>">>
		
		<hr>
		<input type = "submit" value = "Cadastrar">
	</form>
</body>
</html>
</body>
</html>