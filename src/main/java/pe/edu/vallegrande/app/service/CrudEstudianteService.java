package pe.edu.vallegrande.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.app.db.AccesoDB;
import pe.edu.vallegrande.app.model.Aulas;
import pe.edu.vallegrande.app.model.Estudiante;
import pe.edu.vallegrande.app.service.spec.CrudServiceSpec;
import pe.edu.vallegrande.app.service.spec.RowMapper;

public class CrudEstudianteService implements CrudServiceSpec<Estudiante>, RowMapper<Estudiante> {

	// Definiendo cosas
	private final String SQL_SELECT_BASE = "SELECT * FROM student";

	@Override
	public Estudiante mapRow(ResultSet rs) throws SQLException {
		Estudiante bean = new Estudiante();
		// Columnas:
		bean.setId(rs.getInt("id"));
		bean.setTipoDocumento(rs.getString("document_type"));
		bean.setNumberDocumento(rs.getString("document_number"));
		bean.setNames(rs.getString("names"));
		bean.setPaternalSurname(rs.getString("paternal_surname"));
		bean.setMaternalSurname(rs.getString("maternal_surname"));
		bean.setFechaNacimiento(rs.getString("date_of_birth"));
		bean.setCelular(rs.getString("cellphone"));
		bean.setGmail(rs.getString("gmail"));
		bean.setTurn(rs.getString("turn"));
		bean.setState(rs.getString("state"));
		return bean;
	}

	// LISTAR TODA LA TABLA
	@Override
	public List<Estudiante> getAll() {
		// Variables
		Connection cn = null;
		List<Estudiante> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Estudiante bean;
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(SQL_SELECT_BASE);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bean = mapRow(rs);
				lista.add(bean);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		return lista;
	}

	// LISTAR ESTUDIANTE POR ID
	@Override
	public Estudiante getForId(String id) {
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Estudiante bean = null;
		String sql;
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			sql = SQL_SELECT_BASE + " WHERE id=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(id));
			rs = pstm.executeQuery();
			if (rs.next()) {
				bean = mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		return bean;
	}

	// INSERTAR NUEVO ESTUDIANTE
	@Override
	public void insert(Estudiante bean) {
		try (Connection conn = AccesoDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO student (document_type, document_number, names, paternal_surname, maternal_surname, date_of_birth, cellphone, gmail, turn, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			stmt.setString(1, bean.getTipoDocumento());
			stmt.setString(2, bean.getNumberDocumento());
			stmt.setString(3, bean.getNames());
			stmt.setString(4, bean.getPaternalSurname());
			stmt.setString(5, bean.getMaternalSurname());
			stmt.setString(6, bean.getFechaNacimiento());
			stmt.setString(7, bean.getCelular());
			stmt.setString(8, bean.getGmail());
			stmt.setString(9, bean.getTurn());
			stmt.setString(10, bean.getState());
			stmt.executeUpdate();
			System.out.println("Registro creado exitosamente");
		} catch (SQLException e) {
			System.err.println("Error al crear el registro: " + e.getMessage());
		}

	}

	// ACTUALIZAR UN ESTUDIANTE
	@Override
	public void update(Estudiante bean) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE student SET document_type = ?, document_number = ?, names = ?, paternal_surname = ?, maternal_surname = ?, date_of_birth = ?, "
								+ "cellphone = ?, gmail = ?, turn = ?, state = ? WHERE id = ?")) {

			preparedStatement.setString(1, bean.getTipoDocumento());
			preparedStatement.setString(2, bean.getNumberDocumento());
			preparedStatement.setString(3, bean.getNames());
			preparedStatement.setString(4, bean.getPaternalSurname());
			preparedStatement.setString(5, bean.getMaternalSurname());
			preparedStatement.setString(6, bean.getFechaNacimiento());
			preparedStatement.setString(7, bean.getCelular());
			preparedStatement.setString(8, bean.getGmail());
			preparedStatement.setString(9, bean.getTurn());
			preparedStatement.setString(10, bean.getState());
			preparedStatement.setInt(11, bean.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al actualizar el registro con ID " + bean.getId() + ": " + e.getMessage());
		}

	}

	// ELIMINAR UN ESTUDIANTE
	@Override
	public void delete(String id) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE student SET state= 'I' WHERE id = ?")) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al eliminar el registro con ID " + id + ": " + e.getMessage());
		}
	}

	/* BUSCAR POR NOMBRE Y APELLIDO */
	@Override
	public List<Estudiante> get(Estudiante bean) {
		Connection cn = null;
		List<Estudiante> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Estudiante item;
		String sql;
		String apellido;
		String nombre;
		// Preparar los datos
		apellido = "%" + UtilService.setStringVacio(bean.getPaternalSurname()) + "%";
		nombre = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// La consulta
			sql = "SELECT * FROM student WHERE paternal_surname LIKE ? AND names LIKE ? AND state = 'A'";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, apellido);
			pstm.setString(2, nombre);
			rs = pstm.executeQuery();
			while (rs.next()) {
				item = mapRow(rs);
				lista.add(item);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		return lista;
	}

	@Override
	public List<Estudiante> getAllInactivos(Estudiante bean) {
		Connection cn = null;
		List<Estudiante> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Estudiante item;
		String sql;
		String apellido;
		String nombre;
		// Preparar los datos
		apellido = "%" + UtilService.setStringVacio(bean.getPaternalSurname()) + "%";
		nombre = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// La consulta
			sql = "SELECT * FROM student WHERE paternal_surname LIKE ? AND names LIKE ? AND state = 'I'";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, apellido);
			pstm.setString(2, nombre);
			rs = pstm.executeQuery();
			while (rs.next()) {
				item = mapRow(rs);
				lista.add(item);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		return lista;

	}

	@Override
	public void ActualizarEstado(String id) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE student SET state= 'A' WHERE id = ?")) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al eliminar el registro con ID " + id + ": " + e.getMessage());
		}
	}

	@Override
	public List<Estudiante> BuscarDni(Estudiante bean) {
		List<Estudiante> estudiantes = new ArrayList<>();
		try {
			// Create a connection to the database
			Connection conn = AccesoDB.getConnection();

			// Prepare the SQL statement with a parameter for the DNI
			String sql = "SELECT * FROM student WHERE document_number = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, bean.getNumberDocumento());

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Process the results
			if (rs.next()) {
				Estudiante estudiante = new Estudiante();
				// Retrieve the data from the result set
				estudiante.setTipoDocumento(rs.getString("document_type"));
				estudiante.setNumberDocumento(rs.getString("document_number"));
				estudiante.setNames(rs.getString("names"));
				estudiante.setPaternalSurname(rs.getString("paternal_surname"));
				estudiante.setMaternalSurname(rs.getString("maternal_surname"));
				estudiante.setFechaNacimiento(rs.getString("date_of_birth"));
				estudiante.setCelular(rs.getString("cellphone"));
				estudiante.setGmail(rs.getString("gmail"));
				estudiante.setTurn(rs.getString("turn"));
				// ... Retrieve other columns as needed

				// Do something with the retrieved data
				// ...
				estudiantes.add(estudiante);
			}

			// Close the resources
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudiantes;
	}

	@Override
	public List listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Aulas aul) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(Aulas aul) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Aulas aul) {
		// TODO Auto-generated method stub
		return false;
	}

}
