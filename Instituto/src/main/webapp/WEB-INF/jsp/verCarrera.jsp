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
	<link rel="stylesheet" href="css/formStyle3.css">
	<script src="js/form.js"></script>
<title>Administrar Carreras</title>
</head>
<body>
	<nav>
		<ul class="topnav">
		  <li><a href="/">Inicio</a></li>
		  <li><a href="/listar">Ver Estudiantes</a></li>
		  <li><a href="/listarUsuario">Ver Usuarios</a></li>
		  <li><a class="active" href="/verCarreras">Ver Carreras</a></li>
		  <li class="right"><a href="/logout">Cerrar Sesión</a>
		</ul>
	</nav>
	<section>
	  <!--for demo wrap-->
	  <h1>Carreras Disponibles</h1>
	  <div class="tbl-content">
	    <table cellpadding="0" cellspacing="0" border="0">
	    	
	    	<th style="width: 200px"> ID</th>
	      	<th style="width: 600px"> Nombre</th>
			<th style="width: 100px"> Acciones</th>
			<c:forEach items="${carreras}" var="c">
				<tbody id="myTable">
					<tr>
						<td>${c.id}</td>
						<td>${c.nombre}</td>
						<td>
							<form action="/EliminarCarrera" method="POST">
								<input type="hidden" name="id" value="${c.id}"> 
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<input type="submit" class="button button5" onclick="return confirmEliminar(${c.id})"	value="Eliminar">
							</form>
						</td>
						<td>
							<form action="/CargarCarrera" method="POST">
							<input type="hidden" name="id" value="${c.id}">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
							<input type="submit" class="button button5" value="Modificar">
							</form>
						</td>
					</tr>
				</tbody>
			</c:forEach>	
	   	 </table>
	  </div>
	  <form action="/agregarCarrera" method="GET">
				<input type="submit" class="submit button3" value="Agregar Nueva Carrera">
		 </form>
	</section>
</body>
</html>