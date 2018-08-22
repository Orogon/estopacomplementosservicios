package com.estopacomplementos.core.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.dao.GestorRemisionesDAO;
import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.utils.ValidacionesUtils;

/**
 * @author Cesar M Orozco R
 *
 */
public class RegistraRemisionThread extends Thread{
	
	private static final Logger log = LoggerFactory.getLogger(RegistraRemisionThread.class);
	
	private RemisionesRequestTO requestTO;
	private GestorRemisionesDAO remisionesDAO;
	private GestorClientesDAO clientesDAO;

	public RegistraRemisionThread(RemisionesRequestTO requestTO, GestorRemisionesDAO remisionesDAO,
			GestorClientesDAO clientesDAO) {
		super();
		this.requestTO = requestTO;
		this.remisionesDAO = remisionesDAO;
		this.clientesDAO = clientesDAO;
	}


	@Override
	public void run() {
//		registraRemision(requestTO);
	}
	
	
//	private void registraRemision(RemisionesRequestTO requestTO) {
//		log.info("Entra al metodo de registraRemision :::: RegistraRemisionThread");
//		ClienteEntityTO entityTO = clientesDAO.busquedaPorNombreNegocio(requestTO.getNombreNegocio());
//		if(!ValidacionesUtils.isNullOrEmpty(entityTO)) {
//			log.info("El id del cliente encontrado es: " + entityTO.getId());
//			remisionesDAO.registraNotaCliente(requestTO, entityTO.getId());
//		}else {
//			log.info("Lo Sentimos el cliente no se encontro");
//		}		
//	}
	
	

}
