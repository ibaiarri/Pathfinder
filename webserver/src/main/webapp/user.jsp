<%@page import="java.util.List"%>
<%@page import="com.pathfinder.model.Personaje"%>
<%@page import="com.pathfinder.dao.PathfinderDaoImp"%>
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
                <a class="navbar-brand" href="#!">Pathfinder Usuario</a>
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
              <table id="tabla"  class="table table-fixed table-condensed">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">Raza</th>
							<th scope="col">Nivel</th>
							<th scope="col">Clase</th>
							<th scope="col">Usuario</th>
							<th scope="col">Editar</th>
							<th scope="col">Eliminar</th>
						</tr>
					</thead>
					<tbody>
								
			<% 
					PathfinderDaoImp dao=new PathfinderDaoImp();	
					int id=Integer.parseInt(request.getParameter("id_usuario"));
					
					List<Personaje> personaje =dao.ListPersonajeByUsuario(id);

					  int numeracion=1;  
						  for(int i=0; i < personaje.size();i++){
							  Personaje per=personaje.get(i);
							  session.setAttribute("persona", per);
							  out.println("<form method='get' action='ServletEditar' class='navbar-nav ms-auto mb-2 mb-lg-0'>");
							  out.println("<input type='hidden' name='id' value="+per.getId_personaje()+">");
							  out.println("<input type='hidden' name='id_usuario' value="+per.getUser().getId_usuario()+">");
							  out.println("<td>"+numeracion+"</td>");
							  out.println("<td>"+per.getNombre()+"</td>");
							  out.println("<td>"+per.getRaza().getNombre()+"</td>");
							  out.println("<td>"+per.getNivel()+"</td>");
							  out.println("<td>"+per.getClase()+"</td>");
							  out.println("<td>"+per.getUser().getNombre()+"</td>");		
							  out.println("<td><input type='submit' name='editarusuario' value='editar' /></td>");	
							  out.println("<td><input type='submit' name='eliminarusuario' value='eliminar' /></td>");
							  out.println("</form>");	
							  numeracion ++;
							  out.println("</tr>"); 	  
						}		  
					  %>
					</tbody>
				</table>
				

				<form method="get" action="ServletCrear" class="navbar-nav ms-auto mb-2 mb-lg-0">
					<% 
						out.println("<input type='hidden' name='id_usuario' value="+id+">");
					%>
					</input> <input type="submit" name='menucrearusuario' value="crear" />
				</form>
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
					<script> tablaseleccionable()</script>	 
			       
    </body>
</html>