package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;

public interface InterfaceUsuarioDao {
	public List<Usuario> obtener() throws ExceptionController;
	public Usuario obtener(String login) throws ExceptionController;
}
