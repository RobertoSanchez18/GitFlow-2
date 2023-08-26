package pe.edu.vallegrande.app.pruebaMaestro2;

import pe.edu.vallegrande.app.service.CrudProfesorService;

public class Delete {
	public static void main(String[] args) {

		CrudProfesorService profesorService = new CrudProfesorService();

		String idToDelete = "5";
		profesorService.delete(idToDelete);

		try {
			System.out.println("El Registro con ID " + idToDelete + " ha sido eliminado exitosamente");
		} catch(Exception e) {
			System.out.println("Error: el registro con ID " + idToDelete + "no ha sido eliminado");
		}
	}
}
