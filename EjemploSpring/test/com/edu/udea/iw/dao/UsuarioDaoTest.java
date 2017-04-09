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
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml") //indica donde está el archivo de configuracion de spring
public class UsuarioDaoTest {
	@Autowired
	InterfaceUsuarioDao usuarioDao;
	final Logger log = Logger.getLogger(RolesDaoTest.class.getName());
	@Test
	public void testObtener() {
		String login2="elver";; //variable donde se almacena el codigo de la ciudad
		Usuario usuario = null; //objeto donde se guardara la respuesta del query
		List<Usuario> lista = null; //lista para el primer metodo de UsuarioDaoSpring
		try {
			log.info("Iniciando prueba de obtener  usuarios de la BD");
			usuario = usuarioDao.obtener(login2);
			lista = usuarioDao.obtener();
			assertTrue(usuario!=null && lista.size()>0); //si se encuentra el dato
		}catch(ExceptionController e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
