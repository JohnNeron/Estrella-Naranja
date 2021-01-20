<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicia Sesión</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<h2 style="text-align: center">Formulario para iniciar sesión</h2>
	<div style="text-align: center">
		<img src="img/Estrella.PNG" width="400" height="400" alt="Estrella Naranja" id="Estrella"/>
   	</div>
	<form action="/login" method="post">
		<div class="container">
		  	<div class="row">
			    <label for="uname"><b>Nombre de Usuario</b></label>
			    <input type="text" placeholder="Enter Username" name="username" required>			
			    <label for="psw"><b>Contraseña</b></label>
			   	<input type="password" placeholder="Enter Password" name="password" required>
				<div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				</div>
		    	<button type="submit">Login</button>	
		   	</div>
		</div>
	</form>
	<c:if test="${param.error != null }">
		<p>Datos incorrectos</p>		
	</c:if>
  <div class="container" style="background-color:#f1f1f1">
     <span class="psw">registrate <a href="/registrar">aqui</a></span>
  </div>
</body>
</html>