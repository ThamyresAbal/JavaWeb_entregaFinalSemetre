<%@page import="negocio.Contato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contato</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<%
	List<Contato> contato = (List<Contato>)request.getAttribute("lista");
	%>
	

		<h4>Contato</h4>	
			
	<%if(contato != null) {%>
		<table border="1" id="customers">
			<tr>
				<th width="75">E-mail </th>      
				<th width="75">Telefone </th>
				<th width="75">Celular </th>
				<th width="75">Operações</th>				
			</tr>
	<%for(Contato c : contato) {
	%>		
			<tr>
				<td align="center"><%=c.getEmail()%></td>
				<td align="center"><%=c.getTelefone()%></td>
				<td align="center"><%=c.getCelular()%></td>
				<td align= "center">
					<form action="ContatoController" method="get">
						<input type= "hidden" name ="id" value="<%=c.getId() %>">
					
						<input type="submit" name= "operacao" value="Excluir">
					</form>
					<form action="ContatoController" method="get">
						<input type= "hidden" name ="id" value="<%=c.getId() %>">
						
						<input type="submit" name= "operacao" value="Alterar">
					</form>
					</td>
			</tr>
		<%}%>
		</table>
		<%} %>
		<hr>
	
	<form action="ContatoController" method="get">
		<input type="submit" name= "operacao"  value="Incluir">
	</form>


<hr>
</body>
</html>