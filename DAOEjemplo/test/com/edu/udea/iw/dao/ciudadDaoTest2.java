package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;

public class ciudadDaoTest2 {

	@Test
	public void testObtenerLong() {
		//Testeo para el metodo sobrecargado obtener(long)
		InterfaceCiudadDao ciudadDao = null; 
		Long id = (long) 1; //variable donde se almacena el codigo de la ciudad
		Ciudad ciudad = null; //objeto donde se guardara la respuesta del query
		try {
			ciudadDao = new ciudadDao(); //se construye el objeto con la implementacion
			ciudad = ciudadDao.obtener(id);
			assertTrue(ciudad!=null); //si se encuentra el dato
		}catch(ExceptionController e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
