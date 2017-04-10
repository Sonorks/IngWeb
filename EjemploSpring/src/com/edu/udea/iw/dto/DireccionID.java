package com.edu.udea.iw.dto;

import java.io.Serializable;
/**
 * @Author Julian Vasquez - julivas96@gmail.com 
 * @Version = 1.0 
 * */
public class DireccionID implements Serializable{
	private Long codigo;
	private Cliente cliente;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
