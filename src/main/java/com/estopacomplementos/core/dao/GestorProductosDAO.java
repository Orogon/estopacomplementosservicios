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

import com.estopacomplementos.core.entity.AltaProductoRequestTO;
import com.estopacomplementos.core.entity.ConsultaProductoRequestTO;
import com.estopacomplementos.core.entity.EliminaProductoRequestTO;
import com.estopacomplementos.core.entity.ProductosEntityTO;
import com.estopacomplementos.core.utils.ValidacionesUtils;
import com.mongodb.WriteResult;

@Service
public class GestorProductosDAO {
	
	private static final Logger log = LoggerFactory.getLogger(GestorProductosDAO.class);
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	
	public void registraProducto(AltaProductoRequestTO requestTO) {
		ProductosEntityTO entityTO = creaBeanProductos(requestTO);
		mongoTemplate.save(entityTO);
	}
	
	public List<ProductosEntityTO> consultaProductos(){
		Query query = new Query(Criteria.where("activo").is(true));
		return mongoTemplate.find(query, ProductosEntityTO.class);
	}
	
	public ProductosEntityTO consultaProducto(ConsultaProductoRequestTO requestTO) {
		Query query = new Query(Criteria.where("activo").is(true));
		if(!ValidacionesUtils.isNullOrEmpty(requestTO.getCodigoProducto())) {
			log.info("Entra al metodo de busqueda en producto por codigo producto");
			query.addCriteria(Criteria.where("codigoProducto").is(requestTO.getCodigoProducto()));
		}else {
			log.info("Entra al metodo de busqueda en producto por nombre producto");
			query.addCriteria(Criteria.where("nombreProducto").is(requestTO.getNombreProducto()));
		}
		return mongoTemplate.findOne(query, ProductosEntityTO.class);		
	}
	
	/** Queda pendiente este flujo **/
	public void editarProducto() {
		
	}
	
	public void eliminaProducto(EliminaProductoRequestTO requestTO) {
		Query query = new Query(Criteria.where("_id").is(requestTO.getIdProducto()));
		Update update = new Update();
		update.set("fechaModificacion", new Date());
		update.set("activo", false);
		WriteResult result = mongoTemplate.updateFirst(query, update, ProductosEntityTO.class);
		if(result.isUpdateOfExisting())
			log.info("Se elimino correctamente el producto con el id : " + requestTO.getIdProducto());
	}
	
	private ProductosEntityTO creaBeanProductos(AltaProductoRequestTO requestTO) {
		ProductosEntityTO entityTO = new ProductosEntityTO();
		entityTO.setCodigoProducto(requestTO.getCodigoProducto());
		entityTO.setDescripcionProducto(requestTO.getDescripcionProducto());
		entityTO.setFechaRegistro(new Date());
		entityTO.setActivo(true);
		entityTO.setMarcaProducto(requestTO.getMarcaProducto());
		entityTO.setNombreProducto(requestTO.getNombreProducto());
		entityTO.setPrecioCompra(requestTO.getPrecioCompra());
		entityTO.setPrecioVenta(requestTO.getPrecioVenta());
		entityTO.setSubmarcaProducto(requestTO.getSubmarcaProducto());
		return entityTO;		
	}

}
