<%@page import="negocio.PessoaJuridica"%>
<%@page import="java.util.List"%>
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
	List<PessoaJuridica> pj = (List<PessoaJuridica>)request.getAttribute("lista");
	%>
	
		<h4>Pessoa Juridica</h4>	
			
	<%if(pj != null) {%>
		<table border="1" id="customers">
			<tr>
				<th width="75">Usuario</th>      
				<th width="75">Senha</th>
				<th width="75">Nome Empresa</th>           
				<th width="75">Razao Social<th>    
				<th width="75">Cnpj</th>
				<th width="75">Operações</th>  
			</tr>
	<%for(PessoaJuridica pJu : pj) {
	%>		
			<tr>
				<td align="center"><%=pJu.getUsuario()%></td>
				<td align="center"><%=pJu.getSenha()%></td>
				<td align="center"><%=pJu.getNomeEmpresa()%></td>
				<td align="center"><%=pJu.getRazaoSocial()%></td>
				<td align="center"><%=pJu.getCnpj()%></td>
				<td align= "center">
					<form action="PessoaJuridicaController" method="get">
						<input type= "hidden" name ="id" value="<%=pJu.getId() %>">
					
						<input type="submit" name= "operacao" value="Excluir"/>
					</form>
					<form action="PessoaJuridicaController" method="get">
						<input type= "hidden" name ="id" value="<%=pJu.getId() %>">
						
						<input type="submit" name= "operacao" value="Alterar"/>
					</form>
																						
				</td>
			</tr>
		<%}%>
		</table>
		<%} %>
		<hr>
			<form action="PessoaJuridicaController" method="get">
	
		<input type= "hidden" name ="tela" value="incluir">

		<input type="submit" name= "operacao" value="Incluir">
	</form>


<hr>
</body>
</html>