package pe.edu.vallegrande.app.pruebaMaestro2;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

public class Update {
	public static void main(String[] args) {
		try {
			Profesor bean = new Profesor(6, "DNI", "77772221", "Isabel Luz", "Claros", "Espichan", "2000-02-18", "980032122", "isabel@gmail.com", "M", "A");
			CrudProfesorService profesorService = new CrudProfesorService();
			profesorService.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
