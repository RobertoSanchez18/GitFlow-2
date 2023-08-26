package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

/**
 * Servlet implementation class EstudianteController
 */
@WebServlet({ "/EstudianteBuscar", "/EstudianteBuscar2", "/EstudianteProcesar", "/EstudianteBuscarInactivos",
		"/EstudianteBuscarDni" })
public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CrudEstudianteService service = new CrudEstudianteService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/EstudianteBuscar":
			buscar(request, response);
			break;
		case "/EstudianteBuscar2":
			buscar2(request, response);
			break;
		case "/EstudianteProcesar":
			procesar(request, response);
			break;
		case "/EstudianteBuscarInactivos":
			buscarInactivos(request, response);
			break;
		case "/EstudianteBuscarDni":
			buscarDni(request, response);
			break;
		}
	}

	private void buscarDni(HttpServletRequest request, HttpServletResponse response) {
		String dni = request.getParameter("dni");
		Estudiante bean = new Estudiante();
		bean.setNumberDocumento(dni);
		List<Estudiante> lista = service.BuscarDni(bean);

		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);

		// Reporte
		ControllerUtil.responseJson(response, data);

	}

	private void buscarInactivos(HttpServletRequest request, HttpServletResponse response) {
		// Datos
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");

		// Proceso
		Estudiante bean = new Estudiante();
		bean.setPaternalSurname(apellido);
		bean.setNames(nombre);
		List<Estudiante> lista = service.getAllInactivos(bean);

		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);

		// Reporte
		ControllerUtil.responseJson(response, data);

	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		String accion = request.getParameter("accion");
		Estudiante bean = new Estudiante();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setTipoDocumento(request.getParameter("tipoDocumento"));
		bean.setNumberDocumento(request.getParameter("numeroDocumento"));
		bean.setNames(request.getParameter("nombre"));
		bean.setPaternalSurname(request.getParameter("apellidoPaterno"));
		bean.setMaternalSurname(request.getParameter("apellidoMaterno"));
		bean.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		bean.setCelular(request.getParameter("celular"));
		bean.setGmail(request.getParameter("gmail"));
		bean.setTurn(request.getParameter("turno"));
		bean.setState(request.getParameter("estado"));

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
				service.delete(bean.getId().toString());
				break;
			case ControllerUtil.CRUD_ACTUALIZAR_ESTADO:
				service.ActualizarEstado(bean.getId().toString());
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
			ControllerUtil.responseJson(response, "Proceso ok.");
		} catch (Exception e) {
			ControllerUtil.responseJson(response, e.getMessage());
		}
	}

	private void buscar2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Datos
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");

		// Proceso
		Estudiante bean = new Estudiante();
		bean.setPaternalSurname(apellido);
		bean.setNames(nombre);
		List<Estudiante> lista = service.get(bean);

		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);

		// Reporte
		ControllerUtil.responseJson(response, data);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
		// Proceso
		CrudEstudianteService bean = new CrudEstudianteService();
		bean.getAll();
		List<Estudiante> lista = service.getAll();
		// Reporte
		request.setAttribute("listado", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Estudiantes.jsp");
		rd.forward(request, response);

	}

}
