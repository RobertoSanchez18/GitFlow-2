package pe.edu.vallegrande.app.prueba.Persona;

import pe.edu.vallegrande.app.model.Persona;
import pe.edu.vallegrande.app.service.PersonaDAO;

public class CrearUsuario {
	
	public static void main(String[] args) {
		try {
			// Datos
			Persona bean = new Persona(0, "Juan Jose", "juan@gmailcom", "944663772", "juan123");
			// Proceso
			PersonaDAO personaService = new PersonaDAO();
			personaService.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
