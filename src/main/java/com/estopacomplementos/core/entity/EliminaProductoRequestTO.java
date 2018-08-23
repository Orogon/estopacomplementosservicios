package com.estopacomplementos.core.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Cesar M Orozco R
 *
 */
public class EliminaProductoRequestTO {
	
	@NotBlank(message="El id del producto no puede venir vacio")
	private String idProducto;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

}
