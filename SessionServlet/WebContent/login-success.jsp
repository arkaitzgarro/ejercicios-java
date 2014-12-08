<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if (request.getSession().getAttribute("logged") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	String error = (String) request.getAttribute("error");
	String user = (request.getAttribute("user") != null)? (String) request.getAttribute("user") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login success</title>
</head>
<body>
	<h1>Login success</h1>
</body>
</html>