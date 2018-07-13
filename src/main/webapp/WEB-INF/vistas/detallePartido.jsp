<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
		
			<p>fecha ${partido.fecha}</p>
			<p>nombre de la cancha: ${partido.nombreCancha}</p>
			<p>organizador: ${partido.organizador.id}
				${partido.organizador.apellido}</p>
			<p>detalles: ${partido.descripcion}</p>

	<div id="map" style="width: 100%; height: 400px;"></div>
	
	

		<c:choose>
			<c:when test = "${partido.organizador.id == sessionScope.uid }">
				<h3>Cupos</h3>
				<table class="table">
				<thead>
					<tr>
						<th>Posicion</th>
						<th>Jugador</th>
						<th></th>
					</tr>
				</thead>
					<c:forEach items="${cupos}" var="cupo">
					<tr>
						<td>${cupo.posicion}]</td>
						<c:choose>
							<c:when test="${cupo.usuario != null}">
								<td>${cupo.usuario.nombre} ${cupo.usuario.apellido}</td>
							</c:when>
							<c:otherwise>
								<td>Vacante</td>
							</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>
				</table>
				<h3>Solicitudes</h3>
				<table class="table">
					<thead>
						<tr>
						<th>Posicion</th>
						<th>Usuario</th>
						<th></th>
						<th></th>
					</thead>
					<c:forEach items="${solicitudes}" var="solicitud">
					<tr>
						<td>${solicitud.cupo.posicion} ${solicitud.id}</td>
						<td>${solicitud.usuario.nombre}</td>
						<td><a class="btn btn-success" href="${url}/aceptarSolicitud/${solicitud.id}">Aceptar</a></td>
						<td><a class="btn btn-danger" href="${url}/rechazarSolicitud/${solicitud.id}">Rechazar</a></td>
					</tr>
					</c:forEach>
					<tr>
					<form:form class="form-inline" action="${url}/nuevoCupo" method="POST" modelAttribute="FormNuevoCupo">
					<form:input path="partido" type="hidden" value="${partido.id}"/>
						<td><form:input path="posicion" class="form-control" type="text"/></td>
						<td><button class="btn" type="submit">Nuevo Cupo</button></td>
						<td></td>
						<td></td>
					</form:form>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
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
						<c:set var="tieneSolicitud" value="false" />
							<c:forEach items="${cuposConSolicitud}" var="c">
							  <c:if test="${c eq cupo.id}">
							    <c:set var="tieneSolicitud" value="true" />
							  </c:if>
							</c:forEach>	
						<c:choose>
							<c:when test = "${tieneSolicitud eq false}">
								<td><a href="${url}/solicitar/${cupo.id}">Solicitar</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="${url}/quitarSolicitud/${cupo.id}">Borrar Solicitud</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		

	
		</jsp:attribute>
		<jsp:attribute name="scripts">
	
	
	<script>

function initMap() {

  var ubicacion = {lat: ${partido.latitud}, lng: ${partido.longitud}};
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 16, center: ubicacion});

  var marker = new google.maps.Marker({position: ubicacion, map: map});
}
    </script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLj1fpj5ZVqBThB6azonzdnZ10iT7rec4&callback=initMap">
    </script>

	</jsp:attribute>
	</t:default>