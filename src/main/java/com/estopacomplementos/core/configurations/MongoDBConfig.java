package com.estopacomplementos.core.configurations;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.MongoClientURI;

/**
 * @author Cesar M Orozco R
 *
 */
@Configuration
public class MongoDBConfig {
	
	public MongoClientURI mongoDos() {
		/** Cambiar por ip de servidor **/
		return new MongoClientURI("mongodb://10.51.58.228:9000/PuntoVenta");
	}
	
	@Primary
	@Bean
	public MongoTemplate primaryMongoTemplate() throws UnknownHostException {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoDos());
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		((MappingMongoConverter) mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));
		return mongoTemplate;
	}

}
