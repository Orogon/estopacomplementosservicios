package com.estopacomplementos.core.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.beans.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.AltaClienteRequestTO;
import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.ConsultaClienteRequesTO;
import com.estopacomplementos.core.entity.ConsultaClienteResponseTO;
import com.estopacomplementos.core.entity.ConsultaClientesResponseTO;
import com.estopacomplementos.core.entity.EditarClienteRequesTO;
import com.estopacomplementos.core.entity.EliminarClienteRequestTO;
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
	private static final Integer LISTA_CLIENTES_VACIA = 10;
	
	/**
	 * @param requestTO
	 * @return
	 */
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
	
	/**
	 * @return
	 */
	public ConsultaClientesResponseTO consultaClientes() {
		log.info("Entra al metodo de ConsultaTodosClientesResponseTO :::: ClientesComponent");
		ConsultaClientesResponseTO responseTO = new ConsultaClientesResponseTO();
		try {
			List<ClienteEntityTO> listaClientes = clientesDAO.consultaClientes();
			validaListaClientes(listaClientes);
			responseTO.setClientes(listaClientes);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	/**
	 * @param requesTO
	 * @return
	 */
	public ConsultaClienteResponseTO consultaCliente(ConsultaClienteRequesTO requesTO) {
		log.info("Entra al metodo de consultaCliente :::: ClientesComponent");
		ConsultaClienteResponseTO responseTO = new ConsultaClienteResponseTO();
		try {
			if(!ValidacionesUtils.isNullOrEmpty(requesTO.getNombreEncargado())) {
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
	
	/**
	 * @param requesTO
	 * @return
	 */
	public ResponseTO editarCliente(EditarClienteRequesTO requesTO) {
		log.info("Entra al metodo de editarCliente :::: ClientesComponent");
		ResponseTO responseTO = new ResponseTO();
		try {
			clientesDAO.editarCliente(requesTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	/**
	 * @param requestTO
	 * @return
	 */
	public ResponseTO eliminarCliente(EliminarClienteRequestTO requestTO) {
		log.info("Entra al metodo de eliminarCliente :::: ClientesComponent");
		ResponseTO responseTO = new ResponseTO();
		try {
			clientesDAO.eliminarCliente(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void validaTelefonoCelular(AltaClienteRequestTO requestTO) {
		if(requestTO.getTelefonos().getNumCelularNeg().length() > 10 || 
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumCelularNeg()) ||
				requestTO.getTelefonos().getNumCelularResp().length() > 10 ||
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumCelularResp())) {
			log.info("El numero que se encuentra invalido es el celular");
			throw new MensajeExcepcion(TELEFONO_INVALIDO_CELULAR);
		}
	}
	
	private void validaTelefonoLocal(AltaClienteRequestTO requestTO) {
		if(requestTO.getTelefonos().getNumfijoNeg().length() > 10 || 
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumfijoNeg()) ||
				requestTO.getTelefonos().getNumfijoResp().length() > 10 ||
				ValidacionesUtils.isNullOrEmpty(requestTO.getTelefonos().getNumfijoResp())) {
			log.info("El numero que se encuentra invalido es el local");
			throw new MensajeExcepcion(TELEFONO_INVALIDO_LOCAL);
		}
	}
	
	private void validaDireccionCompleta(AltaClienteRequestTO requestTO) {
		if(ValidacionesUtils.isNullOrEmpty(requestTO.getDireccion())) {
			throw new MensajeExcepcion(DIRECCION_VACIA);
		}
	}
	
	private void validaListaClientes(List<ClienteEntityTO> listaClientes) {
		if(listaClientes.size()<1)
			throw new MensajeExcepcion(LISTA_CLIENTES_VACIA);
	}
  
}
