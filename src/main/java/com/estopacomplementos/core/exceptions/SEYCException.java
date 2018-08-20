package com.estopacomplementos.core.exceptions;

public class SEYCException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SEYCException(Exception e) {
		super(e);
	}
	
	public SEYCException() {}
	
	public SEYCException(String message) {
		super(message);
	}

}
