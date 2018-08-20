package com.estopacomplementos.core.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value= "/consultarfolio", method = RequestMethod.GET)
	public String consultaFolio() {
		log.info("Entra al metodo de consultaFolio ::::: RemisionesController");
		return CrearFolioNota.crearFolioNota();
	}

}
