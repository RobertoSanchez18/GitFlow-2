package pe.edu.vallegrande.app.pruebaMaestro2;

import pe.edu.vallegrande.app.service.CrudProfesorService;

public class ActualizarEstadoInactivos {
	public static void main(String[] args) {

		CrudProfesorService profesorService = new CrudProfesorService();

		String idToUpdate = "5";
		profesorService.updateState(idToUpdate);

		try {
			System.out.println("El Registro con ID " + idToUpdate + " ha sido actualizado correctamente");
		} catch (Exception e) {
			System.out.println("Error: el registro con ID " + idToUpdate + "no ha sido actualizado");
		}

	}
}
