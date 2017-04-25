package com.edu.udea.iw.bl;

import com.edu.udea.iw.dao.UsuarioDaoSpring;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public class UsuarioBL {
	private UsuarioDaoSpring usuarioDao;
	//Objeto de tipo UsuarioDao para la conección a la BD
	public UsuarioDaoSpring getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoSpring usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public void doLogin(String user, String password) throws ExceptionController {
		if(user.isEmpty() || user != null) { //validando que se reciba un usuario
			throw new ExceptionController("El usuario no puede estar vacía");
		}
		if(password.isEmpty() || password != null) { //validando que se reciba una contraseña
			throw new ExceptionController("La contraseña no puede estar vacía");
		}
		Usuario usuario = usuarioDao.obtener(user); //se obtiene el usuario por medio del obtener(login)
		if(usuario == null) {
			throw new ExceptionController("Usuario o contraseña incorrecta");
		}
		if(!usuario.getContrasena().equals(password)) {
			throw new ExceptionController("Credenciales incorrectas");
		}
		
		
	}
}
