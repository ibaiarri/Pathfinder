<%@page import="com.pathfinder.model.Personaje"%>
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
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-lg-5">
                <a class="navbar-brand" href="#!">Pathfinder Formulario</a>
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
                    <form method="get" action="ServletLectura" class="navbar-nav ms-auto mb-2 mb-lg-0">
                    
                    <%//Personaje per=session.getAttribute("persona"); %>
                    
                     
                <%out.println("Nombre");
					 
					//out.println("<input type='text' name='nombre' value="+Personaje.setNombre()+"> </input>");
					%>
					Raza	
						<input type="text" name="raza" th:field="*{raza}"> </input>
					Nivel	
						<input type="text" name="nivel" th:field="*{nivel}"> </input>
					Clase	
						<input type="text" name="clase" th:field="*{clase}"> </input>
					Usuario	
						<input type="text" name="usuario" th:field="*{Usuario}"> </input>
						<input type="submit" value="enviar"/>
				    </form> 
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