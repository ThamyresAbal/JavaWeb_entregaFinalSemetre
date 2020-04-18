<%@page import="auxiliar.Constante"%>
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
	List<PessoaFisica> pf = (List<PessoaFisica>)request.getAttribute("lista");
	%>
			<h4>Pessoa Fisica</h4>	
			
	<%if(pf != null) {%>
		<table border="1" id="customers">
			<tr>
				<th width="75">Usuario</th>      
				<th width="75">Senha</th>
				<th width="75">Nome</th>       
				<th width="75">Nome Social</th>           
				<th width="75">Data Nascimento</th>    
				<th width="75">CPF</th>
				<th width="75">Naturalidade</th>
				<th width="75">Nacionalidade</th>
				<th width="75">Gênero</th>
				<th width="75">EstadoCivil</th>     
				<th width="75">Operações</th> 
			</tr>
	<%for(PessoaFisica p : pf) {
	%>		
			<tr>
				<td align="center"><%=p.getUsuario()%></td>
				<td align="center"><%=p.getSenha()%></td>
				<td align="center"><%=p.getNome()%></td>
				<td align="center"><%=p.getNomeSocial()%></td>
				<td align="center"><%=Constante.obterDataFormatada(p.getDataNascimento().getTime())%></td>
				<td align="center"><%=p.getCpf()%></td>
				<td align="center"><%=p.getNaturalidade()%></td>
				<td align="center"><%=p.getNacionalidade()%></td>
				<td align="center"><%=p.getGenero()%></td>
				<td align="center"><%=p.getEstadoCivil()%></td>
				<td align= "center">
					<form action="PessoaFisicaController" method="get">
						<input type= "hidden" name ="id" value="<%=p.getId() %>">
					
						<input type="submit" name= "operacao" value="Excluir"/>
					</form>
					<form action="PessoaFisicaController" method="get">
						<input type= "hidden" name ="id" value="<%=p.getId() %>">
						
						<input type="submit" name= "operacao" value="Alterar"/>
					</form>
				
														
				</td>
			</tr>
		<%}%>
		</table>
		<%} %>
		<hr>
		<form action="ArrecadacaoController" method="get">
		
			<input type= "hidden" name ="incluir" value="incluir">

			<input type="submit" name= "operacao" value="Incluir"/>
		</form>
	
</body>
</html>