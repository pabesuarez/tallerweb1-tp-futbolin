<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<t:default>
		<jsp:attribute name="body">
			<div class="row">
				<h3>Registrar usuario</h3>
				<div class="col-8">
					<form:form class="form-group" action="nuevo" method="POST" modelAttribute="usuario">
					email:<form:input path="email" class="form-control" id="email" type="email"  /><br/>
					contraseña:<form:input path="password" class="form-control" type="password" id="password"/><br/>     		  
					<button class="btn" type="Submit">registro</button>
					</form:form>	
				</div>
			</div>
		</jsp:attribute>
	</t:default>