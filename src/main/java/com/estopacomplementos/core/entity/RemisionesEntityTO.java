package com.estopacomplementos.core.entity;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.estopacomplementos.core.benas.base.FrecuentesEntityTO;

@Document(collection="Remision")
public class RemisionesEntityTO extends FrecuentesEntityTO{
	
	private String idCliente;
	private String fechaRemision;
	private List<Map<String, String>> productosVendidos;
	private String tipoVenta;
	private String totalNota;
	private String pagos;
	private String folioNota;
	private String telefono;
	private String numPedido;	
	
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
	public String getFolioNota() {
		return folioNota;
	}
	public void setFolioNota(String folioNota) {
		this.folioNota = folioNota;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}

}
