package com.estopacomplementos.core.entity;

import java.util.List;

import com.estopacomplementos.core.benas.base.VentaRemisionBeanTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class RemisionesRequestTO {
	
	private String nombreNegocio;
	private String fechaRemision;
	private List<VentaRemisionBeanTO> venta;
	private String tipoVenta;
	private String totalNota;
	private String folioNota;
	
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
	public String getTotalNota() {
		return totalNota;
	}
	public void setTotalNota(String totalNota) {
		this.totalNota = totalNota;
	}
	public String getFolioNota() {
		return folioNota;
	}
	public void setFolioNota(String folioNota) {
		this.folioNota = folioNota;
	}
	
}
