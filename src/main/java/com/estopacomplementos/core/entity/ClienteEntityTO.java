package com.estopacomplementos.core.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.estopacomplementos.core.benas.base.DireccionBeanTO;
import com.estopacomplementos.core.benas.base.FrecuentesEntityTO;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;

@Document(collection="Clientes")
public class ClienteEntityTO extends FrecuentesEntityTO{
	
	private String nombreResponsable;
	private String nombreNegocio;
	private TelefonosBeanTO telefonos;
	private DireccionBeanTO direccion;
	private String tipoVenta;
	private String creditoDias;
	private String rfc;
	private String ventaGlobal;
	private String correoElectronico;
	private String notaLibre;	
	
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
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
	public String getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	public String getCreditoDias() {
		return creditoDias;
	}
	public void setCreditoDias(String creditoDias) {
		this.creditoDias = creditoDias;
	}	
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getVentaGlobal() {
		return ventaGlobal;
	}
	public void setVentaGlobal(String ventaGlobal) {
		this.ventaGlobal = ventaGlobal;
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
