package pe.edu.vallegrande.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

/**
 * Servlet implementation class AulaController
 */
@WebServlet("/AulaController")
public class AulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String listar = "/aulas.jsp";
	Aulas aul = new Aulas();
	AulasDAO dao = new AulasDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AulaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acceso = "";
		String action = request.getParameter("accion");
		if (action.equalsIgnoreCase("listar")) {
			acceso = listar;
		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "Delete":
			String id = request.getParameter("deleteId");
			dao.delete(id);
			request.setAttribute("eliminado", true);
			response.sendRedirect(request.getContextPath() + "/aulas.jsp");
			break;

		default:
			break;
		}
		
		
	}

}
