<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Pathfinder</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
		<script type="text/javascript" src="scripts/creartabla.js"></script>
    </head>
      <%@ page import = "java.util.ArrayList" %>
     <%@ page import = "java.util.Arrays" %>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-lg-5">
                <a class="navbar-brand" href="#!">Pathfinder Administrador</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
					
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
					    </tr>
					  </thead>
					  <tbody>
					  <%
					
					  
					  ArrayList<String> cities = new ArrayList<String>(
					  Arrays.asList("L", "Tokyo", "New York"));

					  int numeracion=1;
					  for(int i=0; i < cities.size();i++){
					
						  out.println("<tr>");
						  out.println("<th scope='row'>"+numeracion+"</th>");
						  numeracion ++;
					
						  
						  for(int x=0; x < cities.size();x++){
							  out.println("<td>"+cities.get(i)+"</td>");
							  	  }
						  
						  out.println("<tr>"); 
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
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
				 
			       
    </body>
</html>