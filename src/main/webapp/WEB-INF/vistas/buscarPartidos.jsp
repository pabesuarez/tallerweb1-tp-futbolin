
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>\
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">



	<table class="table">
		<thead>
			<tr>
				<th>fecha</th>
				<th>nombre de la cancha</th>
				<th>ubicacion</th>
				<th>descripcion</th>
			</tr>
		</thead>

		<c:forEach items="${resultado}" var="partido">
			<tr>
				<td>${partido.fecha}</td>
				<td><a href="/futbolin/detallePartido/${partido.id}">${partido.nombreCancha}</a></td>
				<td>${partido.direccion}</td>
				<td>${partido.descripcion}</td>
			</tr>
		</c:forEach>
	</table>
		</jsp:attribute>
	</t:default>