package com.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dao.ClienteDaoSpring;
import com.edu.udea.iw.dao.UsuarioDaoSpring;
import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;

public class ClienteBL {
	private ClienteDaoSpring clienteDao;
	private UsuarioDaoSpring usuarioDao;
	public UsuarioDaoSpring getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoSpring usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ClienteDaoSpring getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDaoSpring clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public List<Cliente> obtener() throws ExceptionController{
		return clienteDao.obtener();
	}
	public void guardarCliente(String cedula, String nombre, String apellido, String email, String usuarioCrea) throws ExceptionController {
		if(cedula.isEmpty() || cedula == null) {
			throw new ExceptionController("La cedula no puede estar vacia"); //validar lo mismo con todos los datos
		}
		if(nombre.isEmpty() || nombre == null) {
			throw new ExceptionController("El nombre no puede estar vacio");
		}
		if(apellido.isEmpty() || apellido == null) {
			throw new ExceptionController("El apellido no puede estar vacio");
		}
		if(email.isEmpty() || email == null) {
			throw new ExceptionController("El email no puede estar vacio");
		}
		if(usuarioCrea.isEmpty() || usuarioCrea == null) {
			throw new ExceptionController("El usuarioCrea no puede estar vacio");
		}
		//validar que el correo electronico tenga el formato adecuado
		//validar que el cliente a crear ya no exista
		//validar que el usuarioCrea si exista
		Usuario usuario = usuarioDao.obtener(usuarioCrea);
		if (usuario == null) {
			throw new ExceptionController("UsuarioCrea no existe en el sistema");
		}
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setApellidos(apellido);
		cliente.setNombres(nombre);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDao.guardarCliente(cliente);
	}
}
