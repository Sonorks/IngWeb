package com.edu.udea.iw.dao;
import java.util.List;

import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exception.ExceptionController;
//Interfaz para definir los metodos de la ciudad
// @Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public interface InterfaceCiudadDao {
	//Entrega la lista completa de las ciudades en la BD
	public List<Ciudad> obtener() throws ExceptionController;
	//Entrega una ciudad con un código específico
	public Ciudad obtener(Long codigo) throws ExceptionController;
	//Para agregar ciudad
	public void guardarCiudad(Ciudad ciudad) throws ExceptionController;
}
