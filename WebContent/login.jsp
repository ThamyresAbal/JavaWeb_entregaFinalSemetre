<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso</title>
</head>
<body>
	<%
	String mensagem = (String)request.getAttribute("msg");
	%>
	
	
	<form action="LoginController" method="post">
		<input type = "hidden" name = "tela" value = "login">

		<%if(mensagem != null){%>
	
			<h4><%=mensagem%></h4>
		
			<hr>
			
		<%}%>

		<h3>E-mail</h3>
		<input type="text" name="email">
		
		<h3>Senha</h3>
		<input type="password" name="senha">
		
		<hr>
		
		<input type="submit" value="Acessar">
	
	</form>
	<hr>
	

</body>
</html>