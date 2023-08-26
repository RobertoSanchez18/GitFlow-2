package pe.edu.vallegrande.app.pruebaMaestro2;

import java.sql.SQLException;
import java.util.List;

import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.CrudProfesorService;

public class Listar {
	public static void main(String[] args) throws SQLException {
		CrudProfesorService profesorService = new CrudProfesorService();
		List<Profesor> lista = profesorService.getAll();
		
		if (lista != null) {
			for (Profesor profesor : lista) {
				System.out.println(profesor.toString());
			}
		}	
	}
}