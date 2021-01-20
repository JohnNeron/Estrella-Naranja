<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/registrar.css">
	<script src="js/form.js"></script>
<title>Registrar Usuario Nuevo</title>
</head>
<body>
	<nav>
		<ul class="topnav">
		  <li><a href="/">Inicio</a></li>
		  <li><a href="/listar">Ver Estudiantes</a></li>
		  <li><a href="/listarUsuario">Ver Usuarios</a></li>
		  <li><a href="/verCarreras">Ver Carreras</a></li>
		  <li class="right"><a href="/logout">Cerrar Sesión</a>
		</ul>
    </nav>
    <div class="wrapper">
        <h1>Nuevo Usuario</h1>
        <form:form action="/registrarUsuario" method="POST" modelAttribute="usuario">
          <p>Nombre de Usuario: </p>
         <form:input path="username"/>
		 <form:errors path="username"></form:errors>
          <p>Contraseña: </p>
          <form:password path="password" cssClass="password" />
		  <form:errors path="password"></form:errors>
		  <form:hidden path="rol" value="2"/>
          <input type="submit" class="submit button3" value="Registrar">
          </form:form><br>
          <form:form action="/listar" method="GET">
          <input type="submit" class="submit button3" value="Volver">
          </form:form>
      </div>
</body>
</html>
