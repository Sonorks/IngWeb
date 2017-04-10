package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Direccion;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public interface InterfaceDireccionDao {
	public List<Direccion> obtener() throws ExceptionController;
}
