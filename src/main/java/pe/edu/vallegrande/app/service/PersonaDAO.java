package pe.edu.vallegrande.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.app.db.AccesoDB;
import pe.edu.vallegrande.app.model.Persona;
import pe.edu.vallegrande.app.service.spec.Validar;

public class PersonaDAO implements Validar<Persona> {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public int validar(Persona per) {
		int r=0;
		String sql = "SELECT * FROM persona where nombreuser=? and pass=?";
		try {
			con= AccesoDB.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, per.getNombreuser());
			ps.setString(2, per.getPass());
			rs=ps.executeQuery();
			while(rs.next()) {
				r=r+1;
				per.setNombreuser(rs.getString("nombreuser"));
				per.setPass(rs.getString("pass"));
			}
			if(r==1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
		
	}

	

	@Override
	public void delete(int id) {
		
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM persona WHERE id = ?")){
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro con Id " + id + ": " + e.getMessage());
		}
		
	}



	@Override
	public void insert(Persona bean) {
		try (Connection conn = AccesoDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO persona (nombreuser, correo, celular, pass) VALUES (?,?,?,?)")){
			stmt.setString(1, bean.getNombreuser());
			stmt.setString(2, bean.getCorreo());
			stmt.setString(3, bean.getCelular());
			stmt.setString(4, bean.getPass());
			stmt.executeUpdate();
			System.out.println("Usuario nuevo creado exitosamente");
		
		} catch (Exception e) {
			System.err.println("Error al crear el usuario: " + e.getMessage());
		}
		
	}



	@Override
	public List<Persona> get(Persona bean) {
		Connection cn = null;
		List<Persona> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Persona item;
		String sql;
		String nombre;
		// Preparar los datos
		nombre = "%" + UtilService.setStringVacio(bean.getNombreuser()) + "%";
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// La consulta
			sql = "SELECT * FROM persona WHERE nombreuser LIKE ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
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



	private Persona mapRow(ResultSet rs2) throws SQLException {
		Persona bean = new Persona();
		// Columnas:
		bean.setId(rs2.getInt("id"));
		bean.setNombreuser(rs2.getString("nombreuser"));
		bean.setCorreo(rs2.getString("correo"));
		bean.setCelular(rs2.getString("celular"));
		bean.setPass(rs2.getString("pass"));
		return bean;
	}



	@Override
	public void update(Persona bean) {
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE persona SET nombreuser = ?, correo = ?, celular = ?, pass = ? WHERE id = ?")) {

			preparedStatement.setString(1, bean.getNombreuser());
			preparedStatement.setString(2, bean.getCorreo());
			preparedStatement.setString(3, bean.getCelular());
			preparedStatement.setString(4, bean.getPass());;
			preparedStatement.setInt(5, bean.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al actualizar el registro con ID " + bean.getId() + ": " + e.getMessage());
		}
		
	}

}
