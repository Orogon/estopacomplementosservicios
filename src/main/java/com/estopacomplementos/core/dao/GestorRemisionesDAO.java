package com.estopacomplementos.core.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.estopacomplementos.core.entity.RemisionesEntityTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;

@Service
public class GestorRemisionesDAO {
	
	private static final Logger log = LoggerFactory.getLogger(GestorRemisionesDAO.class);
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	/**
	 * @param requestTO
	 * @param idCliente
	 */
	public void registraNotaCliente(RemisionesRequestTO requestTO, String idCliente) {
		log.info("Entra al metodo de registraNotaCliente ::::: GestorRemisionesDAO");
		/** Falta validacion de que la nota no se repita **/
		mongoTemplate.save(creaObjetoRemision(requestTO, idCliente));
	}	
	
	
	private RemisionesEntityTO creaObjetoRemision(RemisionesRequestTO requestTO, String idCliente) {
		RemisionesEntityTO entityTO = new RemisionesEntityTO();
		entityTO.setAhorro(requestTO.getAhorro());
		entityTO.setDelete(false);
		entityTO.setDiasCredito(requestTO.getDiasCredito());
		entityTO.setFechaRegistro(new Date());
		entityTO.setFechaRemision(requestTO.getFechaRemision());
		entityTO.setFolioNota(requestTO.getFolioNota());
		entityTO.setIdCliente(idCliente);
		entityTO.setProductosVendidos(requestTO.getVenta());
		entityTO.setTipoVenta(requestTO.getTipoVenta());
		entityTO.setTotalNotaConDescuento(requestTO.getTotalNotaConDescuento());
		entityTO.setTotalNotaSinDescuento(requestTO.getTotalNotaSinDescuento());		
		return entityTO;
	}

}
