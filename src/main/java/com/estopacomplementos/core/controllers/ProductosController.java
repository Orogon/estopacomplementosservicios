package com.estopacomplementos.core.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estopacomplementos.core.business.ProductosComponent;

/**
 * @author Cesar M Orozco R
 *
 */
@CrossOrigin
@RestController
@Scope("session")
@RequestMapping(value="/productos")
public class ProductosController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductosController.class);
	
	@Autowired
	private ProductosComponent productosComponent;

}
