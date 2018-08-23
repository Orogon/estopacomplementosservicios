package com.estopacomplementos.core.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.ResponseTO;
import com.estopacomplementos.core.dao.GestorProductosDAO;
import com.estopacomplementos.core.entity.AltaProductoRequestTO;
import com.estopacomplementos.core.entity.ConsultaProductoRequestTO;
import com.estopacomplementos.core.entity.ConsultaProductoResponseTO;
import com.estopacomplementos.core.entity.ConsultaProductosResponseTO;
import com.estopacomplementos.core.entity.EliminaProductoRequestTO;
import com.estopacomplementos.core.entity.ProductosEntityTO;
import com.estopacomplementos.core.exceptions.ManejadorMensajes;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.utils.ValidacionesUtils;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class ProductosComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ProductosComponent.class);
	
	private static final Integer NINGUN_PRODUCTO = 8;
	private static final Integer PRODUCTO_INEXISTENTE = 9;
	
	@Autowired
	private GestorProductosDAO productosDAO;
	@Autowired
	private ManejadorMensajes manejadorMensajes;
	
	public ResponseTO registraProducto(AltaProductoRequestTO requestTO) {
		log.info("Entra al metodo de registraProducto :::: ProductosComponent");
		ResponseTO responseTO = new ResponseTO();
		try {
			productosDAO.registraProducto(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	public ConsultaProductosResponseTO consultaProductos() {
		log.info("Entra al metodo de consultaProductos :::: ProductosComponent");
		ConsultaProductosResponseTO responseTO = new ConsultaProductosResponseTO();
		try {
			responseTO.setProductos(validaListaproductos());
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	public ConsultaProductoResponseTO consultaProducto(ConsultaProductoRequestTO requestTO) {
		ConsultaProductoResponseTO responseTO = new ConsultaProductoResponseTO();
		try {
			ProductosEntityTO producto = productosDAO.consultaProducto(requestTO);
			validaProducto(producto);
			responseTO.setProducto(producto);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	/** Este metodo queda pendiente **/
	public void editarProducto() {
		
	}
	
	public ResponseTO eliminaProducto(EliminaProductoRequestTO requestTO) {
		ResponseTO responseTO = new ResponseTO();
		try {
			productosDAO.eliminaProducto(requestTO);
			manejadorMensajes.managerSuccess(responseTO);
		}catch(MensajeExcepcion e) {
			manejadorMensajes.managerException(e, responseTO);
		}
		return responseTO;
	}
	
	private void validaProducto(ProductosEntityTO entityTO) {
		if(ValidacionesUtils.isNullOrEmpty(entityTO))
			throw new MensajeExcepcion(PRODUCTO_INEXISTENTE);
	}
	
	private List<ProductosEntityTO> validaListaproductos(){
		List<ProductosEntityTO> productos = productosDAO.consultaProductos();
		if(ValidacionesUtils.isNullOrEmpty(productos)) {
			throw new MensajeExcepcion(NINGUN_PRODUCTO);
		}
		return productos;
	}

}
