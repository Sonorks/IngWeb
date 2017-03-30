package com.edu.udea.iw.dto;

public class Direccion {
	DireccionID id;
	private String direccion;
	private String telefono;
	private int ciudad;
	private boolean preferido;
	public DireccionID getDireccionID() {
		return id;
	}
	public void setDireccionID(DireccionID id) {
		this.id=id;
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
	public boolean isPreferido() {
		return preferido;
	}
	public void setPreferido(boolean preferido) {
		this.preferido = preferido;
	}

}
