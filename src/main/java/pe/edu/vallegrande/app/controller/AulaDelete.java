package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;

/**
 * Servlet implementation class AulaDelete
 */
@WebServlet({"/AulaDelete", "/AulaEdit"})
public class AulaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Aulas aul = new Aulas();
	AulasDAO dao = new AulasDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AulaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch (path) {
		case "/AulaEdit": 
			edit(request, response);
			break;
		case "/AulaDelete":
			delete(request, response);
		}
	
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("deleteId");
		dao.delete(id);
		request.setAttribute("eliminado", true);
		response.sendRedirect(request.getContextPath() + "/aulas.jsp");
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect(request.getContextPath() + "/vistas/aulasEdit.jsp");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
