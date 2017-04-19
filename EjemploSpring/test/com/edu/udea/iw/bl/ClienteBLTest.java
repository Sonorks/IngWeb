package com.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.iw.dao.ClienteDaoSpring;
import com.edu.udea.iw.dto.Cliente;
@RunWith(SpringJUnit4ClassRunner.class) //para correr un test con tipo de prueba Spring
@Transactional //indica que se hacen transacciones con la BD
@ContextConfiguration(locations="classpath:SpringBeanDefinition.xml")
public class ClienteBLTest {
	@Autowired
	ClienteBL cliente = null;
	@Test
	public void test() {
		List <Cliente> lista = null;
		try {
			//ClienteDaoSpring.agregarCliente();
			lista = cliente.obtener();
			assertTrue(lista.size()>0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
