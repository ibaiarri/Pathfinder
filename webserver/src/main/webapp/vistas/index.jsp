<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pathfinder</title>

<script type="text/javascript" src="../scripts/creartabla.js"></script>

</head>
<body>
<form method="get" action="admin.jsp"> 
		<p>Usuario:<input type="text" placeholder="user" name="user" th:field="*{user}"> </input>
		Contraseņa:<input type="text" placeholder="password" name="password" th:field="*{password}"> </input>
		<input type="submit" value="enviar"/>
		</p>
  </form>  	
  		<form action="user.jsp">
			<input type="submit" value="enviar"/>
		</form>
  	
		<script>crear()</script>
		
		<div id="body" style=" text-align: center"></div>
</body>
</html>