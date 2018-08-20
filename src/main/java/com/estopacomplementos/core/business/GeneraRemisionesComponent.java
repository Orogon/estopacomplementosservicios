package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.dao.GestorRemisionesDAO;
import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.threads.RegistraRemisionThread;
import com.estopacomplementos.core.utils.ValidacionesUtils;

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
			registraRemision(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void registraRemision(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de registraRemision :::: RegistraRemisionThread");
		ClienteEntityTO entityTO = clientesDAO.busquedaPorNombreNegocio(requestTO.getNombreNegocio());
		if(!ValidacionesUtils.isNullOrEmpty(entityTO)) {
			log.info("El id del cliente encontrado es: " + entityTO.getId());
			remisionesDAO.registraNotaCliente(requestTO, entityTO);
		}else {
			log.info("Lo Sentimos el cliente no se encontro");
		}		
	}
	
	

}
