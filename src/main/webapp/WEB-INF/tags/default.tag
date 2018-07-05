<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@attribute name="body" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
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
					logeado como: ${sessionScope.email}
				</div>
			</div>
			<jsp:invoke fragment="body"/>
		</div>
		<script src="js/jquery-1.11.3.min.js" ></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		    <jsp:invoke fragment="scripts"/>
	</body>
</html>