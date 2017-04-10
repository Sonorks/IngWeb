package com.edu.udea.iw.dto;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public class Usuario {
	private String Login;
	private String Nombres;
	private String Apellidos;
	private String Contrasena;
	private Rol Rol;
	
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public Rol getRol() {
		return Rol;
	}
	public void setRol(Rol rol) {
		Rol = rol;
	}

}
