package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Direccion;
import com.edu.udea.iw.exception.ExceptionController;

public interface InterfaceDireccionDao {
	public List<Direccion> obtener() throws ExceptionController;
}
