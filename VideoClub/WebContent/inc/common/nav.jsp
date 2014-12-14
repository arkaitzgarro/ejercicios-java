<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="nabvar-header">
			<a href="${pageContext.request.contextPath}/" class="navbar-brand">
				<img src="${pageContext.request.contextPath}/img/dvd-logo.png" alt="Brand">
			</a>
		</div>
		<form class="navbar-form navbar-right">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Película, actor..." />
				<button class="btn btn-default" type="submit">Enviar</button>
			</div>
		</form>
	</div>
</nav>