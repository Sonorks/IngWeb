package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
//Clase para implementar la interface de CiudadDao para obtener la lista de datos de la BD
public class CiudadDaoSpring implements InterfaceCiudadDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Ciudad> obtener() throws ExceptionController{
			List<Ciudad> lista = new ArrayList<Ciudad>();
			Session session = null;
			try {
				session = sessionFactory.getCurrentSession(); //para conectarse con el BEAN definido en SpringConf.xml
				Criteria criteria = session.createCriteria(Ciudad.class); //retorna la busqueda en la tabla seleccionada
				lista = criteria.list();
			}catch(HibernateException e){
				throw new ExceptionController("Error consultando ciudades",e);
			}
			return lista;
		}
	public Ciudad obtener (Long codigo) throws ExceptionController{
			List<Ciudad> lista = new ArrayList<Ciudad>();
			Ciudad ciudad = null;
			Session session = null;
			try {
				session = sessionFactory.getCurrentSession();//se obtiene la sesion
				//busqueda por clave primaria
				ciudad = (Ciudad)session.get(Ciudad.class,codigo); //si no existe el codigo retorna null
				//existe el metodo session.load(Ciudad.class,codigo) que retorna excepcions si no existe.
				/*//otra manera de hacerlo
				 *Criteria criteria = session.createCriteria(Ciudad.class); // se obtiene la criteria para sesion
				criteria.add(Restrictions.eq("codigo", codigo)); //agrega a la criteria con la condicion
				ciudad = (Ciudad)criteria.uniqueResult(); //devuelve un unico valor por busqueda con PK
				*/
				
				/*lista = criteria.list(); //la que yo hice de primerazo
				for(int i = 0 ; i<lista.size(); i++) {
					ciudad = lista.get(i);
					if (ciudad.getCodigo() == codigo) {
						return ciudad;
					}
				}*/
			}catch(HibernateException e){
				throw new ExceptionController("Error consultando ciudades",e);
			}
			return ciudad;
	}
	public void guardarCiudad(Ciudad ciudad) throws ExceptionController {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();//se obtiene la sesion
			session.save(ciudad); //agregar ciudad a la sesion abierta
		}catch(HibernateException e){
			throw new ExceptionController("Error agregando ciudades",e);
		}
	}
			
	}

