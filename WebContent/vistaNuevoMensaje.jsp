<%@page import="controller.ControladorFicherosMensajes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Mensaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>


	
	
	<div class="card">
	<div class="card-header bg-success text-white">
		<h4 class="mb-0" style="text-align: center">Crea un nuevo mensaje</h4>
	</div>

	<div class="container py-3">

		<form action="/Foro/ServletNuevoMensaje" method="post">

			<div class="card-body">
				 Mensaje: <input type="text" name="mensajeNuevo">
				 <br> 
				 <br>
				 
				 <%
String ficheroMensaje = "D:\\mensajes.dat";
ArrayList<Mensaje> mensajes = ControladorFicherosMensajes.leerFicheroMensajes(ficheroMensaje); 

for(Mensaje m: mensajes){
	
	
	%>
	<input type="hidden" name="idNuevo" value="<%= mensajes.get(mensajes.size()-1).getId() + 1%>">
	<% 
	}

%>
				 
				<input type="submit" name="crearMen" class="btn-outline-success" value="Crear">
			</div>
		</form>
	</div>
</div>
<br>



	


</body>
</html>