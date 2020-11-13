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
 * Servlet implementation class ServletLoguear
 */
@WebServlet(name = "/ServletLoguear", urlPatterns = { "/ServletLoguear" })
public class ServletLoguear extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLoguear() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter out = response.getWriter();

		Boolean logueado = false;
		Boolean administrador = false;
		Boolean normal = false;

		String fichero = "D:\\personas.dat";
		String ficheroAdmin = "D:\\admin.dat";

		ArrayList<Persona> personas = ControladorFicherosMensajes.leerFichero(fichero);
		ArrayList<Administrador> administradores = ControladorFicherosMensajes.leerFicheroAdmin(ficheroAdmin);
		Persona per = null;
		Administrador ad = null;

		for (Persona p : personas) {
			if (p.getNombre().equals(request.getParameter("usuario")) && p.getPassword().equals(request.getParameter("pass"))) {
				logueado = true;
				normal = true;
				per = p;
			}
				

		}

		for (Administrador admi : administradores) {
			if (admi.getNombre().equals(request.getParameter("usuario")) && admi.getPass().equals(request.getParameter("pass"))) {
				logueado = true;
				administrador = true;
				ad = admi;
				
				
			}
		}
		if (!logueado) {
			response.sendRedirect("index.jsp");

		}

		else if(administrador == true){
			request.getSession().setAttribute("logueado", ad);
			response.sendRedirect("vistaAdministrador.jsp");
			 
				
		}else if(normal == true) {
			request.getSession().setAttribute("logueado", per);
			response.sendRedirect("vistaLogueo.jsp");
			}
		
	}
}
