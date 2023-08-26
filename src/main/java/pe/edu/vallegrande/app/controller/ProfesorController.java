package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

/**
 * Servlet implementation class ProfesorController
 */
@WebServlet({ "/ProfesorBuscar2", "/ProfesorProcesar", "/ProfesorBuscarInactivos" })
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CrudProfesorService service = new CrudProfesorService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/ProfesorBuscar2":
			buscar2(request, response);
			break;
		case "/ProfesorProcesar":
			procesar(request, response);
			break;
		case "/ProfesorBuscarInactivos":
			buscarInactivos(request, response);
			break;
		}

	}

	private void buscarInactivos(HttpServletRequest request, HttpServletResponse response) {
		// Datos
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");

		// Proceso
		Profesor bean = new Profesor();
		bean.setPaternalSurname(apellido);
		bean.setNames(nombre);
		List<Profesor> lista = service.getInac(bean);

		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);

		// Reporte
		ControllerUtil.responseJson(response, data);

	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		String accion = request.getParameter("accion");
		Profesor bean = new Profesor();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setDocument_type(request.getParameter("tipoDocumento"));
		bean.setDocument_number(request.getParameter("numeroDocumento"));
		bean.setNames(request.getParameter("nombre"));
		bean.setPaternalSurname(request.getParameter("apellidoPaterno"));
		bean.setMaternalSurname(request.getParameter("apellidoMaterno"));
		bean.setDateOfBirth(request.getParameter("fechaNacimiento"));
		bean.setCellphone(request.getParameter("celular"));
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
				service.updateState(bean.getId().toString());
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
		} catch (Exception e) {
			ControllerUtil.responseJson(response, e.getMessage());
		}

	}

	private void buscar2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Datos
		String apellidoProfesor = request.getParameter("apellido");
		String nombreProfesor = request.getParameter("nombre");

		// Proceso
		Profesor bean = new Profesor();
		bean.setPaternalSurname(apellidoProfesor);
		bean.setNames(nombreProfesor);
		List<Profesor> lista = service.get(bean);

		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);

		// Reporte
		ControllerUtil.responseJson(response, data);
	}
}