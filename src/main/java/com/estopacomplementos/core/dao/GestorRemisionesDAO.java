package com.estopacomplementos.core.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.RemisionesEntityTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.utils.ValidacionesUtils;

@Service
public class GestorRemisionesDAO {
	
	private static final Logger log = LoggerFactory.getLogger(GestorRemisionesDAO.class);
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public RemisionesEntityTO registraNotaCliente(RemisionesRequestTO requestTO, ClienteEntityTO idCliente) {
		RemisionesEntityTO entityTO = creaObjetoRemision(requestTO, idCliente);
		mongoTemplate.save(entityTO);
		return entityTO;
	}
	
	private RemisionesEntityTO creaObjetoRemision(RemisionesRequestTO requestTO, ClienteEntityTO cliente) {
		RemisionesEntityTO entityTO = new RemisionesEntityTO();
		entityTO.setFechaRemision(new Date());
		entityTO.setFolioNota(requestTO.getFolioNota());
		entityTO.setProductosVendidos(requestTO.getVenta());
		entityTO.setTipoVenta(requestTO.getTipoVenta());				
		entityTO.setFechaRegistro(new Date());
		entityTO.setDireccionNegocio(cliente.getDireccion().getCalle()+" "+cliente.getDireccion().getNumInterior());
		entityTO.setColoniaCliente(cliente.getDireccion().getColonia());
		entityTO.setEstadoCLiente(cliente.getDireccion().getEstado());
		entityTO.setIdCliente(cliente.getId());
		entityTO.setNombreNegocio(requestTO.getNombreNegocio());
		if(!ValidacionesUtils.isNullOrEmpty(requestTO.getAhorroTotal())) {
			entityTO.setTotalAhorro(requestTO.getAhorroTotal());			
		} else { 
			entityTO.setTotalAhorro("No Aplica");			
		}
		return entityTO;
	}

}
