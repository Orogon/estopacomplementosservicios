package com.estopacomplementos.core.entity;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.estopacomplementos.core.benas.base.VentaRemisionBeanTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class RemisionesRequestTO {
	
	@NotBlank(message="El nombre de negocio no puede ir vacio.")
	private String nombreNegocio;
	@NotBlank(message="La fecha de remision no puede ir vacia.")
	private String fechaRemision;
	@NotEmpty(message="LA lista de productos vendidos no puede venir vacia.")
	private List<VentaRemisionBeanTO> venta;
	@NotBlank(message="El tipo de venta no puede ir vacio.")
	private String tipoVenta;
	@NotBlank(message="El total de la nota no puede ir vacio.")
	private String totalNota;
	@NotBlank(message="El folio de nota no puede ir vacio.")
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
