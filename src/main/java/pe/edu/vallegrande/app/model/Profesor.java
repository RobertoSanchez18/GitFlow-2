package pe.edu.vallegrande.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Profesor {
	
	private Integer id;  
	private String document_type; 
	private String document_number; 
	private String names; 
	private String paternalSurname; 
	private String maternalSurname; 
	private String dateOfBirth; 
	private String cellphone; 
	private String gmail; 
	private String turn; 
	private String state;
	
}
