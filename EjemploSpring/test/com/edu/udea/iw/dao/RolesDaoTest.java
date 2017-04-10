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

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml") //indica donde está el archivo de configuracion de spring
public class RolesDaoTest {
	@Autowired
	InterfaceRolesDao RolesDao;
	@Test
	public void testObtener() {
	final Logger log = Logger.getLogger(RolesDaoTest.class.getName());
	List<Rol> lista = null;
	try {
		log.info("Iniciando prueba de obtener Roles de la BD");
		lista = RolesDao.obtener(); //llamado del metodo
		if(lista.size()>0) {  //si se obtienen datos
		log.info("Prueba pasada satisfactoriamente");
		}
		assertTrue(lista.size()>0);
	}catch(ExceptionController e) {
		e.printStackTrace(); //manda todo el error a consola
		fail(e.getMessage());  //mensaje personalizado
	}
}
}



