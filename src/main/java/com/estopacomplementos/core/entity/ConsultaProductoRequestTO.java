package com.estopacomplementos.core.entity;

/**
 * @author Cesar M Orozco R
 *
 */
public class ConsultaProductoRequestTO {
	
	private String codigoProducto;
	private String nombreProducto;
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}	

}
