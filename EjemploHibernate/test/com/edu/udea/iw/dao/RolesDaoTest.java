package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;

public class RolesDaoTest {
	@Test
	public void testObtener() {
	InterfaceRolesDao RolesDao = null;
	List<Rol> lista = null;
	try {
		RolesDao = new RolDaoHibernate(); //se construye el objeto con la implementacion de la interfaz
		lista = RolesDao.obtener(); //llamado del metodo
		assertTrue(lista.size()>0);  //si se obtienen datos
	}catch(ExceptionController e) {
		e.printStackTrace(); //manda todo el error a consola
		fail(e.getMessage());  //mensaje personalizado
	}
}
}



