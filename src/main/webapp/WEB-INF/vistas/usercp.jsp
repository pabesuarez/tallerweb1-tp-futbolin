<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
			<div class="row">
				<div class="col-3">
					<div class ="list-group">
						<a href="/usercp" class="list-group-item">Panel de control</a>
						<a href="/misPartidos" class="list-group-item">Mis partidos</a>
						<a href="/buscarPartidos" class="list-group-item">Buscar partidos</a>
						<a href="/usercp" class="list-group-item">Mi historial</a>
					</div>	
				</div>
				<div class="col-9">
				</div>
			</div>
		</jsp:attribute>
		<jsp:attribute name="scripts">

		</jsp:attribute>
	</t:default>