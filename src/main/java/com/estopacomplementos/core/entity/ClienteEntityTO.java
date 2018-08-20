package com.estopacomplementos.core.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.estopacomplementos.core.benas.base.DireccionBeanTO;
import com.estopacomplementos.core.benas.base.FrecuentesEntityTO;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;

@Document(collection="Clientes")
public class ClienteEntityTO extends FrecuentesEntityTO{
	
	private String nombreResponsable;	
	private String apePatResponsable;	
	private String apeMatResponsable;	
	private String nombreNegocio;
	private TelefonosBeanTO telefonos;	
	private DireccionBeanTO direccion;	
	private String rfc;	
	private String correoElectronico;
	private String notaLibre;
	
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}
	public String getApePatResponsable() {
		return apePatResponsable;
	}
	public void setApePatResponsable(String apePatResponsable) {
		this.apePatResponsable = apePatResponsable;
	}
	public String getApeMatResponsable() {
		return apeMatResponsable;
	}
	public void setApeMatResponsable(String apeMatResponsable) {
		this.apeMatResponsable = apeMatResponsable;
	}
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	public TelefonosBeanTO getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(TelefonosBeanTO telefonos) {
		this.telefonos = telefonos;
	}
	public DireccionBeanTO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionBeanTO direccion) {
		this.direccion = direccion;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
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
