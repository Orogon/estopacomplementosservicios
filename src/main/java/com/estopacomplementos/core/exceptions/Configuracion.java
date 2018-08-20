package com.estopacomplementos.core.exceptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
	
	@Bean
	public ManejadorMensajes manejadorMensajes() {
		return ManejadorMensajes.getInstance();
	}
	
}
