<%@page import="controller.ControladorFicherosMensajes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Mensaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>logueo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" type="text/css">

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


	<%
		if (session.getAttribute("logueado") == null) {

			response.sendRedirect("index.jsp");

		} else {

			ArrayList<Mensaje> mensajes = ControladorFicherosMensajes.leerFicheroMensajes("D:\\mensajes.dat");

			if (mensajes != null) {
				
			
	%>
	<div class="container">
		<h4 style="text-align: start">Listado de mensajes</h4>
		<table class="table table-hover">
			<thead class="thead bg-success text-white">
				<tr>
					<th>Autor</th>
					<th>Mensaje</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Mensaje m : mensajes) {
					out.println("<tr>");
					out.println("<td>" + m.getCreador().getNombre() + "</td>");
					out.println("<td>" + m.getMensaje() + "</td>");
					out.println("<td>" + "<form action='/Foro/ServletBorrar' method='post'><button type='submit' name='eliminarMensaje' class='btn-outline-danger fa fa-trash-alt' value='"+m.getId()+"'></button></form>"+ "</td>");
					out.println("</tr>");
				}
				%>
			</tbody>
		</table>
		<br>
		
		
		<br>
		<form action="index.jsp" method="post">
			
			<input type="submit" name="cerrarSesion" class="btn-outline-primary" 
				value="Cerrar Sesión">

		</form>
		<%
			}
			}
		%>
	
</body>

</body>
</html>