package pe.edu.vallegrande.app.prueba;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class BuscarPorID {
	
	public static void main(String[] args) {
		try {
			CrudEstudianteService estudianteService = new CrudEstudianteService();
			Estudiante bean = estudianteService.getForId("4");
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
