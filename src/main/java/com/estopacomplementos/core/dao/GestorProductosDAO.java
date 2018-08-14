package com.estopacomplementos.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.estopacomplementos.core.entity.ProductosEntityTO;

@Service
public class GestorProductosDAO {
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public void prueba(ProductosEntityTO entityTO) {
		mongoTemplate.save(entityTO);
	}

}
