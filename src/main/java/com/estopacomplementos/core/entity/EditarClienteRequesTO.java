package com.estopacomplementos.core.entity;

import org.hibernate.validator.constraints.NotBlank;

import com.estopacomplementos.core.benas.base.TelefonosBeanTO;

public class EditarClienteRequesTO {
	
	@NotBlank(message="El id del cliente no puede venir vacio.")
	private String idCliente;
	private String nombreResponsable;
	private TelefonosBeanTO telefonos;
	private String correoElectronico;
	private String notaLibre;

	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}
	public TelefonosBeanTO getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(TelefonosBeanTO telefonos) {
		this.telefonos = telefonos;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNotaLibre() {
		return notaLibre;
	}
	public void setNotaLibre(String notaLibre) {
		this.notaLibre = notaLibre;
	}	

}
