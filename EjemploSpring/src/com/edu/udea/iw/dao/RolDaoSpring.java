package com.edu.udea.iw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class RolDaoSpring implements InterfaceRolesDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Rol> obtener() throws ExceptionController{
		List<Rol> lista = new ArrayList<Rol>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Rol.class); //retorna la busqueda en la tabla seleccionada
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando roles",e);
		}
		return lista;
	}

}
