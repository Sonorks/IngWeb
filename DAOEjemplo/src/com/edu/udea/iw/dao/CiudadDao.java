package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
//Clase para implementar la interface de CiudadDao para obtener la lista de datos de la BD
public class CiudadDao implements InterfaceCiudadDao {
	public List<Ciudad> obtener() throws ExceptionController{
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try {
			//llama la conexion por medio del dto
			con = DataSource.getConnection(); 
			ps = con.prepareStatement("Select * From ciudades");
			rs = ps.executeQuery();
			while(rs.next()) { // para cada ciudad agrega respuesta a la lista
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
						
			}
		}catch (ExceptionController e) {
			throw new ExceptionController("Exception en el DAO",e);
		}catch (SQLException e) {
			throw new ExceptionController("No se puede establecer la conexion",e);
		}finally {
			try { //cerrar canales de conexion
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				throw new ExceptionController("Error cerrando",e);
			}
		}
		return lista;
	}
	public Ciudad obtener(Long codigo) throws ExceptionController{
		Ciudad ciudad = null;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			con = DataSource.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo=?");
			ps.setLong(1, codigo); //se usa para evitar SQL Injection
			rs= ps.executeQuery();
			if(rs.next()) {
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		}catch(SQLException e){
			System.out.println("No se pudo realizar la conexion");
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ciudad;
		}
			
	}

