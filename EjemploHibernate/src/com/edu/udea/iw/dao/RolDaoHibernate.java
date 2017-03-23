package com.edu.udea.iw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.exception.ExceptionController;

public class RolDaoHibernate implements InterfaceRolesDao {
	public List<Rol> obtener() throws ExceptionController{
		List<Rol> lista = new ArrayList<Rol>();
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Rol.class); //retorna la busqueda en la tabla seleccionada
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando roles",e);
		}
		return lista;
	}

}
