package com.edu.udea.iw.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exception.ExceptionController;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class ClienteDaoHibernate implements InterfaceClientesDAO {
	public List<Cliente> obtener() throws ExceptionController{
		List<Cliente> lista = new ArrayList<Cliente>();
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Cliente.class); //retorna la busqueda en la tabla seleccionada
			criteria.addOrder(Order.asc("fechaCreacion")); // ordena la respuesta resultante; es como un where
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando clientes",e);
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return lista;
	}
	public void agregarCliente() throws ExceptionController{
		Session session = null;
		Transaction tx = null; // para abrir transaccion con la base de datos
		Usuario user;
		try {
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Usuario.class); //retorna la busqueda en la tabla seleccionada
			user = (Usuario) criteria.list().get(0);
		}catch(HibernateException e){
			throw new ExceptionController("Error consultando clientes",e);
		}finally {
			if(session!=null) {
				session.close();
			}
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
			session = DataSource.getInstance().getSession();//se obtiene la sesion
			tx = session.beginTransaction();// inicializa la transaccion de la sesion
			//existen los metodos session.delete(), session.update() y session.saveOrUpdate()
			//saveOrUpdate es por si no se sabe si la clave primaria ya existe
			session.saveOrUpdate(cl); //agregar ciudad a la sesion abierta
			tx.commit(); // para hacer persistente la transaccion
		}catch(HibernateException e){
			throw new ExceptionController("Error agregando clientes",e);
		}
		
		
	}
}
