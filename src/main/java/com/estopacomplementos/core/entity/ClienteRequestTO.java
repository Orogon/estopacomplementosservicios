package com.estopacomplementos.core.entity;

import com.estopacomplementos.core.benas.base.DireccionBeanTO;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;

public class ClienteRequestTO {
	
	private String nombreResponsable;
	private String nombreNegocio;
	private TelefonosBeanTO telefonos;
	private DireccionBeanTO direccion;
	private String tipoVenta;
	private String creditoDias;
	private String condiciones;
	private String ventaGlobal;
	private String adeudos;
	private String correoElectronico;
	private String notaLibre;
	private boolean factura;
	
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
	public String getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public String getVentaGlobal() {
		return ventaGlobal;
	}
	public void setVentaGlobal(String ventaGlobal) {
		this.ventaGlobal = ventaGlobal;
	}
	public String getAdeudos() {
		return adeudos;
	}
	public void setAdeudos(String adeudos) {
		this.adeudos = adeudos;
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
	public boolean isFactura() {
		return factura;
	}
	public void setFactura(boolean factura) {
		this.factura = factura;
	}
	
}
