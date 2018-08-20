package com.estopacomplementos.core.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.business.ClientesComponent;
import com.estopacomplementos.core.entity.ClienteRequestTO;

@RestController
@Scope("session")
@RequestMapping(value="/controllerCliente")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClientesComponent clientesComponent;
	
	@RequestMapping(value= {"/registracliente"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ResponseTO registraCliente(@Valid@RequestBody ClienteRequestTO clienteRequestTO, HttpSession session) {
		log.info("Entra al metodo de registraCliente ::::: ClienteController");
		ResponseTO responseTO = new ResponseTO();
		responseTO.setCodigoOperacion("0");
		responseTO.setDescripcion("Operacion Exitosa");
		return responseTO;
	}

}
