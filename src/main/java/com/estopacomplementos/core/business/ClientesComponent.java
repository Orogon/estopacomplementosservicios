package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.ClienteRequestTO;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class ClientesComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ClientesComponent.class);
	
	@Autowired
	private GestorClientesDAO clientesDAO;
	
	public void registraCliente(ClienteRequestTO requestTO) {
		log.info("Entra al metodo de registraCliente :::: ClientesComponent");		
		clientesDAO.registraCliente(requestTO);
	}

}
