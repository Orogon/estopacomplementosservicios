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
	
	public void registraNotaCliente(RemisionesRequestTO requestTO, String idCliente) {
		RemisionesEntityTO entityTO = creaObjetoRemision(requestTO, idCliente);
		mongoTemplate.save(entityTO);
		log.info(entityTO.getId());
	}
	
	private RemisionesEntityTO creaObjetoRemision(RemisionesRequestTO requestTO, String idCliente) {
		RemisionesEntityTO entityTO = new RemisionesEntityTO();
		entityTO.setFechaRemision(new Date());
		entityTO.setFolioNota(requestTO.getFolioNota());
		entityTO.setProductosVendidos(requestTO.getVenta());
		entityTO.setTipoVenta(requestTO.getTipoVenta());
		entityTO.setTotalNota(requestTO.getTotalNota());
		entityTO.setIdCliente(idCliente);
		entityTO.setFechaRegistro(new Date());
		return entityTO;
	}

}
