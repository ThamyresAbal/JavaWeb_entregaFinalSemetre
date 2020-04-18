<%@page import="negocio.Arrecadacao"%>
<%@page import="dao.ArrecadacaoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arrecadacao Detalhe</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
<%
	Arrecadacao a= (Arrecadacao)request.getAttribute("arrecadacao");


%>
	<form action = "ArrecadacaoController" method="post">
<!-- 		<input type = "hidden" name = "tela" value = "detalhe"> -->
		
		<h3>Nome Atividade</h3>
		<input type="text" name="nomeAtividade" value="<%=a == null ? "" : a.getNomeAtividade()%>">
		
		<h3>Data Atividade</h3>
		<input type="text" name="dataAtividade" value="<%=a == null ? "" : a.getDataAtividade()%>">
		
	    <h3>Hora</h3>
		<input type="text" name="hora" value="<%=a == null ? "" : a.getHora()%>">
		
		<h3>Categoria</h3>
		<input type="text" name="categoria" value="<%=a == null ? "" : a.getCategoria()%>">
		
		<h3>Descrição</h3>
		<input type = "text" name="descricao" value="<%=a == null ? "" : a.getDescricao()%>">
		
		<h3>Quantidade de Participantes</h3>
		<input type="text" name="qtdParticipantes" value="<%=a == null ? "" : a.getQtdParticipantes()%>">
		
		<h3>Quantidade Alimentos</h3>
		<input type="text" name="qtdAlimentos" value="<%=a == null ? "" : a.getQtdAlimentos()%>">
		
		<h3>Meta Arrecadação</h3>
		<input type="text" name="metaArrecadacao" value="<%=a == null ? "" : a.getMetaArrecadacao()%>">
		
		<h3>Publico Alvo</h3>	
		<input type="text" name="publicoAlvo" value="<%=a == null ? "" : a.getPublicoAlvo()%>">
		
		<h3>Quantidade de Brinquedos e Roupas</h3>	
		<input type="text" name="qtdBrinquedosRoupas" value="<%=a == null ? "" : a.getQtdBrinquedosRoupas()%>">
		
		<hr>
		<input type = "submit" value = "Confirmar">
                                            
	</form>
</body>
</html>