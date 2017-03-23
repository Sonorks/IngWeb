package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;

public interface InterfaceRolesDao {
	public List<Rol> obtener() throws ExceptionController;
}
