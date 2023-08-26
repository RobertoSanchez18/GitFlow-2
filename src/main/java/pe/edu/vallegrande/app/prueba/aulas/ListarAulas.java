package pe.edu.vallegrande.app.prueba.aulas;

import java.util.List;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.service.AulasDAO;

public class ListarAulas {

	public static void main(String[] args) {
		try {
			AulasDAO aulaService = new AulasDAO();
			List<Aulas> lista = aulaService.getAll();
			for (Aulas aula : lista) {
				System.out.println(aula);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
