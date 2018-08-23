package com.estopacomplementos.core.entity;

import com.estopacomplementos.core.benas.base.ResponseTO;

public class ConsultaProductoResponseTO extends ResponseTO{
	
	private ProductosEntityTO producto;

	public ProductosEntityTO getProducto() {
		return producto;
	}

	public void setProducto(ProductosEntityTO producto) {
		this.producto = producto;
	}	

}
