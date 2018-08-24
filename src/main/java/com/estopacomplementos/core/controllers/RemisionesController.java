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
import com.estopacomplementos.core.business.GeneraRemisionesComponent;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.utils.CrearFolioNota;

/**
 * @author Cesar M Orozco R
 *
 */
@CrossOrigin
@RestController
@Scope("session")
@RequestMapping(value="/remisiones")
public class RemisionesController {
	
	private static final Logger log = LoggerFactory.getLogger(RemisionesController.class);
	
	@Autowired
	private GeneraRemisionesComponent remisionesComponent;
	
	@RequestMapping(value= "/consultarfolio", method = RequestMethod.GET)
	public String consultaFolio() {
		log.info("Entra al metodo de consultaFolio ::::: RemisionesController");
		return "{\"folioRemision\":\""+CrearFolioNota.crearFolioNota().toUpperCase()+"\"}";
	}
	
	@RequestMapping(value= {"/realizaremision"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ResponseTO realizaRemision(@Valid@RequestBody RemisionesRequestTO requestTO, HttpSession session) {
		log.info("Entra al metodo de realizaRemision ::::: RemisionesController");
		ResponseTO responseTO = remisionesComponent.realizaRemision(requestTO);
		return responseTO;
	}

}
