package com.estopacomplementos.core.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.business.ClientesComponent;
import com.estopacomplementos.core.entity.AltaClienteRequestTO;
import com.estopacomplementos.core.entity.ConsultaClienteRequesTO;
import com.estopacomplementos.core.entity.ConsultaClientesResponseTO;
import com.estopacomplementos.core.entity.EditarClienteRequesTO;


/**
 * @author Cesar M Orozco R
 *
 */
@CrossOrigin
@RestController
@Scope("session")
@RequestMapping(value="/clientes")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClientesComponent clientesComponent;
	
	@RequestMapping(value= {"/registracliente"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ResponseTO registraCliente(@Valid@RequestBody AltaClienteRequestTO clienteRequestTO, HttpSession session) {
		log.info("Entra al metodo de registraCliente ::::: ClienteController");
		ResponseTO responseTO = clientesComponent.registraCliente(clienteRequestTO);
		return responseTO;
	}
	
	@RequestMapping(value= {"/consultaclientes"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ConsultaClientesResponseTO consultaClientes(HttpSession session) {
		log.info("Entra al metodo de consultaClientes ::::: ClienteController");
		ConsultaClientesResponseTO responseTO = new ConsultaClientesResponseTO();
		responseTO = clientesComponent.consultaClientes();
		return responseTO;
	}
	
	@RequestMapping(value= {"/consultacliente"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ConsultaClientesResponseTO consultaCliente(@Valid @RequestBody ConsultaClienteRequesTO requesTO, HttpSession session) {
		log.info("Entra al metodo de consultaCliente ::::: ClienteController");
		ConsultaClientesResponseTO responseTO = new ConsultaClientesResponseTO();
		responseTO = clientesComponent.consultaClientes();
		return responseTO;
	}
	
	@RequestMapping(value= {"/editacliente"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ResponseTO editaCliente(@Valid @RequestBody EditarClienteRequesTO requesTO, HttpSession session) {
		log.info("Entra al metodo de editaCliente ::::: ClienteController");		
		ResponseTO responseTO = clientesComponent.editarCliente(requesTO);
		return responseTO;
	}

}
