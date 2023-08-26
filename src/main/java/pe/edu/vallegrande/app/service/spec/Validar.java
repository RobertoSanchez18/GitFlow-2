package pe.edu.vallegrande.app.service.spec;

import java.util.List;

import pe.edu.vallegrande.app.model.Persona;

public interface Validar<T> {
	public int validar(Persona per);
	
	/**
	 * Insertar nuevo registro.
	 * @param bean Datos del nuevo registro.
	 */
	void insert(Persona bean);
	
	/**
	 * Elimina un registro de la base de datos.
	 * @param id El id del registro a eliminar.
	 */
	/*void delete(String id);*/
	
	/**
	 * Consulta datos en base a un criterio con estados activos y por nombre y apellidos.
	 * @param bean Datos para establecer el criterio.
	 * @return Retorna una lista.
	 */
	List<Persona> get(Persona bean);
	
	/**
	 * Actualiza datos de un registro especifico.
	 * @param bean Datos del registro.
	 */
	void update(Persona bean);

	void delete(int id);
	
	
}
