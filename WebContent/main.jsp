<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="arrecadacaoLista.jsp">
	
		<input type="submit" value="Arrecadacao">
	</form>

	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="contatoLista.jsp">
	
		<input type="submit" value="Contato">
	</form>
	
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="doacaoMonetariaLista.jsp">
	
		<input type="submit" value="Doacao">
	</form>
	
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="endrecoLista.jsp">
	
		<input type="submit" value="Endereco">
	</form>
	
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="oficinaLista.jsp">
	
		<input type="submit" value="Oficina">
	</form>
	
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="pessoaFisicaLista.jsp">
	
		<input type="submit" value="Pessoa Física">
	</form>
	
	<form action="AppController" method="get">
		
		<input type="hidden" name="tela" value="pessoaJuridicaLista.jsp">
	
		<input type="submit" value="Pessoa Jurídica">
	</form>

</body>
</html>