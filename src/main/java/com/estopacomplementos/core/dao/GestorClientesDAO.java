package com.estopacomplementos.core.dao;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.estopacomplementos.core.entity.ClienteEntityTO;
import com.estopacomplementos.core.entity.EditarClienteRequesTO;
import com.estopacomplementos.core.entity.EliminarClienteRequestTO;
import com.estopacomplementos.core.utils.ValidacionesUtils;
import com.mongodb.WriteResult;
import com.estopacomplementos.core.entity.AltaClienteRequestTO;

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
	
	/**
	 * @param requestTO
	 */
	public void registraCliente(AltaClienteRequestTO requestTO) {
		log.info("Entra al metodo de registraCliente :::: GestorClientesDAO");
		ClienteEntityTO entityTO = creaEntityCliente(requestTO);	
		mongoTemplate.save(entityTO);	
	}
	
	/**
	 * @return
	 */
	public List<ClienteEntityTO> consultaClientes(){
		Query query = new Query(Criteria.where("activo").is(true));
		return mongoTemplate.find(query, ClienteEntityTO.class);
	}
	
	/**
	 * @param nombreNegocio
	 * @return
	 */
	public ClienteEntityTO busquedaPorNombreNegocio(String nombreNegocio) {	
		Query query = new Query(Criteria.where("nombreNegocio").is(nombreNegocio));		
		return mongoTemplate.findOne(query, ClienteEntityTO.class);
	}
	
	/**
	 * @param nombreEncargado
	 * @return
	 */
	public ClienteEntityTO busquedaPorNombreEncargado(String nombreEncargado) {	
		Query query = new Query(Criteria.where("nombreResponsable").is(nombreEncargado));		
		return mongoTemplate.findOne(query, ClienteEntityTO.class);
	}
	
	/**
	 * @param requesTO
	 */
	public void editarCliente(EditarClienteRequesTO requesTO) {
		Query query = new Query(Criteria.where("_id").is(requesTO.getIdCliente()));
		Update update = new Update();
		update.addToSet("fechaModificacion", new Date());
		if(!ValidacionesUtils.isNullOrEmpty(requesTO.getNombreResponsable()))
			update.addToSet("nombreResponsable", requesTO.getNombreResponsable());
		if(!ValidacionesUtils.isNullOrEmpty(requesTO.getCorreoElectronico()))
			update.addToSet("correoElectronico", requesTO.getCorreoElectronico());
		if(!ValidacionesUtils.isNullOrEmpty(requesTO.getTelefonos()))
			update.addToSet("telefonos", requesTO.getTelefonos());
		WriteResult result = mongoTemplate.updateFirst(query, update, ClienteEntityTO.class);
		if(result.isUpdateOfExisting())
			log.info("Se actualizo correctamente el cliente con el id: " + requesTO.getIdCliente());
	}
	
	/**
	 * @param requestTO
	 */
	public void eliminarCliente(EliminarClienteRequestTO requestTO) {
		log.info("Entra al metodo de eliminarCliente ::::: GestorClientesDAO");
		Query query = new Query(Criteria.where("_id").is(requestTO.getIdCliente()));
		Update update = new Update();
		update.set("fechaModificacion", new Date());
		update.set("activo", false);
		WriteResult result = mongoTemplate.updateFirst(query, update, ClienteEntityTO.class);
		if(result.isUpdateOfExisting())
			log.info("Se ha eliminado correctamente el siguiente cliente : " + requestTO.getIdCliente());
	}
	
	private static ClienteEntityTO creaEntityCliente(AltaClienteRequestTO requestTO) {
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
