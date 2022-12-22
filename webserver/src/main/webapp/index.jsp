
<%@page import="com.pathfinder.model.Personaje"%>
<%@page import="com.pathfinder.dao.PathfinderDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.List"%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Pathfinder</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="scripts/creartabla.js"></script>
</head>
<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container px-lg-5">
			<a class="navbar-brand" href="#!">PathFinder</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<form method="get" action="ServletLectura"
					class="navbar-nav ms-auto mb-2 mb-lg-0">
					<input type="text" placeholder="user" name="user"
						th:field="*{user}"> </input> <input type="text"
						placeholder="password" name="password" th:field="*{password}">
					</input> <input type="submit" value="enviar" />
				</form>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="py-5">
		<div class="container px-lg-5">
			<div class="p-4 p-lg-5 bg-light rounded-3 text-center" id="tab">
				<!--aqui introduciremos la tabla-->
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">Raza</th>
							<th scope="col">Nivel</th>
							<th scope="col">Clase</th>
							<th scope="col">Usuario</th>
						</tr>
					</thead>
					<tbody>
						<%
					PathfinderDaoImp dao=new PathfinderDaoImp();	
						
					List<Personaje> personaje =dao.ListPersonajes();

					  int numeracion=1;  
						  for(int i=0; i < personaje.size();i++){
							  out.println("<tr>"); 
							  Personaje per=personaje.get(i);
							  out.println("<td>"+numeracion+"</td>");
							  out.println("<td>"+per.getNombre()+"</td>");
							  out.println("<td>"+per.getRaza().getNombre()+"</td>");
							  out.println("<td>"+per.getNivel()+"</td>");
							  out.println("<td>"+per.getClase()+"</td>");
							  out.println("<td>"+per.getUser().getNombre()+"</td>");			
							  numeracion ++;
							  out.println("</tr>"); 
							  	  }
	  
					  %>


					</tbody>
				</table>

			</div>
		</div>
	</header>
	<!--aqui introduciremos la imagen-->
	<img src="imagen/Pathfinder.jpeg">
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>


</body>
</html>