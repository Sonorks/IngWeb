package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class UsuarioDaoTest {

	@Test
	public void testObtener() {
		InterfaceUsuarioDao usuarioDao = null; 
		String login2="elver";; //variable donde se almacena el codigo de la ciudad
		Usuario usuario = null; //objeto donde se guardara la respuesta del query
		try {
			usuarioDao = new UsuarioDaoHibernate(); //se construye el objeto con la implementacion
			usuario = usuarioDao.obtener(login2);
			assertTrue(usuario!=null); //si se encuentra el dato
		}catch(ExceptionController e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
