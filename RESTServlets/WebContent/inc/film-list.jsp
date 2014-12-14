<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Film list</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="container">
		<h1>RESTfull film project</h1>
		
		<button id="get-data" class="btn btn-primary btn-sm" data-loading-text="Loading...">Obtener datos</button>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Año</th>
					<th class="actions">Acciones</th>
				</tr>
			</thead>
			<tbody class="rows">
				
			</tbody>
		</table>
	</div>
</body>
</html>