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

import com.edu.udea.iw.dto.Direccion;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml") //indica donde está el archivo de configuracion de spring
public class DireccionDaoTest {
	@Autowired
	InterfaceDireccionDao DireccionDao;
	final Logger log = Logger.getLogger(RolesDaoTest.class.getName());
	@Test
	public void test() {
		List<Direccion> lista = null;
		try {
			log.info("Iniciando prueba de obtener Direccion de la BD");
			lista = DireccionDao.obtener(); //llamado del metodo
			assertTrue(lista.size()==0);  //no hay direcciones
		}catch(ExceptionController e) {
			e.printStackTrace(); //manda todo el error a consola
			fail(e.getMessage());  //mensaje personalizado
		}
	}

}
