<%@page import="negocio.Endereco"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Endereço</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<%
	List<Endereco> end = (List<Endereco>)request.getAttribute("lista");
	%>
	
	<form action="EnderecoController" method="get">
		<h4>Endereço</h4>	
			
	<%if(end != null) {%>
		<table border="1" id="customers">
			<tr>
				<th width="75">rua</th>      
				<th width="75">complemento</th>
				<th width="75">bairro</th>           
				<th width="75">cidade<th>    
				<th width="75">uf</th>
				<th width="75">cep</th> 
				<th width="75">Operações</th>
				
			</tr>
	<%for(Endereco e : end) {
	%>		
			<tr>
				<td><%=e.getRua()%></td>
				<td align="center"><%=e.getComplemento()%></td>
				<td align="center"><%=e.getBairro()%></td>
				<td align="center"><%=e.getCidade()%></td>
				<td align="center"><%=e.getUf()%></td>
				<td align="center"><%=e.getCep()%></td>
				<td align= "center">
					<form action="EnderecoController" method="get">
						<input type= "hidden" name ="id" value="<%=e.getId() %>">
					
						<input type="submit" name= "operacao" value="Excluir"/>
					</form>
					<form action="EnderecoController" method="get">
						<input type= "hidden" name ="id" value="<%=e.getId() %>">
						
						<input type="submit" name= "operacao" value="Alterar"/>
					</form>
										
					</td>
			</tr>
		<%}%>
		</table>
		<%} %>
		<hr>
		<form action="EnderecoController" method="get">
	
		<input type= "hidden" name ="tela" value="incluir">

		<input type="submit" name= "operacao" value="Incluir">
	</form>


<hr>
</body>
</html>