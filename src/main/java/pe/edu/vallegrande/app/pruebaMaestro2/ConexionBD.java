package pe.edu.vallegrande.app.pruebaMaestro2;

import java.sql.Connection;

import pe.edu.vallegrande.app.db.AccesoDB;

public class ConexionBD {
	
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión ok.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
