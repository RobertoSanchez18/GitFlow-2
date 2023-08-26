package pe.edu.vallegrande.app.service.spec;

import java.util.List;

import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.model.Estudiante;

public interface CrudServiceSpec<T> {
	
	/**
	 * Consulta todos los registros de la tabla.
	 * @return Retorna una lista.
	 */
	List<T> getAll();
	
	/**
	 * Consulta todos los registros de la tabla que son Inactivos.
	 * @return Retorna una lista.
	 */
	List<T> getAllInactivos(T bean);
	
	/**
	 * Retorna un registro basado en el id.
	 * @param id
	 * @return
	 */
	T getForId(String id);

	/**
	 * Consulta datos en base a un criterio con estados activos y por nombre y apellidos.
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
	 * Actualiza datos de un registro especifico.
	 * @param bean Datos del registro.
	 */
	void update(T bean);

	/**
	 * Elimina un registro de la base de datos.
	 * @param id El id del registro a eliminar.
	 */
	void delete(String id);
	
	/**
	 * Actualiza un registro de la base de datos su estado.
	 * @param id El id del registro a eliminar.
	 */
	void ActualizarEstado(String id);
	
	/**
	 * Busca un registro por su numero de documento.
	 * @param id El id del registro a eliminar.
	 * @return 
	 */
	List<Estudiante> BuscarDni(T bean);
	
	public List listar();
	
	public boolean add(Aulas aul);
	public boolean edit(Aulas aul);
	public boolean eliminar(Aulas aul);
}
