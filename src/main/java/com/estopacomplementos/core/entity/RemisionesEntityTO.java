package com.estopacomplementos.core.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.estopacomplementos.core.benas.base.VentaRemisionBeanTO;

/**
 * @author Cesar M Orozco R
 *
 */
@Document(collection="Remisiones")
public class RemisionesEntityTO {
	
	@Id
	private String id;
	private String idCliente;	
	private String fechaRemision;
	private List<VentaRemisionBeanTO> productosVendidos;
	private String tipoVenta;
	private String diasCredito;	
	private String folioNota;
	private String ahorro;
	private String totalNotaSinDescuento;
	private String totalNotaConDescuento;
	private Date fechaRegistro;
	private Date fechaModificacion;
	private boolean delete;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getFechaRemision() {
		return fechaRemision;
	}
	public void setFechaRemision(String fechaRemision) {
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
}
