<%@page import="negocio.Oficina"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oficina</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">


</head>
<body>
<%
	Oficina o = (Oficina)request.getAttribute("oficina");
%>
		
		<h3>Nome Atividade</h3>
		<input type="text" name="nomeAtividade" value="<%=o == null ? "" : o.getNomeAtividade()%>">
		
		<h3>Data Atividade</h3>
		<input type="text" name="dataAtividade" value="<%=o == null ? "" : o.getDataAtividade()%>">
		
	    <h3>Hora</h3>
		<input type="text" name="hora" value="<%=o == null ? "" : o.getHora()%>">
		
		<h3>Categoria</h3>
		<input type="text" name="categoria" value="<%=o == null ? "" : o.getCategoria()%>">
		
		<h3>Descrição</h3>
		<input type = "text" name="descricao" value="<%=o == null ? "" : o.getDescricao()%>">
		
		<h3>Quantidade de Participantes</h3>
		<input type="text" name="qtdParticipantes" value="<%=o == null ? "" : o.getQtdParticipantes()%>">
		
		<hr>
		<input type = "submit" value = "Cadastrar">
                                            
	</form>
     
                                      

</body>
</html>