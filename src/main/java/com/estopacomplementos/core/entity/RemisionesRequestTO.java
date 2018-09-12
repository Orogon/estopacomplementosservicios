package com.estopacomplementos.core.entity;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.estopacomplementos.core.beans.base.VentaRemisionBeanTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class RemisionesRequestTO {
	
	@NotBlank(message="El nombre de negocio no puede ir vacio.")
	private String nombreNegocio;
	@NotBlank(message="La fecha de remision no puede ir vacia.")
	private String fechaRemision;
	@NotEmpty(message="La lista de productos vendidos no puede venir vacia.")
	private List<VentaRemisionBeanTO> venta;
	@NotBlank(message="El tipo de venta no puede ir vacio.")
	private String tipoVenta;
	@NotBlank(message="El campo de dias de credito no puede venir vacio")
	private String diasCredito;
	@NotBlank(message="El folio de nota no puede ir vacio.")
	private String folioNota;
	
	private String direccionNegocio;
	private String coloniaNegocio;
	private String estadoNegocio;
	private String telefonoNegocio;
	
	private String ahorro;
	private String totalNotaSinDescuento;
	private String totalNotaConDescuento;
	
	private String totalNotaGlobal;
	
	
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	public String getFechaRemision() {
		return fechaRemision;
	}
	public void setFechaRemision(String fechaRemision) {
		this.fechaRemision = fechaRemision;
	}
	public List<VentaRemisionBeanTO> getVenta() {
		return venta;
	}
	public void setVenta(List<VentaRemisionBeanTO> venta) {
		this.venta = venta;
	}
	public String getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	public String getDiasCredito() {
		return diasCredito;
	}
	public void setDiasCredito(String diasCredito) {
		this.diasCredito = diasCredito;
	}
	public String getFolioNota() {
		return folioNota;
	}
	public void setFolioNota(String folioNota) {
		this.folioNota = folioNota;
	}
	public String getDireccionNegocio() {
		return direccionNegocio;
	}
	public void setDireccionNegocio(String direccionNegocio) {
		this.direccionNegocio = direccionNegocio;
	}
	public String getColoniaNegocio() {
		return coloniaNegocio;
	}
	public void setColoniaNegocio(String coloniaNegocio) {
		this.coloniaNegocio = coloniaNegocio;
	}
	public String getEstadoNegocio() {
		return estadoNegocio;
	}
	public void setEstadoNegocio(String estadoNegocio) {
		this.estadoNegocio = estadoNegocio;
	}
	public String getAhorro() {
		return ahorro;
	}
	public void setAhorro(String ahorro) {
		this.ahorro = ahorro;
	}
	public String getTotalNotaSinDescuento() {
		return totalNotaSinDescuento;
	}
	public void setTotalNotaSinDescuento(String totalNotaSinDescuento) {
		this.totalNotaSinDescuento = totalNotaSinDescuento;
	}
	public String getTotalNotaConDescuento() {
		return totalNotaConDescuento;
	}
	public void setTotalNotaConDescuento(String totalNotaConDescuento) {
		this.totalNotaConDescuento = totalNotaConDescuento;
	}
	public String getTelefonoNegocio() {
		return telefonoNegocio;
	}
	public void setTelefonoNegocio(String telefonoNegocio) {
		this.telefonoNegocio = telefonoNegocio;
	}
	public String getTotalNotaGlobal() {
		return totalNotaGlobal;
	}
	public void setTotalNotaGlobal(String totalNotaGlobal) {
		this.totalNotaGlobal = totalNotaGlobal;
	}	
	
}
