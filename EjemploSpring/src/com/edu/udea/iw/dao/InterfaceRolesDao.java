package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public interface InterfaceRolesDao {
	public List<Rol> obtener() throws ExceptionController;
}
