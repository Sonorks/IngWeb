package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */  
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml") //indica donde está el archivo de configuracion de spring
public class CiudadDaoTest {
	@Autowired
	InterfaceCiudadDao ciudadDao;
	final Logger log = Logger.getLogger(RolesDaoTest.class.getName());
	@Test
	public void testObtener() {
		log.info("Iniciando prueba de obtener Ciudades de la BD");
		//testeo para el  metodo obtener() de la clase ciudadDao
		//InterfaceCiudadDao ciudadDao = null;
		List<Ciudad> lista = null; //lista donde se guardará el resultado del query
		Ciudad ciudad = null; //Donde se guardara una ciudad en especifico para el segundo método
		try {
			//ciudadDao = new CiudadDaoSpring(); //se construye el objeto con la implementacion de la interfaz
			lista = ciudadDao.obtener(); //llamado del metodo
			assertTrue(lista.size()>0);  //si se obtienen datos
			Long codigo = Long.valueOf(2);
			ciudad = ciudadDao.obtener(codigo);
			System.out.println(ciudad.toString());
		}catch(ExceptionController e) {
			e.printStackTrace(); //manda todo el error a consola
			fail(e.getMessage());  //mensaje personalizado
		}
	}

}
