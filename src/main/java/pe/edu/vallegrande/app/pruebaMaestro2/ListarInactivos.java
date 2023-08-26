package pe.edu.vallegrande.app.pruebaMaestro2;

import java.util.List;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;


public class ListarInactivos {
	public static void main(String[] args) {
		try {
			// DATOS
			Profesor bean = new Profesor();
			bean.setPaternalSurname("");
			bean.setNames("");

			// Proceso
			CrudProfesorService estudianteService = new CrudProfesorService();
			List<Profesor> lista = estudianteService.getInac(bean);
			for (Profesor estudiante : lista) {
				System.out.println(estudiante);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
