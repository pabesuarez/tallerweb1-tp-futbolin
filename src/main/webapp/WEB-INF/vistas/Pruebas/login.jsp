<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
			<h3>Usuarios</h3>
			<ul>
			<c:forEach items="${lista}" var="usuario">
				<li><a href="loginid/${usuario.id}"> ${usuario.email}</a>
			</c:forEach>
			</ul>
		</jsp:attribute>
	</t:default>