package com.estopacomplementos.core.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.estopacomplementos.core.benas.base.FrecuentesEntityTO;
import com.estopacomplementos.core.benas.base.VentaRemisionBeanTO;

@Document(collection="Remisiones")
public class RemisionesEntityTO extends FrecuentesEntityTO{
	
	private String idCliente;
	private Date fechaRemision;
	private List<VentaRemisionBeanTO> productosVendidos;
	private String tipoVenta;
	private String totalNota;	
	private String folioNota;			
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}	
	public Date getFechaRemision() {
		return fechaRemision;
	}
	public void setFechaRemision(Date fechaRemision) {
		this.fechaRemision = fechaRemision;
	}	
	public List<VentaRemisionBeanTO> getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(List<VentaRemisionBeanTO> productosVendidos) {
		this.productosVendidos = productosVendidos;
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
