package pe.edu.vallegrande.app.prueba.aulas;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;

public class InsertarAula {

	public static void main(String[] args) {
		try {
			// Datos
			Aulas bean = new Aulas(0, "6", "A");
			// Proceso
			AulasDAO aulaService = new AulasDAO();
			aulaService.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
