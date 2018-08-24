package com.estopacomplementos.core.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Cesar M Orozco R
 *
 */
public class ConversorUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static Map<String, Object> convierteJsonAMapa(String jsonRequest){
		Map<String, Object> requestMap = new HashMap<String, Object>();
		try {			
			requestMap = mapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>(){});			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return requestMap;
	}
	
	public static String convierteObjetoAJson(Object objeto){
		String jsonObject = null;
		try {			
			jsonObject = mapper.writeValueAsString(objeto);			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
}
