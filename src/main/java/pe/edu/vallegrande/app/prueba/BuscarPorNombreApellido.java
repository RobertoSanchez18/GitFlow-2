package pe.edu.vallegrande.app.prueba;

import java.util.List;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class BuscarPorNombreApellido {
	public static void main(String[] args) {
		try {
			//DATOS
			Estudiante bean = new Estudiante();
			bean.setPaternalSurname("");
			bean.setNames("Rosa");
			
			//Proceso
			CrudEstudianteService estudianteService = new CrudEstudianteService();
			List<Estudiante> lista = estudianteService.get(bean);
			for(Estudiante estudiante : lista) {
				System.out.println(estudiante);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
