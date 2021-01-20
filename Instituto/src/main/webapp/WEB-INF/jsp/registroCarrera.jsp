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
<title>Registrar Carrera Nueva</title>
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
        <h1>Nueva Carrera</h1>
        <form:form action="/registrarCarrera" method="POST" modelAttribute="carrera">
          <p>Nombre: </p>
         <form:input path="nombre" cssClass="name"/>
		 <form:errors path="nombre"></form:errors>
          <input type="submit" class="submit button3" value="Registrar">
          </form:form><br>
          <form:form action="/listar" method="GET">
          <input type="submit" class="submit button3" value="Volver">
          </form:form>
      </div>
</body>
</html>