package com.estopacomplementos.core.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.estopacomplementos.core.beans.base.CodigosErrorEntityTO;
import com.estopacomplementos.core.beans.base.ResponseTO;
import com.estopacomplementos.core.dao.CodigosErrorDAO;
import com.estopacomplementos.core.utils.ValidacionesUtils;

/**
 * @author Cesar M Orozco R
 *
 */
public class ManejadorMensajes {
	
	private static final Logger log = LoggerFactory.getLogger(ManejadorMensajes.class);
	
	@Autowired
	private CodigosErrorDAO codigosErrorDAO;
	
	private static final String DEFAULT_LANGUAGE = "es";
	private static final Integer DEFAULT_SUCCESS = 0;
	private static final Integer DEFAULT_ERROR = 1;
	private HashMap<String, Map<Integer, String>> codigosError;
	private static ManejadorMensajes instance;
	
	private ManejadorMensajes(){
		codigosError = new HashMap<>();
	}
	
	public static ManejadorMensajes getInstance(){
		if(instance == null){
			instance = new ManejadorMensajes();
		}
		return instance;
	}
	
	@PostConstruct
	private void llenaCodigosError() throws SEYCException{
		try{
			log.info("Llenando codigos de respuesta");
			log.info("Otro mensaje");
			List<CodigosErrorEntityTO> errores = codigosErrorDAO.consultaErrores();
			
			for(CodigosErrorEntityTO codigo : errores){
				codigo.setLanguage(codigo.getLanguage() != null ? codigo.getLanguage().toLowerCase() : DEFAULT_LANGUAGE);
				HashMap<Integer, String> listaIdioma = (HashMap<Integer, String>)codigosError.get(codigo.getLanguage());
				if(listaIdioma == null){
					listaIdioma = new HashMap<>();
					codigosError.put(codigo.getLanguage(), listaIdioma);
				}
				listaIdioma.put(codigo.getCode(), codigo.getMensaje());
			}
		}catch(Exception e){
			throw new SEYCException(e);
		}
	}
	
	/**
	 * Metodo que carga el codigo y descripcion de exito.
	 * @param responseTO Objeto en el cual se asignaran codigo y descripcion de exito.
	 */
	public void managerSuccess(ResponseTO responseTO){
		managerSuccess(responseTO, DEFAULT_LANGUAGE);
	}
	
	/**
	 * Metodo que carga el codigo y descripcion de exito.
	 * @param responseTO Objeto en el cual se asignaran codigo y descripcion de exito.
	 * @param language Cadena que tiene el lenguaje que se utilizara para el codigo de error
	 */
	public void managerSuccess(ResponseTO responseTO, String language){
		String idioma = language != null ? language.toLowerCase() : DEFAULT_LANGUAGE;
		Map<Integer, String> codigos = codigosError.get(idioma);
		String mensaje = codigos.get(DEFAULT_SUCCESS);
		
		responseTO.setCodigoOperacion(DEFAULT_SUCCESS.toString());
		responseTO.setDescripcion(mensaje);
	}
	
	/**
	 * Metodo que carga el codigo y descripcion de error.
	 * @param responseTO Objeto en el cual se asignaran codigo y descripcion de error.
	 */
	public void managerException(Exception exceptionTO, ResponseTO objResponseTO){
		managerException(exceptionTO, objResponseTO, DEFAULT_LANGUAGE);
	}
	
	/** Metodo que carga el codigo y descripcion de excepciones y errores.
	 * @param exceptionTO Contiene todos los atributos necesarios para crear la respuesta.
	 * @param objResponseTO objeto de respuesta al cual se le asignaran el codigo y descripcion correspondiente.
	 */
	public void managerException(Exception exceptionTO, ResponseTO objResponseTO, String language){
		String idioma = language != null ? language.toLowerCase() : DEFAULT_LANGUAGE;
		try{
			
			if(exceptionTO instanceof MensajeExcepcion){
				MensajeExcepcion messageException = (MensajeExcepcion) exceptionTO;
				if(messageException.getCustomMessage() != null) {
					setExceptionError(objResponseTO, idioma, messageException.getCodeError(), messageException.getCustomMessage());					
				}else {
					setExceptionError(objResponseTO, idioma, messageException.getCodeError());					
				}
				
			} else {
				setDefaultException(objResponseTO, idioma);				
			}
			
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		if (ValidacionesUtils.isNullOrEmpty(objResponseTO.getDescripcion()) || ValidacionesUtils.isNullOrEmpty(objResponseTO.getCodigoOperacion()))
				setDefaultException(objResponseTO, language);
		
	}
	
	public void setDefaultException(ResponseTO responseTO, String language){
		Map<Integer, String> codigos = codigosError.get(language);
		String mensaje = codigos.get(DEFAULT_ERROR);
		
		responseTO.setCodigoOperacion(DEFAULT_ERROR.toString());
		
		responseTO.setDescripcion(mensaje);
	}
	
	public void setExceptionError(ResponseTO responseTO, String language, Integer codigo){
		try {
			Map<Integer, String> codigos = codigosError.get(language);
			
			
			String mensaje = codigos.get(codigo);
			
			responseTO.setCodigoOperacion(codigo.toString());
			responseTO.setDescripcion(mensaje);
		} catch (Exception e) {
			log.info("El codigo enviado fue: "+codigo);
			setDefaultException(responseTO, language);
		}
	}
	
	
	
	public void setExceptionError(ResponseTO responseTO, String language, Integer codigo, String customMessage){
		try {
			Map<Integer, String> codigos = codigosError.get(language);
			
			
			String mensaje = codigos.get(codigo) + " " + customMessage;
			
			responseTO.setCodigoOperacion(codigo.toString());
			responseTO.setDescripcion(mensaje);
		} catch (Exception e) {
			log.info("El codigo enviado fue: "+codigo);
			setDefaultException(responseTO, language);
		}
	}	

}
