<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>



<h2>Jugadores</h2>
		<table class="table">
		<thead>
			<tr>
			<th>IdCupo</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Posicion</th>
			</tr>
		</thead>

		<c:forEach items="${cupoClave}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.usuario.nombre}</td>
				<td>${item.usuario.apellido}</td>
				<td>${item.posicion}</td>
			
				
				<td><a href="/futbolin/calificarJugador/${item.id}/${item.usuario.nombre}/${item.usuario.apellido}/${item.posicion}">Calificar</a></td>
			</tr>
		</c:forEach>
	</table>
		
		

		
</body>
</html>