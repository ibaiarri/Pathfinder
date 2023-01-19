<%@page import="com.pathfinder.model.Personaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.pathfinder.dao.PathfinderDaoImp" %>
    <%@ page import ="com.pathfinder.model.Raza" %>
    <%@ page import ="com.pathfinder.model.Usuario" %>
    
    <%@ page import="java.util.List"%>
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
    <%
    
	    PathfinderDaoImp dao=new PathfinderDaoImp();
	    Raza r=new Raza();
	    
		out.println("<form method='get' action='ServletCrear' class='navbar-nav ms-auto mb-2 mb-lg-0'>");
		out.println("<input type='hidden' name='id'>");
		
		if(request.getParameter("id_usuario") != null){
			out.println("<input type='hidden' name='id_usuario' value="+Integer.parseInt(request.getParameter("id_usuario"))+">");
		}
		out.println("Nombre");
		out.println("<input type='text' name='nombre'><br>");
	    out.println("Nivel");
	    out.println("<input type='text' name='nivel'><br>");
	    out.println("Clase");
	    out.println("<input type='text' name='clase'><br>");
	    out.println("Raza");
	    List<Raza> raza=dao.ListRaza();
	    out.println("<select name='raza'>");
	    for (Raza ra : raza) {
	    		out.println("<option value="+ra.getId_raza()+">"+ra.getNombre()+"</option>");	    	
		}
	    out.println("</select><br>");
	    
	    if(request.getParameter("id_usuario") == null){
	    	out.println("Usuario");
	  	    List<Usuario> usua=dao.ListUsuario();
	    	out.println("<select name='usu'>");
		    for (Usuario usu : usua) {
		    		out.println("<option value="+usu.getId_usuario()+">"+usu.getNombre()+"</option>");	    	
			}
		    out.println("</select><br>");
	    }
	    
	    out.println("<input type='submit' name='crear' value='enviar'/>");
	    out.println("</form>");
	%>			

                </div>
                 <form method="get" action="/webserver">
				 <button type="submit">inicio
				</form>
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