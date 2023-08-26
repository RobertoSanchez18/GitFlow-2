package pe.edu.vallegrande.app.prueba;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class EliminarRegistro {
	
	public static void main(String[] args) {
		
		CrudEstudianteService estudianteService = new CrudEstudianteService();
		
		String idToDelete = "7";
		estudianteService.delete(idToDelete);
		
		Estudiante estudiante = estudianteService.getForId(idToDelete);
		if (estudiante == null) {
			System.out.println("El Registro con ID " + idToDelete + " ha sido eliminado exitosamente");
		} else {
			System.out.println("Error: el registro con ID " + idToDelete + "no ha sido eliminado");
		}
	}
}
