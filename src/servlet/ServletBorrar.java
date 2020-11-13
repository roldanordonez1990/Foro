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

import models.Mensaje;

/**
 * Servlet implementation class ServletBorrar
 */
@WebServlet(name = "/ServletBorrar", urlPatterns = { "/ServletBorrar" })
public class ServletBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBorrar() {
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

		Integer boton = Integer.parseInt(request.getParameter("eliminarMensaje"));

		String ficheroMensaje = "D:\\mensajes.dat";

		ArrayList<Mensaje> mensajes = ControladorFicherosMensajes.leerFicheroMensajes(ficheroMensaje);
		Mensaje men = null;
		for (Mensaje m : mensajes) {
System.out.println(m.getId());
System.out.println(boton);

			if (m.getId() == boton) {
				men = m;
			}
		}

		mensajes.remove(men);
		ControladorFicherosMensajes.guardarArrayListMensajes(mensajes, ficheroMensaje);
		System.out.println("Mensaje borrado");
		response.sendRedirect("vistaAdministrador.jsp");
	}

}
