package com.estopacomplementos.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.AltaClienteRequestTO;
import com.estopacomplementos.core.entity.ConsultaClienteRequesTO;
import com.estopacomplementos.core.entity.ConsultaClienteResponseTO;
import com.estopacomplementos.core.entity.ConsultaClientesResponseTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.utils.ValidacionesUtils;

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
	
	private static final Integer TELEFONO_INVALIDO_CELULAR = 2;
	private static final Integer TELEFONO_INVALIDO_LOCAL = 4;
	private static final Integer DIRECCION_VACIA = 3;
	
	public ResponseTO registraCliente(AltaClienteRequestTO requestTO) {
		log.info("Entra al metodo de registraCliente :::: ClientesComponent");
		ResponseTO responseTO = new ResponseTO();		
		try {
			validaTelefonoCelular(requestTO);
			validaTelefonoLocal(requestTO);
			validaDireccionCompleta(requestTO);
			clientesDAO.registraCliente(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		} catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	public ConsultaClientesResponseTO consultaClientes() {
		log.info("Entra al metodo de ConsultaTodosClientesResponseTO :::: ClientesComponent");
		ConsultaClientesResponseTO responseTO = new ConsultaClientesResponseTO();
		try {
			responseTO.setClientes(clientesDAO.consultaClientes());
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	public ConsultaClienteResponseTO consultaCliente(ConsultaClienteRequesTO requesTO) {
		log.info("Entra al metodo de consultaCliente :::: ClientesComponent");
		ConsultaClienteResponseTO responseTO = new ConsultaClienteResponseTO();
		try {
			if(ValidacionesUtils.isNullOrEmpty(requesTO.getNombreEncargado())) {
				log.info("Entra a realizar la consulta por nombre de encargado");
				responseTO.setCliente(clientesDAO.busquedaPorNombreEncargado(requesTO.getNombreEncargado()));
			}else {
				log.info("Entra a realizar la consulta por nombre de negocio");
				responseTO.setCliente(clientesDAO.busquedaPorNombreNegocio(requesTO.getNombreNegocio()));
			}
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void validaTelefonoCelular(AltaClienteRequestTO requestTO) {
		if(requestTO.getTelefonos().getNumCelular().length() > 10 || 
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumCelular())) {
			log.info("El numero que se encuentra invalido es el celular");
			throw new MensajeExcepcion(TELEFONO_INVALIDO_CELULAR);
		}
	}
	
	private void validaTelefonoLocal(AltaClienteRequestTO requestTO) {
		if(requestTO.getTelefonos().getNumCasa().length() > 10 || 
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumCasa())) {
			log.info("El numero que se encuentra invalido es el local");
			throw new MensajeExcepcion(TELEFONO_INVALIDO_LOCAL);
		}
	}
	
	private void validaDireccionCompleta(AltaClienteRequestTO requestTO) {
		if(ValidacionesUtils.isNullOrEmpty(requestTO.getDireccion())) {
			throw new MensajeExcepcion(DIRECCION_VACIA);
		}
	}

}
