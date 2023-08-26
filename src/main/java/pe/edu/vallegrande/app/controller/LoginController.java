package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande.app.model.Persona;
import pe.edu.vallegrande.app.service.PersonaDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonaDAO dao = new PersonaDAO();
	Persona p = new Persona();
	int r;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion.equals("Ingresar")) {
			String nameUser = request.getParameter("txtNameUser");
			String pass = request.getParameter("txtPassword");
			p.setNombreuser(nameUser);
			p.setPass(pass);
			r = dao.validar(p);
			if (r == 1) {
				request.getSession().setAttribute("nombreuser", nameUser);
				response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

}
