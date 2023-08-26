package pe.edu.vallegrande.app.pruebaMaestro2;

import java.util.List;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

public class BuscarNameApellido {
	public static void main(String[] args) {
		try {
			// DATOS
			Profesor bean = new Profesor();
			bean.setPaternalSurname("");
			bean.setNames("");

			// Proceso
			CrudProfesorService profesorService = new CrudProfesorService();
			List<Profesor> lista = profesorService.get(bean);
			for (Profesor profesor : lista) {
				System.out.println(profesor);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
