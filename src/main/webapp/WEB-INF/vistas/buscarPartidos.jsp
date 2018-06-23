<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	
<body>

<table class="table">
 <tr>
 	<th>fecha</th>
    <th>nombre de la cancha</th>
    <th>ubicacion</th>
    <th>descripcion</th>
    <th></th>
  </tr>
  
<c:forEach items="${resultado}" var="partido">
		<tr>
		<td>${partido.fecha}</td>
		<td>${partido.nombreCancha}</td>
		<td>${partido.direccion.calle} ${partido.direccion.numero}, ${partido.direccion.localidad} </td>
		<td>${partido.descripcion}</td>
		<td><button>unirse</button> </td>
		</tr>
	</c:forEach>
</table>
</body>
</html>