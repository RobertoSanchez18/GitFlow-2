package pe.edu.vallegrande.app.pruebaMaestro2;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

public class BuscarPorID {
	
	public static void main(String[] args) {
		try {
			CrudProfesorService profesorService = new CrudProfesorService();
			Profesor bean = profesorService.getForId("4");
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
