package com.estopacomplementos.core.business;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.entity.ClienteRequestTO;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class ClientesComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ClientesComponent.class);
	
	public void registraCliente(ClienteRequestTO requestTO, HttpSession session) {
		log.info("Entra al metodo de registraCliente :::: ClientesComponent");
		
	}

}
