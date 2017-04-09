package com.edu.udea.iw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class UsuarioDaoSpring implements InterfaceUsuarioDao{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Usuario> obtener() throws ExceptionController{
		List<Usuario> lista = new ArrayList<Usuario>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class); //retorna la busqueda en la tabla seleccionada
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando usuarios",e);
		}
		return lista;
	}
	public Usuario obtener(String login) throws ExceptionController{
		Usuario usuario = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();//se obtiene la sesion
			//busqueda por clave primaria
			usuario = (Usuario)session.get(Usuario.class,login); //si no existe el codigo retorna null
			System.out.println(usuario.getNombres()+" " +usuario.getRol().getNombre());
			
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando ciudades",e);
		}finally {
			
		}
		return usuario;
	}

}
