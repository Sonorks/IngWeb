package com.edu.udea.iw.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml")
public class UsuarioBLTest {
	@Autowired
	UsuarioBL usuario = null;
	@Test
	public void test() {
		try {
			usuario.doLogin("sonorks", "password");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
