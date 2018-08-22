package com.estopacomplementos.core.entity;

import java.util.List;

import com.estopacomplementos.core.benas.base.ResponseTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class ConsultaClientesResponseTO extends ResponseTO{
	
	private List<ClienteEntityTO> clientes;

	public List<ClienteEntityTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntityTO> clientes) {
		this.clientes = clientes;
	}
	

}
