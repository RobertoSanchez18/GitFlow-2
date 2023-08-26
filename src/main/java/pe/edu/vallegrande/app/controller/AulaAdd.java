package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;

/**
 * Servlet implementation class AulaAdd
 */
@WebServlet("/AulaAdd")
public class AulaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Aulas aul = new Aulas();
	AulasDAO dao = new AulasDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AulaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grado = request.getParameter("txtGrado");
		String seccion = request.getParameter("txtSeccion");
		
		aul.setGrado(grado);
		aul.setSeccion(seccion);
		dao.add(aul);
		
		response.sendRedirect(request.getContextPath() + "/aulas.jsp");
	}

}
