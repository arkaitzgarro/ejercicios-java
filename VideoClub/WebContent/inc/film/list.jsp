<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="com.arkaitzgarro.jdbc.model.Film" %>

<c:import url="/inc/common/header.jsp"></c:import>
<body>
	<c:import url="/inc/common/nav.jsp"></c:import>
	<div class="container">
		<h1>Listado de películas</h1>
	
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th>Año</th>
					<th>Título</th>
					<th>Descripción</th>
					<th class="actions">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="film" items="${list}">
					<tr>
						<td><fmt:formatDate value="${film.year}" pattern="yyyy" /></td>
						<td>${film.title}</td>
						<td>${film.description}</td>
						<td>
							<a href="${pageContext.request.contextPath}/peliculas/ver?film_id=${film.id}" class="btn btn-primary btn-xs">Ver película</a>
							<a href="${pageContext.request.contextPath}/carro/agregar?film_id=${film.id}" class="btn btn-success btn-xs">Comprar película</a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	
<c:import url="/inc/common/footer.jsp" />