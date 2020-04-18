<%@page import="negocio.PessoaFisica"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoa Fisica</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">


</head>
<body>

<%
	List<String> listaEstadoCivil = (List<String>)request.getAttribute("listaEstadoCivil");
	List<String> listaNaturalidade = (List<String>)request.getAttribute("listaNaturalidade");
	List<String> listaSexo = (List<String>)request.getAttribute("listaSexo");
	PessoaFisica pf = (PessoaFisica)request.getAttribute("pessoa");
%>
	<form action = "PessoaFisicaController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->
		
		<h3>Usuario</h3>
		<input type="text" name="usuario">
		                 
		<h3>Senha</h3>
		<input type="password" name="senha">
		
	    <h3>Nome Completo</h3>
		<input type="text" name="nome">
		
		<h3>Nome Social</h3>
		<input type="text" name="nomeSocial">
		
		<h3>Data de Nascimento</h3>
		<input type="text" name="dataNascimento">
		
		<h3>CPF</h3>
		<input type="text" name="cpf">
		
		<h3>Naturalidade</h3>
		<select name="naturalidade">
			<%for(String n : listaNaturalidade){%>
			<option><%=n%></option>
			<%}%>
		</select>
		
		<h3>Nacionalidade</h3>
		<input type="text" name="nacionalidade">
		
		<h3>Gênero</h3>
		<select name="sexo">
			<%for(String s : listaSexo){%>
			<option><%=s%></option>
			<%}%>
		</select>
		
		<h3>EstadoCivil</h3>
		<select name="estadoCivil">
			<%for(String e : listaEstadoCivil){%>
			<option><%=e%></option>
			<%}%>
		</select>
					
		<hr>
		<input type = "submit" value = "Cadastrar">
                                            
	</form>

</body>
</html>