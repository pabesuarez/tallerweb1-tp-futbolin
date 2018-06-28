<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
			<h3>Partidos</h3>
			<ul>
			<c:forEach items="${lista}" var="partido">
				<li><a href="detallePartido/${partido.id}"> ${partido.nombreCancha}</a>
			</c:forEach>
			</ul>
		</jsp:attribute>
	</t:default>