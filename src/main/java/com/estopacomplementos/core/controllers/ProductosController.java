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
import com.estopacomplementos.core.business.ProductosComponent;
import com.estopacomplementos.core.entity.AltaProductoRequestTO;
import com.estopacomplementos.core.entity.ConsultaProductoRequestTO;
import com.estopacomplementos.core.entity.ConsultaProductoResponseTO;
import com.estopacomplementos.core.entity.ConsultaProductosResponseTO;
import com.estopacomplementos.core.utils.ConversorUtils;

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
	
	@RequestMapping(value= {"/registraproducto"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ResponseTO registraProducto(@Valid@RequestBody AltaProductoRequestTO productoRequestTO, HttpSession session) {
		log.info("Entra al metodo de registraProducto ::::: ProductosController");
		ResponseTO responseTO = productosComponent.registraProducto(productoRequestTO);		
		log.info("Respuesta: " + ConversorUtils.convierteObjetoAJson(responseTO));
		return responseTO;
	}
	
	@RequestMapping(value= {"/consultaproductos"}, method = RequestMethod.GET)
	public ConsultaProductosResponseTO consultaProductos(HttpSession session) {
		log.info("Entra al metodo de consultaProductos ::::: ProductosController");
		ConsultaProductosResponseTO responseTO = new ConsultaProductosResponseTO();
		responseTO = productosComponent.consultaProductos();
		return responseTO;
	}
	
	@RequestMapping(value= {"/consultaproducto"}, produces= {"application/json"}, method = RequestMethod.POST, consumes= {"application/json"})
	public ConsultaProductoResponseTO consultaProducto(@Valid@RequestBody ConsultaProductoRequestTO requestTO, HttpSession session) {
		log.info("Entra al metodo de consultaProducto ::::: ProductosController");
		ConsultaProductoResponseTO responseTO = productosComponent.consultaProducto(requestTO);	
		log.info("Respuesta: " + ConversorUtils.convierteObjetoAJson(responseTO));
		return responseTO;
	}

}
