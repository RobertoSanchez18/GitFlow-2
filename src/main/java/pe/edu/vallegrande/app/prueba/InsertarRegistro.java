package pe.edu.vallegrande.app.prueba;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class InsertarRegistro {
	public static void main(String[] args) {
		try {
			// Datos
			Estudiante bean = new Estudiante(0,"DNI", "72720488", "JUAN LUIS", "ESPINOZA", "NOVOA", "2004/02/12", "970400231", "luis@gmail.com", "T", "A");
			// Proceso
			CrudEstudianteService estudianteService = new CrudEstudianteService();
			estudianteService.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
