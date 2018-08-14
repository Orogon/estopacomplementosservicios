package com.estopacomplementos.core.entity;

import java.util.List;
import java.util.Map;

/**
 * @author Cesar M Orozco R
 *
 */
public class RemisionesRequestTO {
	
	private String nombreCliente;
	private String direccionEntrega;
	private String fechaRemision;
	private List<Map<String, String>> productosVendidos;
	private String tipoVenta;
	private String totalNota;
	private String pagos;
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public String getFechaRemision() {
		return fechaRemision;
	}
	public void setFechaRemision(String fechaRemision) {
		this.fechaRemision = fechaRemision;
	}
	public List<Map<String, String>> getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(List<Map<String, String>> productosVendidos) {
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
	public String getPagos() {
		return pagos;
	}
	public void setPagos(String pagos) {
		this.pagos = pagos;
	}	

}
