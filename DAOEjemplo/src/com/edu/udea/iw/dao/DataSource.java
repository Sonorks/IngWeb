package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.edu.udea.iw.exception.ExceptionController;

public class DataSource { //Clase para obtener la conexión a la base de datos
	public static Connection getConnection() throws ExceptionController {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudades","root","root");
		}catch(ClassNotFoundException e) {
			throw new ExceptionController("Driver no encontrado", e);
		}catch(SQLException e) {
			throw new ExceptionController("No se puede establecer conexion", e);
		}
		return conn; 
	}
}
