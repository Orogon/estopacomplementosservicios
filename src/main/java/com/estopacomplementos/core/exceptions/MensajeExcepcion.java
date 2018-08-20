package com.estopacomplementos.core.exceptions;

/**
 * @author Cesar M Orozco R
 *
 */
public class MensajeExcepcion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private Integer codeError;
	private String etiqueta;	
	private String codigoNoMapeado;
	private String customMessage;
	
	public MensajeExcepcion(Integer code){
		codeError = code;
	}
	
	public MensajeExcepcion(Integer code, String mensajeExtra){
		codeError = code;
		customMessage = mensajeExtra;
	}
	
	public MensajeExcepcion(Integer code, Throwable cause){
		super(cause);
		codeError = code;
	}
	
	public MensajeExcepcion(Integer code, String mensajeExtra, Throwable cause){
		super(cause);
		codeError = code;
		customMessage = mensajeExtra;
	}

	public MensajeExcepcion(Integer codeError, String etiqueta, String codigoNoMapeado) {
		super();
		this.codeError = codeError;
		this.etiqueta = etiqueta;
		this.codigoNoMapeado = codigoNoMapeado;
	}
	
	public MensajeExcepcion(Integer codeError, String etiqueta, String codigoNoMapeado, Exception exception) {
		super(exception);
		this.codeError = codeError;
		this.etiqueta = etiqueta;
		this.codigoNoMapeado = codigoNoMapeado;
	}

	public Integer getCodeError() {
		return codeError;
	}

	public void setCodeError(Integer codeError) {
		this.codeError = codeError;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}

	public String getCodigoNoMapeado() {
		return codigoNoMapeado;
	}
	
	public String getCustomMessage() {
		return customMessage;
	}
	
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

}
