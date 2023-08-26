package pe.edu.vallegrande.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.app.db.AccesoDB;
import pe.edu.vallegrande.app.model.Profesor;
import pe.edu.vallegrande.app.service.spec.CrudServiceSpecMaestro2;
import pe.edu.vallegrande.app.service.spec.RowMapper;

public class CrudProfesorService implements CrudServiceSpecMaestro2<Profesor>, RowMapper<Profesor> {

	@Override
	public Profesor mapRow(ResultSet rs) throws SQLException {
		Profesor bean = new Profesor();
		bean.setId(rs.getInt("id"));
		bean.setDocument_type(rs.getString("document_type"));
		bean.setDocument_number(rs.getString("document_number"));
		bean.setNames(rs.getString("names"));
		bean.setPaternalSurname(rs.getString("paternal_surname"));
		bean.setMaternalSurname(rs.getString("maternal_surname"));
		bean.setDateOfBirth(rs.getString("date_of_birth"));
		bean.setCellphone(rs.getString("cellphone"));
		bean.setGmail(rs.getString("gmail"));
		bean.setTurn(rs.getString("turn"));
		bean.setState(rs.getString("state"));
		return bean;
	}

	@Override
	public List<Profesor> getAll() throws SQLException {
		Connection con = AccesoDB.getConnection();

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM teacher");

			System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s %-15s %-15s %-25s %-15s %-15s%n", "ID",
					"DOCUMENT TYPE", "DOCUMENT NUMBER", "NAMES", "PATERNAL SURNAME", "MATERNAL SURNAME",
					"DATE OF BIRTH", "CELLPHONE", "GMAIL", "TURN", "STATE");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String documentType = resultSet.getString("document_type");
				String documentNumber = resultSet.getString("document_number");
				String names = resultSet.getString("names");
				String paternal_surname = resultSet.getString("paternal_surname");
				String maternal_surname = resultSet.getString("maternal_surname");
				String dateOfBirth = resultSet.getString("date_of_birth");
				String cellphone = resultSet.getString("cellphone");
				String gmail = resultSet.getString("gmail");
				String turn = resultSet.getString("turn");
				String state = resultSet.getString("state");

				System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s %-15s %-15s %-25s %-15s %-15s%n", id,
						documentType, documentNumber, names, paternal_surname, maternal_surname, dateOfBirth, cellphone,
						gmail, turn, state);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.err.println("Error while fetching students: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Profesor getForId(String id) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Profesor bean = null;
		String sql;
		try {
			cn = AccesoDB.getConnection();
			sql = "SELECT * FROM teacher WHERE id = ?";
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

	@Override
	public List<Profesor> get(Profesor bean) {
		Connection cn = null;
		List<Profesor> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Profesor item;
		String sql;
		String apellido;
		String nombre;
		apellido = "%" + UtilService.setStringVacio(bean.getPaternalSurname()) + "%";
		nombre = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
		try {
			cn = AccesoDB.getConnection();
			sql = "SELECT * FROM teacher WHERE paternal_surname LIKE ? AND names LIKE ? AND state = 'A'";
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
	public void insert(Profesor bean) {
		String sql = "INSERT INTO teacher (document_type, document_number, names, paternal_surname, maternal_surname, date_of_birth, cellphone, gmail, turn, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection cn = AccesoDB.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql)) {
			pstm.setString(1, bean.getDocument_type());
			pstm.setString(2, bean.getDocument_number());
			pstm.setString(3, bean.getNames());
			pstm.setString(4, bean.getPaternalSurname());
			pstm.setString(5, bean.getMaternalSurname());
			pstm.setString(6, bean.getDateOfBirth());
			pstm.setString(7, bean.getCellphone());
			pstm.setString(8, bean.getGmail());
			pstm.setString(9, bean.getTurn());
			pstm.setString(10, bean.getState());
			pstm.executeUpdate();
			System.out.println("Registro Creado correctamente");
		} catch (Exception e) {
			System.err.println("Error al crear el registro: " + e.getMessage());
		}
	}

	@Override
	public void update(Profesor bean) {
		String sql = "UPDATE teacher SET document_type = ?, document_number = ?, names = ?, paternal_surname = ?, maternal_surname = ?, date_of_birth = ?, "
				+ "cellphone = ?, gmail = ?, turn = ?, state = ? WHERE id = ?";
		try (Connection cn = AccesoDB.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql)) {
			pstm.setString(1, bean.getDocument_type());
			pstm.setString(2, bean.getDocument_number());
			pstm.setString(3, bean.getNames());
			pstm.setString(4, bean.getPaternalSurname());
			pstm.setString(5, bean.getMaternalSurname());
			pstm.setString(6, bean.getDateOfBirth());
			pstm.setString(7, bean.getCellphone());
			pstm.setString(8, bean.getGmail());
			pstm.setString(9, bean.getTurn());
			pstm.setString(10, bean.getState());
			pstm.setInt(11, bean.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error al actualizar el registro con ID " + bean.getId() + ": " + e.getMessage());
		}

	}

	@Override
	public void delete(String id) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE teacher SET state = 'I' WHERE id = ?")) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al eliminar el registro con ID " + id + ": " + e.getMessage());
		}
	}

	@Override
	public List<Profesor> getInac(Profesor bean) {
		Connection cn = null;
		List<Profesor> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Profesor item;
		String sql;
		String apellido;
		String nombre;
		apellido = "%" + UtilService.setStringVacio(bean.getPaternalSurname()) + "%";
		nombre = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
		try {
			cn = AccesoDB.getConnection();
			sql = "SELECT * FROM teacher WHERE paternal_surname LIKE ? AND names LIKE ? AND state = 'I'";
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
	public void updateState(String id) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE teacher SET state= 'A' WHERE id = ?")) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al actualizar el registro con ID " + id + ": " + e.getMessage());
		}

	}

}
