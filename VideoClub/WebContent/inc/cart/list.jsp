<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/inc/common/header.jsp"></c:import>
<body>
	<c:import url="/inc/common/nav.jsp"></c:import>
	<div class="container">
		<h1>Carro de la compra</h1>
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Año</th>
					<th>Título</th>
					<th>Descripción</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="film" items="${list}">
					<tr>
						<td><fmt:formatDate value="${film.year}" pattern="yyyy" /></td>
						<td>${film.title}</td>
						<td>${film.description}</td>
						<td>
							<a href="${pageContext.request.contextPath}/carro/quitar?film_id=${film.id}" class="btn btn-danger btn-xs">Quitar película</a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<div class="well actions">
			<a href="${pageContext.request.contextPath}/peliculas/listado" class="btn btn-default"><span class="glyphicon glyphicon-chevron-left"></span> Ver todas las películas</a>
			<a href="${pageContext.request.contextPath}/carro/pagar" class="btn btn-primary pull-right">Pagar <span class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
	</div>
	
<c:import url="/inc/common/footer.jsp" />