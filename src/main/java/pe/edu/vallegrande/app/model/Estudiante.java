package pe.edu.vallegrande.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estudiante {
	
	private Integer id;
	private String tipoDocumento;
	private String numberDocumento;
	private String names;
	private String paternalSurname;
	private String maternalSurname;
	private String fechaNacimiento;
	private String celular;
	private String gmail;
	private String turn;
	private String state;
		
}
