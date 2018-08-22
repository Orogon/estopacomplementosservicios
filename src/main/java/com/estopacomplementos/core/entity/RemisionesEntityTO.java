package com.estopacomplementos.core.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
	private String nombreNegocio;
	private String direccionNegocio;
	private String coloniaCliente;
	private String estadoCLiente;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaRemision;
	private List<VentaRemisionBeanTO> productosVendidos;
	private String tipoVenta;
	private String totalNotaConDescuento;
	private String totalNotaSinDescuento;
	private String folioNota;
	private String totalAhorro;
	private Date fechaRegistro;
		
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
	public String getTotalNotaConDescuento() {
		return totalNotaConDescuento;
	}
	public void setTotalNotaConDescuento(String totalNotaConDescuento) {
		this.totalNotaConDescuento = totalNotaConDescuento;
	}
	public String getTotalNotaSinDescuento() {
		return totalNotaSinDescuento;
	}
	public void setTotalNotaSinDescuento(String totalNotaSinDescuento) {
		this.totalNotaSinDescuento = totalNotaSinDescuento;
	}
	public String getFolioNota() {
		return folioNota;
	}
	public void setFolioNota(String folioNota) {
		this.folioNota = folioNota;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getTotalAhorro() {
		return totalAhorro;
	}
	public void setTotalAhorro(String totalAhorro) {
		this.totalAhorro = totalAhorro;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	public String getDireccionNegocio() {
		return direccionNegocio;
	}
	public void setDireccionNegocio(String direccionNegocio) {
		this.direccionNegocio = direccionNegocio;
	}
	public String getColoniaCliente() {
		return coloniaCliente;
	}
	public void setColoniaCliente(String coloniaCliente) {
		this.coloniaCliente = coloniaCliente;
	}
	public String getEstadoCLiente() {
		return estadoCLiente;
	}
	public void setEstadoCLiente(String estadoCLiente) {
		this.estadoCLiente = estadoCLiente;
	}
	
}
