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

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml") //indica donde está el archivo de configuracion de spring
public class ClienteDaoTest {
	@Autowired
	InterfaceClientesDao clienteDao;
	final Logger log = Logger.getLogger(RolesDaoTest.class.getName());
	@Test
	public void testAgregarCliente() { // modificado para agregar cliente
		List<Cliente> lista = null; //lista donde se guardará el resultado del query
		
		try {
			log.info("Iniciando prueba de agregar clientes a la BD");
			clienteDao.agregarCliente(); //llamado del metodo quemado en la clase por temas de facilidad a la hora de estudiar el framework
			lista=clienteDao.obtener();
			assertTrue(lista.size()>0);
		}catch(ExceptionController e) {
			e.printStackTrace(); //manda todo el error a consola
			fail(e.getMessage());  //mensaje personalizado
		}
	}

}
