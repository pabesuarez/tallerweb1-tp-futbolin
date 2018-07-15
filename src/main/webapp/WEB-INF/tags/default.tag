
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<%@attribute name="body" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<html>
	<head>
	    <link href="${url}/css/bootstrap.min.css" rel="stylesheet" >
	    <link href="${url}/css/estilo.css" rel="stylesheet" >
	    <link href="${url}/css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class ="container">
			<div class="row">
				<div class="col-md-12 header">
					<img src ="${url}/img/logo.png"/>
					logeado como: ${sessionScope.email}
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class ="list-group">
						<a href="${url}/usercp" class="list-group-item">Panel de control</a>
						<a href="${url}/misPartidos" class="list-group-item">Mis partidos</a>
						<a href="${url}/buscarPartidos" class="list-group-item">Buscar partidos</a>
						<a href="${url}/usercp" class="list-group-item">Mi historial</a>
					</div>	
				</div>
				<div class="col-md-9">
					<jsp:invoke fragment="body"/>
				</div>
			</div>
			
		</div>
		<script src="${url}/js/jquery-1.11.3.min.js" ></script>
		<script src="${url}/js/bootstrap.min.js" type="text/javascript"></script>
		    <jsp:invoke fragment="scripts"/>
	</body>
</html>