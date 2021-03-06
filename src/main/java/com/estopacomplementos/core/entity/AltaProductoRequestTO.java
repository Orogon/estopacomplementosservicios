package com.estopacomplementos.core.entity;

/**
 * @author Cesar M Orozco R
 *
 */
public class AltaProductoRequestTO {	
	
	private String codigoProducto;
	private String marcaProducto;
	private String submarcaProducto;
	private String nombreProducto;	
	private String descripcionProducto;	
	private String precioVenta;
	private String precioCompra;
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getMarcaProducto() {
		return marcaProducto;
	}
	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}
	public String getSubmarcaProducto() {
		return submarcaProducto;
	}
	public void setSubmarcaProducto(String submarcaProducto) {
		this.submarcaProducto = submarcaProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public String getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}	
	
}
