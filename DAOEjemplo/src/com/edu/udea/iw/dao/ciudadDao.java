package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;

//Clase para implementar la interface de CiudadDao para obtener la lista de datos de la BD
public class ciudadDao implements InterfaceCiudadDao {
	public List<Ciudad> obtener() throws ExceptionController{
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try {
			//llama la conexion por medio del dto
			con = DataSource.getConnection(); 
			ps = con.prepareStatement("Select * From Ciudades");
			rs = ps.executeQuery();
			while(rs.next()) {
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
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				throw new ExceptionController("Error cerrando",e);
			}
		}
		return lista;
	}
}
