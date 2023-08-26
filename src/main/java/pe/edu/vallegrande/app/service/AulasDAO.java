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

public class AulasDAO implements CrudServiceSpec<Aulas>, RowMapper<Aulas> {
	
	AccesoDB cn = new AccesoDB();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Aulas a = new Aulas();

	@Override
	public Aulas mapRow(ResultSet rs) throws SQLException {
		Aulas bean = new Aulas();

		bean.setId(rs.getInt("id"));
		bean.setGrado(rs.getString("grado"));
		bean.setSeccion(rs.getString("seccion"));
		return bean;

	}

	@Override
	public List<Aulas> getAll() {
		
		Connection cn = null;
		List<Aulas> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Aulas bean;

		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement("SELECT * FROM aulas");
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

	@Override
	public List<Aulas> getAllInactivos(Aulas bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aulas getForId(String id) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Aulas bean = null;
		String sql;
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			sql = "SELECT * FROM aulas WHERE id=?";
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
	public List<Aulas> get(Aulas bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Aulas bean) {
		
		try (Connection conn = AccesoDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO aulas (grado, seccion) VALUES (?, ?)")) {
			stmt.setString(1, bean.getGrado());
			stmt.setString(2, bean.getSeccion());
			stmt.executeUpdate();
			System.out.println("Aula creada exitosamente");
		} catch (SQLException e) {
			System.err.println("Error al crear el aula: " + e.getMessage());
		}

	}

	@Override
	public void update(Aulas bean) {
		
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE aulas SET grado = ?, seccion = ? WHERE id = ?")) {

			preparedStatement.setString(1, bean.getGrado());
			preparedStatement.setString(2, bean.getSeccion());
			preparedStatement.setInt(3, bean.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al actualizar el aula con ID " + bean.getId() + ": " + e.getMessage());
		}

	}

	@Override
	public void delete(String id) {
		
		try (Connection connection = AccesoDB.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM aulas WHERE id = ?")) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al eliminar el aula con ID " + id + ": " + e.getMessage());
		}

	}

	@Override
	public void ActualizarEstado(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Estudiante> BuscarDni(Aulas bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listar() {
		ArrayList<Aulas>list=new ArrayList<>();
		String sql= "SELECT * FROM aulas";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Aulas aul = new Aulas();
				aul.setId(rs.getInt("id"));
				aul.setGrado(rs.getString("grado"));
				aul.setSeccion(rs.getString("seccion"));
				list.add(aul);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public boolean add(Aulas aul) {
		String sql = "INSERT INTO aulas (grado, seccion)values(?, ?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, aul.getGrado());
			ps.setString(2, aul.getSeccion());
			ps.executeUpdate();
			System.out.println("Aula creada exitosamente");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean edit(Aulas aul) {
		String sql = "UPDATE aulas SET grado = ?, seccion = ? WHERE id = ?";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, aul.getGrado());
			ps.setString(2, aul.getSeccion());
			ps.setInt(3, aul.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("Error al actualizar el aula con ID " + aul.getId() + ": " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(Aulas aul) {
		// TODO Auto-generated method stub
		return false;
	}

}
