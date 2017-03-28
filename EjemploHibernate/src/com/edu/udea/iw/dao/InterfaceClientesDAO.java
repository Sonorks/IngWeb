package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exception.ExceptionController;

public interface InterfaceClientesDAO {
	public List<Cliente> obtener() throws ExceptionController;
	public void agregarCliente() throws ExceptionController;
}
