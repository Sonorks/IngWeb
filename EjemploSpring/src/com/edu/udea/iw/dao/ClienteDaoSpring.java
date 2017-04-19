package com.edu.udea.iw.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public class ClienteDaoSpring implements InterfaceClientesDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Cliente> obtener() throws ExceptionController{
		List<Cliente> lista = new ArrayList<Cliente>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Cliente.class); //retorna la busqueda en la tabla seleccionada
			criteria.addOrder(Order.asc("fechaCreacion")); // ordena la respuesta resultante; es como un where
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando clientes",e);
		}finally {
		
		}
		return lista;
	}
	public void agregarCliente() throws ExceptionController{
		Session session = null;
		Usuario user;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class); //retorna la busqueda en la tabla seleccionada
			user = (Usuario) criteria.list().get(0);
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando clientes",e);
		}finally {
		
		}
		Cliente cl = new Cliente();
		cl.setCedula("1035436986");
		cl.setApellidos("Vasquez Giraldo");
		cl.setNombres("Julian");
		cl.setEmail("julian.vasquezg@udea.edu.co");
		cl.setUsuarioCrea(user);
		cl.setUsuarioElimina(user);
		cl.setUsuarioModifica(user);
		cl.setFechaCreacion(new Date());
		try {
			session = sessionFactory.getCurrentSession();//se obtiene la sesion
			session.saveOrUpdate(cl); //agregar cliente a la sesion abierta
		}catch(HibernateException e){
			throw new ExceptionController("Error agregando clientes",e);
		}
		
		
	}
	public void guardarCliente(Cliente cliente) throws ExceptionController {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cliente); //retorna la busqueda en la tabla seleccionada
			//user = (Usuario) criteria.list().get(0);
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando clientes",e);
		}
	}
}
