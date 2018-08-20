package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.dao.GestorRemisionesDAO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.threads.RegistraRemisionThread;

@Component
public class GeneraRemisionesComponent {
	
	private static final Logger log = LoggerFactory.getLogger(GeneraRemisionesComponent.class);
	
	@Autowired
	private ManejadorMensajes manejadorMensajes;
	@Autowired
	private GestorRemisionesDAO remisionesDAO;
	@Autowired
	private GestorClientesDAO clientesDAO;
	
	public ResponseTO realizaRemision(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de realizaRemision ::::: GeneraRemisionesComponent");
		ResponseTO responseTO = new ResponseTO();
		try {
			registraRemisionHilo(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void registraRemisionHilo(RemisionesRequestTO requestTO) {
		try {
			RegistraRemisionThread thread = new RegistraRemisionThread(requestTO, remisionesDAO, clientesDAO);
			thread.start();
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	
	

}
