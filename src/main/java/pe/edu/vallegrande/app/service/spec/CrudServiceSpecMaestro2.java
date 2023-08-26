package pe.edu.vallegrande.app.service.spec;

import java.sql.SQLException;
import java.util.List;


public interface CrudServiceSpecMaestro2<T> {
	
	/**
	 * Consulta todos los registros de la tabla.
	 * @return Retorna una lista.
	 * @throws SQLException 
	 */
	List<T> getAll() throws SQLException;
	
	/**
	 * Retorna un registro basado en el id.
	 * @param id
	 * @return
	 */
	T getForId(String id);
	
	/**
	 * Consulta todos los registros de la tabla que son Inactivos.
	 * @return Retorna una lista.
	 */
	List<T> getInac(T bean);

	/**
	 * Consulta datos en base a un criterio.
	 * @param bean Datos para establecer el criterio.
	 * @return Retorna una lista.
	 */
	List<T> get(T bean);

	/**
	 * Insertar nuevo registro.
	 * @param bean Datos del nuevo registro.
	 */
	void insert(T bean);
	
	/**
	 * Actualiza un registro de la base de datos su estado.
	 * @param id El id del registro a eliminar.
	 */
	void updateState(String id);

	/**
	 * Actualiza datos de un registro especifico.
	 * @param bean Datos del registro.
	 */
	void update(T bean);

	/**
	 * Elimina un registro de la base de datos.
	 * @param id El id del registro a eliminar.
	 */
	void delete(String id);

}	
