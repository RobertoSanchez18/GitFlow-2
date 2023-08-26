package pe.edu.vallegrande.app.prueba;

import java.util.List;

import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.CrudEstudianteService;

public class BuscarPorDni {
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante();
		estudiante.setNumberDocumento("72720487"); // DNI a buscar en la base de datos

		CrudEstudianteService searcher = new CrudEstudianteService();
		List<Estudiante> estudiantes = searcher.BuscarDni(estudiante);

		if (!estudiantes.isEmpty()) {
			for (Estudiante e : estudiantes) {
				System.out.println("Tipo de Documento: " + e.getTipoDocumento());
				System.out.println("Número de Documento: " + e.getNumberDocumento());
				System.out.println("Nombres: " + e.getNames());
				System.out.println("Apellido Paterno: " + e.getPaternalSurname());
				System.out.println("Apellido Materno: " + e.getMaternalSurname());
				System.out.println("Fecha de Nacimiento: " + e.getFechaNacimiento());
				System.out.println("Celular: " + e.getCelular());
				System.out.println("Gmail: " + e.getGmail());
				System.out.println("Turno: " + e.getTurn());
				// ... Imprimir otros atributos según sea necesario
			}
		} else {
			System.out.println("No se encontraron estudiantes con el DNI proporcionado.");
		}
	}
}
