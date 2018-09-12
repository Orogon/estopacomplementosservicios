package com.estopacomplementos.core.entity;

import com.estopacomplementos.core.beans.base.ResponseTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class ConsultaClienteResponseTO extends ResponseTO{
	
	private ClienteEntityTO cliente;

	public ClienteEntityTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntityTO cliente) {
		this.cliente = cliente;
	}
	

}
