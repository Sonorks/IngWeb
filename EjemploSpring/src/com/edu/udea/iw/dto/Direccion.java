package com.edu.udea.iw.dto;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public class Direccion {
	DireccionID id;
	private String direccion;
	private String telefono;
	private int ciudad;
	private boolean preferida;
	
	public DireccionID getId() {
		return id;
	}
	public void setId(DireccionID id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getCiudad() {
		return ciudad;
	}
	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isPreferida() {
		return preferida;
	}
	public void setPreferida(boolean preferido) {
		this.preferida = preferido;
	}

}
