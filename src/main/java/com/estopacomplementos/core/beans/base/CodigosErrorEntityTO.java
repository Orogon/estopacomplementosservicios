package com.estopacomplementos.core.beans.base;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Cesar M orozco R
 *
 */
@Document(collection="CodigosDeError")
public class CodigosErrorEntityTO {
	
	@Id
    private String id;
	private Integer code;
	@Field("lnge")
	private String language;
	@Field("msj")
	private String mensaje;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
