<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (request.getSession().getAttribute("logged") != null) {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/login-success.jsp");
		rd.forward(request, response);
	}

	String error = (String) request.getAttribute("error");
	String user = (request.getAttribute("user") != null)? (String) request.getAttribute("user") : "";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login form</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-sm-offset-3">
				<h1>Login form</h1>
				<form class="well" method="POST" action="${pageContext.request.contextPath}/login">
					<% if (error != null) { %>
					<p class="alert alert-danger" role="alert">
						Nombre de usuario o contraseña incorrectos
					</p>
					<% } %>
					
					<div class="form-group <% if (error != null) { %>has-error has-feedback<% } %>">
					    <label for="user">Usuario</label>
					    <input type="text" class="form-control" id="user" name="user" value="<%=user%>">
					    <% if (error != null) { %>
					    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
					    <% } %>
					</div>
					<div class="form-group <% if (error != null) { %>has-error has-feedback<% } %>">
					    <label for="pwd">Contraseña</label>
					    <input type="password" class="form-control" id="pwd" name="pwd">
					    <% if (error != null) { %>
					    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
					    <% } %>
					</div>
					<button type="submit" class="btn btn-default">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>