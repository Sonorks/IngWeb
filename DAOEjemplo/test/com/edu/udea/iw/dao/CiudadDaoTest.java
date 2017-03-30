package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class CiudadDaoTest {
	
	@Test
	public void testObtener() {
		//testeo para el  metodo obtener() de la clase ciudadDao
		InterfaceCiudadDao ciudadDao = null;
		List<Ciudad> lista = null; //lista donde se guardará el resultado del query
		
		try {
			ciudadDao = new CiudadDao(); //se construye el objeto con la implementacion de la interfaz
			lista = ciudadDao.obtener(); //llamado del metodo
			assertTrue(lista.size()>0);  //si se obtienen datos
		}catch(ExceptionController e) {
			e.printStackTrace(); //manda todo el error a consola
			fail(e.getMessage());  //mensaje personalizado
		}
	}

}
