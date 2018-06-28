<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h3>Jugador</h3>
${claveIdCupo}
${claveNombre}
${claveApellido}

	<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

<form:form action="/futbolin/PuntajeGuardado" method="POST" modelAttribute="objetoPuntos">
			    	<h3 class="form-signin-heading">Puntaje</h3>
			

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>


 					<div>golesComoArquero:<form:input path="golesComoArquero" type="text"  class="form-control"/></div>
 					<div>golesComoDefensor:<form:input path="golesComoDefensor" type="text"  class="form-control"/></div>
 					<div>golesComoDelantero:<form:input path="golesComoDelantero" type="text"  class="form-control"/></div>
 					<div>golesComoVolante:<form:input path="golesComoVolante"  type="text"  class="form-control"/></div>
 					<div>golesDePenal:<form:input path="golesDePenal" type="text"  class="form-control"/></div>
 					<div>golesEnContra:<form:input path="golesEnContra" type="text"  class="form-control"/></div>
 					<div>golesRecibidos:<form:input path="golesRecibidos" type="text"  class="form-control"/></div>
 					<div>penalesAtajados:<form:input path="penalesAtajados" type="text"  class="form-control"/></div>
 					<div>penalesErrados:<form:input path="penalesErrados" type="text"  class="form-control"/></div>
 					<div>tarjetaRoja:<form:input path="tarjetaRoja" type="text"  class="form-control"/></div>
 					<div>tarjetasAmarillas:<form:input path="tarjetasAmarillas" type="text"  class="form-control"/></div>
 					<div>idCupo:<form:input path="cupo.id" type="text"  value="${claveIdCupo}" class="form-control"/></div>

					
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Guardar</button>
			
 		
				</form:form>
				
						</div>
		</div>

				<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>