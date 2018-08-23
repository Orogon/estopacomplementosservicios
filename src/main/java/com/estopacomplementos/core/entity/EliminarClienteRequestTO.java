package com.estopacomplementos.core.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Cesar M orozco R
 *
 */
public class EliminarClienteRequestTO {
	
	@NotBlank(message="Lo sentimos el idCliente no puede venir vacio.")
	private String idCliente;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}	

}
