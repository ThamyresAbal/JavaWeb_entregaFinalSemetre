<%@page import="negocio.PessoaJuridica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoa Juridica</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
<% 
PessoaJuridica pJu= (PessoaJuridica)request.getAttribute("pessoa");
%>		
<form action = "PessoaJuridicaController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->
		<h3>Usuário</h3>
		<input type="text" name="usuario">
		                 
		<h3>Senha</h3>
		<input type="password" name="senha">
		
	    <h3>Nome Empresa</h3>
		<input type="text" name="nomeEmpresa">
		
		<h3>Razão Social</h3>
		<input type="text" name="razoaSocial">
		
		<h3>Cnpj</h3>
		<input type="text" name="cnpj">
		
		<hr>
		<input type = "submit" value = "Cadastrar">
                                            
	</form>
</body>
</html>