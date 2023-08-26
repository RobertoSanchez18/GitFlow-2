package pe.edu.vallegrande.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
	
	private int id;
	private String nombreuser;
	private String correo;
	private String celular;
	private String pass;
	
}
