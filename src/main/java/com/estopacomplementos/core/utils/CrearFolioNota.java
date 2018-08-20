package com.estopacomplementos.core.utils;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Cesar M Orozco R
 *
 */
public class CrearFolioNota {
	
	private static final Logger log = LoggerFactory.getLogger(CrearFolioNota.class);
	
	public static String crearFolioNota() {
		UUID uuid = UUID.randomUUID();
		String folio = uuid.toString().replaceAll("-", "").substring(0, 10);
		log.info("El folio generado es : " + folio);
		return folio;
	}

}
