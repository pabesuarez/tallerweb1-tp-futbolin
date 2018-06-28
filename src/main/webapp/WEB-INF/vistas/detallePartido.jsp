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

			<p>fecha ${partido.fecha}</p>
			<p>nombre de la cancha: ${partido.nombreCancha}</p>
			<p>direccion: ${partido.direccion.calle}
				${partido.direccion.numero} ${partido.direccion.localidad}</p>
			<p>organizador: ${partido.organizador.nombre}
				${partido.organizador.apellido}</p>
			<p>detalles: ${partido.descripcion}</p>
			<button>quiero unirme al partido</button>

	<div id="map" style="width: 100%; height: 400px;"></div>
	
	
	<h3>Cupos diponibles</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Posicion</th>
				<th></th>
			</tr>
		</thead>

		<c:forEach items="${cupos}" var="cupo">
			<tr>
				<td>${cupo.posicion}</td>
				<td><button>solicitar</button></td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	
	
	
	<script>

function initMap() {

  var ubicacion = {${partido.direccion.geolocalizacion}};

  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 16, center: ubicacion});

  var marker = new google.maps.Marker({position: ubicacion, map: map});
}
    </script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLj1fpj5ZVqBThB6azonzdnZ10iT7rec4&callback=initMap">
    </script>

</body>
</html>