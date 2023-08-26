package pe.edu.vallegrande.app.prueba;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class ActualizarRegistro {
	
	public static void main(String[] args) {
		try {
			// Datos
			Estudiante bean = new Estudiante(7, "DNI", "72720455", "CARLOS HUMBERTO", "RAMOS", "CLAROS", "2000-04-22", "970400401", "carlos@gmail.com", "T", "A");
			// Proceso
			CrudEstudianteService estudianteService = new CrudEstudianteService();
			estudianteService.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
