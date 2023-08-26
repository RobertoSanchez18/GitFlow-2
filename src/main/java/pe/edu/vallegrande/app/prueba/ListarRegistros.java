package pe.edu.vallegrande.app.prueba;

import java.util.List;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;



public class ListarRegistros {
	
	public static void main(String[] args) {
		try {
			CrudEstudianteService estudianteService = new CrudEstudianteService();
			List<Estudiante> lista = estudianteService.getAll();
			for (Estudiante estudiante : lista) {
				System.out.println(estudiante);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
