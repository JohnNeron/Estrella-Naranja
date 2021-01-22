<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<link rel="stylesheet" href="css/confirmacion.css">
	<script src="js/form.js"></script>
	<title>Confirmado</title>
</head>
<body>
	<div class="wrapper">
		<h1>USUARIO CREADO EXITOSAMENTE</h1>
		<p> pulse el botón de abajo para volver</p>
		<div>
			<form:form action="/" method="GET">
		    	<input type="submit" class="submit button1" value="Volver">
		    </form:form>
	    </div>
    </div>
</body>
</html>