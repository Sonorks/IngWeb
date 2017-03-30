package com.edu.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class ClienteDaoTest {

	@Test
	public void testAgregarCliente() { // modificado para agregar cliente
		InterfaceClientesDAO clienteDao = null;
		List<Cliente> lista = null; //lista donde se guardará el resultado del query
		
		try {
			clienteDao = new ClienteDaoHibernate(); //se construye el objeto con la implementacion de la interfaz
			clienteDao.agregarCliente(); //llamado del metodo
		}catch(ExceptionController e) {
			e.printStackTrace(); //manda todo el error a consola
			fail(e.getMessage());  //mensaje personalizado
		}
	}

}
