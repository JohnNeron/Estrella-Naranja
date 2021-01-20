<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bienvenido</title>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
      integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="css/estilo.css" />
    <title>Los Eren</title>
  </head>
  <body style="background-color: rgb(255, 255, 255);">
  	<h1 style="text-align: center;"><b>Bienvenido</b></h1>
    <nav
      class="navbar navbar-expand-lg navbar-dark bg-dark static-top fixed-top"
    >
      <div class="container">
        <a class="navbar-brand" href="/"
          ><img src="img/Estrella.PNG" width="50" height="50" alt="" /> INICIO</a
        >
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/listar">Ver Estudiantes</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="/listarCarrera">Ver Carreras</a>
            </li>
            <li class="nav-item">
            	<a class="nav-link" href="/logout">Cerrar Sesión</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container">
      <div class="row" style="margin-top: 80px">
        <div class="col-lg-5 center" style="text-align: center">
          <img src="img/Estrella.PNG" width="400" height="400" alt="legion de reconocimiento" id="legion"/>
        </div>
        <div class="col-lg-7"> <br>
          <h1>Instituto "Estrella Naranja"</h1>
          <div class="container">
				<div class="row-fluid">
			        <div style="width: 100%">
			        	<iframe width="100%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" 
			        	src="https://maps.google.com/maps?width=100%25&amp;height=350&amp;hl=es&amp;q=Av.%20Pedro%20de%20Valdivia%203762+(Instituto%20Estrella%20Naranja)&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed">
			       		</iframe>
			        </div>
			    </div>
			</div>
          <br>
          <ul class="list-unstyled">
            <li>Atencion de lunes a viernes</li>
            <li>de 8:00 a 20:00 hrs.</li>
          </ul>
        </div>
      </div>
    </div>
    <!-- Footer -->
    <footer class="page-footer font-small blue pt-12">
        <div style="text-align:center" class="span4">
			<h2><b><i>Instituto Estrella Naranja</i></b></h2>
			 <strong>Pedro de Valdivia #3762</strong><br>
	  		 Ñuñoa - Santiago<br>
			<p>Telefono: +56 97654329</p> 
    	</div>
    </footer>
  </body>
</html>