package com.edu.udea.iw.dao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import com.edu.udea.iw.exception.ExceptionController;

public class DataSource {
	private static DataSource instancia; //para patron singleton
	private SessionFactory factory = null; //manejo de sesiones con hibernate
	private Configuration conf = new Configuration(); //archivo de configuracion hibernate
	private DataSource() {
		
	}
	
	public static DataSource getInstance() { //Patron singleton
		if(instancia==null) {
			instancia = new DataSource();
		}
		return instancia;
	}
	public Session getSession() throws ExceptionController { //metodo para realizar conexion a DB
		try {
			if(factory == null) { //solo se configura la sesion 1 vez
				conf.configure("com/edu/udea/iw/dao/hibernate.cfg.xml"); // se pone la ruta
				factory = conf.buildSessionFactory();
			}
			return factory.openSession(); //se devuelve la sesion abierta
		}catch(HibernateException e){
			throw new ExceptionController("Error configurando la session",e);	
		}
		
	}
}
