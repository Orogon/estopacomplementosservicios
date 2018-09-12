package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.beans.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.dao.GestorRemisionesDAO;
import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.utils.ValidacionesUtils;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class GeneraRemisionesComponent {
	
	private static final Logger log = LoggerFactory.getLogger(GeneraRemisionesComponent.class);
	
	private static final Integer CLIENTE_NO_REGISTRADO = 5;
	
	@Autowired
	private ManejadorMensajes manejadorMensajes;
	@Autowired
	private GestorRemisionesDAO remisionesDAO;
	@Autowired
	private GestorClientesDAO clientesDAO;
	@Autowired
	private CrearRemisionComponent remisionUtils;
	
	/**
	 * @param requestTO
	 * @return
	 */
	public ResponseTO realizaRemision(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de realizaRemision ::::: GeneraRemisionesComponent");
		ResponseTO responseTO = new ResponseTO();
		try {
			remisionUtils.creaRemisionConDatos(requestTO);
			registraRemision(requestTO);									
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void registraRemision(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de registraRemision :::: GeneraRemisionesComponent");		
		ClienteEntityTO entityTO = clientesDAO.busquedaPorNombreNegocio(requestTO.getNombreNegocio());
		if(!ValidacionesUtils.isNullOrEmpty(entityTO))
			remisionesDAO.registraNotaCliente(requestTO, entityTO.getId());
		else
			log.info("El cliente no se encuentra registrado.");		
	}	

}
