package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.ClienteRequestTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class ClientesComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ClientesComponent.class);
	
	@Autowired
	private GestorClientesDAO clientesDAO;
	@Autowired
	private ManejadorMensajes manejadorMensajes;
	
	private static final Integer TELEFONO_INVALIDO = 2;
	
	public ResponseTO registraCliente(ClienteRequestTO requestTO) {
		log.info("Entra al metodo de registraCliente :::: ClientesComponent");
		ResponseTO responseTO = new ResponseTO();		
		try {
			validaTelefonoCelular(requestTO);
//			clientesDAO.registraCliente(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		} catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void validaTelefonoCelular(ClienteRequestTO requestTO) {
		if(requestTO.getTelefonos().getNumCelular().length() > 10) {
			throw new MensajeExcepcion(TELEFONO_INVALIDO);
		}
	}

}
