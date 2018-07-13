<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>



	<table class="table">
		<thead>
			<tr>
				<th>fecha</th>
				<th>nombre de la cancha</th>
				<th>ubicacion</th>
				<th>descripcion</th>
					<th>Finalizar</th>
			</tr>
		</thead>

		<c:forEach items="${resultado}" var="partido">
			<tr>
				<td>${partido.fecha}</td>
				<td><a href="/futbolin/detallePartido/${partido.id}">${partido.nombreCancha}</a></td>
				<td></td>
				<td>${partido.descripcion}</td>
				<td><a href="/futbolin/finalizarPartido/${partido.id}">Finalizar Partido</a></td>
			</tr>
		</c:forEach>
	</table>
				
		
	
	
</body>
</html>