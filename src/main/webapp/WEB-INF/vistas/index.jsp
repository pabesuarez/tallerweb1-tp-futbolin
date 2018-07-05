<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/estilo.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class ="container">
			<div class="row">
				<div class="col-md-12 header">
					<img src ="img/logo.png"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<h3>Menu de prueba</h3>
					<a href="loginprueba">login</a>
					<a href="Registro">Nuevo Usuario</a>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
			    	<h3>Convertir direccion</h3>
					<input id="direccion" type="text" class="form-control" />  		  
					<button class="btn btn-lg btn-primary btn-block" onClick="convertir();">convertir</button>
					<span id="valor"></span>
				</div>
			</div>
		</div>
		
		
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/axios.min.js" type="text/javascript"></script>
		<script src="js/mapa.js" type="text/javascript"></script>
	</body>
</html>