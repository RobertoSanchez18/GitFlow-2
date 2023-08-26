package pe.edu.vallegrande.app.pruebaMaestro2;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

public class Insert {
	public static void main(String[] args) {
		try {
			// Datos
			Profesor bean = new Profesor(0,"DNI", "71770488", "Carlos Diego", "Venturo", "Ramos", "2004/02/12", "971422231", "venturo@gmail.com", "T", "A");
			// Proceso
			CrudProfesorService profesorService = new CrudProfesorService();
			profesorService.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
