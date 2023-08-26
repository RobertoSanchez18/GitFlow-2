package pe.edu.vallegrande.app.prueba.aulas;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;

public class EliminarAula {
	
	public static void main(String[] args) {
		
		AulasDAO aulaService = new AulasDAO();
		
		String idToDelete = "14";
		aulaService.delete(idToDelete);
		
		Aulas aula = aulaService.getForId(idToDelete);
		if (aula == null) {
			System.out.println("El Aula con ID " + idToDelete + " ha sido eliminado exitosamente");
		} else {
			System.out.println("Error: el Aula con ID " + idToDelete + "no ha sido eliminado");
		}
		
	}
	 
}
