<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/inc/common/header.jsp"></c:import>
<body>
	<c:import url="/inc/common/nav.jsp"></c:import>
	<div class="container">
		<h1>${film.title}</h1>
		<span><fmt:formatDate value="${film.year}" pattern="yyyy" /></span>
		<p>${film.description}</p>
		
		<div class="well actions">
			<a href="${pageContext.request.contextPath}/peliculas/listado" class="btn btn-default"><span class="glyphicon glyphicon-chevron-left"></span> Volver</a>
			<a href="${pageContext.request.contextPath}/carro/agregar?film_id=${film.id}" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Comprar</a>
		</div>
	</div>
	
	
	
<c:import url="/inc/common/footer.jsp" />