package com.estopacomplementos.core.entity;

import java.util.List;

import com.estopacomplementos.core.beans.base.ResponseTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class ConsultaProductosResponseTO extends ResponseTO{
	
	private List<ProductosEntityTO> productos;

	public List<ProductosEntityTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosEntityTO> productos) {
		this.productos = productos;
	}	

}
