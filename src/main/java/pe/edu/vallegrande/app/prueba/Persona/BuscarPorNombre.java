package pe.edu.vallegrande.app.prueba.Persona;

import java.util.List;
import pe.edu.vallegrande.app.model.Persona;
import pe.edu.vallegrande.app.service.PersonaDAO;

public class BuscarPorNombre {
	
	public static void main(String[] args) {
		try {
			//DATOS
			Persona bean = new Persona();
			bean.setNombreuser("");
			
			//Proceso
			PersonaDAO personaService = new PersonaDAO();
			List<Persona> lista = personaService.get(bean);
			for(Persona person : lista) {
				System.out.println(person);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
