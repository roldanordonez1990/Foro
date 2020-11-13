package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.ControladorFicherosMensajes;
import models.Administrador;
import models.Mensaje;
import models.Persona;
/**
 * Servlet implementation class ServletNuevoMensaje
 */
@WebServlet(name="/ServletNuevoMensaje", urlPatterns = {"/ServletNuevoMensaje"})
public class ServletNuevoMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNuevoMensaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Los datos se están mandando por el método post, no por aquí");
		out.println("</body>");
		out.println("</html>");
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//PrintWriter out = response.getWriter();
		String boton = request.getParameter("crearMen");
		String usu = request.getParameter("usu");
		String fichero = "D:\\personas.dat";
		ArrayList<Persona> personas = ControladorFicherosMensajes.leerFichero(fichero);
		
		//Persona persona = null;
		
			
			if(boton != null) {
				
				System.out.println("Hola");
				String ficheroMensaje = "D:\\mensajes.dat";
				ArrayList<Mensaje> mensajes = ControladorFicherosMensajes.leerFicheroMensajes(ficheroMensaje);
				
				String texto = request.getParameter("mensajeNuevo");
				
				Mensaje m = new Mensaje(Integer.parseInt(request.getParameter("idNuevo")),(Persona) request.getSession().getAttribute("logueado"), texto);
				
				mensajes.add(m);
				
				ControladorFicherosMensajes.guardarArrayListMensajes(mensajes, ficheroMensaje);
				
				System.out.println("Mensaje guardado");
				
				response.sendRedirect("vistaLogueo.jsp");
				
				
			}
		
	}

}
