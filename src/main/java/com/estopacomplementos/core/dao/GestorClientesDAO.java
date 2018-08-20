package com.estopacomplementos.core.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.ClienteRequestTO;

/**
 * @author Cesar M Orozco R
 *
 */
@Service
public class GestorClientesDAO {
	
	private static final Logger log = LoggerFactory.getLogger(GestorClientesDAO.class);
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public void registraCliente(ClienteRequestTO requestTO) {
		log.info("Entra al metodo de registraCliente :::: GestorClientesDAO");
		ClienteEntityTO entityTO = creaEntityCliente(requestTO);	
		mongoTemplate.save(entityTO);	
	}
	
	public ClienteEntityTO busquedaPorNombreNegocio(String nombreNegocio) {		
		Query query = new Query(Criteria.where("nombreNegocio").is(nombreNegocio));		
		return mongoTemplate.findOne(query, ClienteEntityTO.class);
	}
	
	private static ClienteEntityTO creaEntityCliente(ClienteRequestTO requestTO) {
		ClienteEntityTO clienteEntityTO = new ClienteEntityTO();
		clienteEntityTO.setActivo(true);
		clienteEntityTO.setRfc(requestTO.getRfc());
		clienteEntityTO.setCorreoElectronico(requestTO.getCorreoElectronico());		
		clienteEntityTO.setDireccion(requestTO.getDireccion());
		clienteEntityTO.setFechaRegistro(new Date());
		clienteEntityTO.setNombreNegocio(requestTO.getNombreNegocio());
		clienteEntityTO.setNombreResponsable(requestTO.getNombreResponsable());
		clienteEntityTO.setApePatResponsable(requestTO.getApePatResponsable());
		clienteEntityTO.setApeMatResponsable(requestTO.getApeMatResponsable());
		clienteEntityTO.setTelefonos(requestTO.getTelefonos());	
		clienteEntityTO.setNotaLibre(requestTO.getNotaLibre());
		return clienteEntityTO;
	}

}
