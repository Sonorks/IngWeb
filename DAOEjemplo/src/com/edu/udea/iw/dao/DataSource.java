package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class DataSource { //Clase para obtener la conexión a la base de datos
	private static Connection con;
	private DataSource() {
		System.out.println("DataSource creado");
	}
	private static Connection getConnect() throws ExceptionController { //para singleton: 1 sola conexion
		Connection conn = null;//variable para generar la conexion a la BD
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudades","root","root");
		}catch(ClassNotFoundException e) {
			throw new ExceptionController("Driver no encontrado", e);
		}catch(SQLException e) {
			throw new ExceptionController("No se puede establecer conexion", e);
		}
		return conn; //retorna conexion unica
	}
	
	public static Connection getConnection() throws ExceptionController {
		if (con == null) { // si no se ha creado la conexion unica se crea y se asigna
				con = getConnect();
			}
		return con; //devuelve la instancia unica de conexion
		}
			 
}

