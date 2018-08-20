package com.estopacomplementos.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.CodigosErrorEntityTO;

@Component
public class CodigosErrorDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CodigosErrorDAO.class);
	
	@Autowired
	@Qualifier("primaryMongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public void registraError(CodigosErrorEntityTO entityTO) {
		mongoTemplate.save(entityTO);
	}
	
	public List<CodigosErrorEntityTO> consultaErrores(){
		List<CodigosErrorEntityTO> errores = new ArrayList<>();
		try {
			errores = mongoTemplate.findAll(CodigosErrorEntityTO.class);
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return errores;
	}

}
