package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.model.Persona;
import pe.edu.vallegrande.app.service.PersonaDAO;

/**
 * Servlet implementation class PersonaController
 */
@WebServlet({"/PersonaController", "/PersonaBuscar", "/PersonaProcesar"})
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private PersonaDAO service = new PersonaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/PersonaBuscar":
			buscarUser(request, response);
			break;
		case "/PersonaProcesar":
			procesar(request, response);
			break;
		}
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		String accion = request.getParameter("accion");
		Persona bean = new Persona();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setNombreuser(request.getParameter("nombreUsuario"));
		bean.setCorreo(request.getParameter("correo"));
		bean.setCelular(request.getParameter("celular"));
		bean.setPass(request.getParameter("pass"));

		// Proceso
		try {
			switch (accion) {
			case ControllerUtil.CRUD_NUEVO:
				service.insert(bean);
				break;
			case ControllerUtil.CRUD_EDITAR:
				service.update(bean);
				break;
			case ControllerUtil.CRUD_ELIMINAR:
				service.delete(bean.getId());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
			ControllerUtil.responseJson(response, "Proceso ok.");
		} catch (Exception e) {
			ControllerUtil.responseJson(response, e.getMessage());
		}
	}

	private void buscarUser(HttpServletRequest request, HttpServletResponse response) {
		String nameUser = request.getParameter("nombreuser");
		
		Persona bean = new Persona();
		bean.setNombreuser(nameUser);
		
		List<Persona> list = service.get(bean);
		
		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(list);
		
		// Reporte
		ControllerUtil.responseJson(response, data);
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
