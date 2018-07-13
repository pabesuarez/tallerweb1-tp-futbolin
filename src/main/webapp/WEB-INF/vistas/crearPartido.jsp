
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
			<div class="row">
				<h3>Nuevo Partido</h3>
				<div class="col-8">
					<form:form class="form-group" action="nuevoPartido" method="POST" modelAttribute="partido">
						Cancha:<form:input path="nombreCancha" class="form-control" id="cancha" type="text"  /><br/>
						Descripcion:<form:input path="descripcion" class="form-control" id="descripcion" type="text"  /><br/>
						Direccion:<input class ="form-control" type="text" id="direccion">
						<button type="button" onClick="initMap()">buscar</button>
					    <div id="map" style="width: 100%; height: 400px;"></div>
						<form:input path="latitud" id="latitud" type="hidden"  /><br/>
						<form:input path="longitud" id="longitud" type="hidden"  /><br/>
						<button class="btn" type="Submit">Crear partido</button>
					</form:form>	
				</div>
			</div>
		</jsp:attribute>
		<jsp:attribute name="scripts">
			<script src="js/axios.min.js" type="text/javascript"></script>
			<script src="js/mapa.js" type="text/javascript"></script>
			<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLj1fpj5ZVqBThB6azonzdnZ10iT7rec4&callback=initMap">
	    	</script>	
		</jsp:attribute>
	</t:default>