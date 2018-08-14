package com.estopacomplementos.core.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Cesar M Orozco R
 *
 */
@Document(collection="Productos")
public class ProductosEntityTO {
	
	@Id
	private String id;
	private String nombreProudcto;
	private String precio;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreProudcto() {
		return nombreProudcto;
	}
	public void setNombreProudcto(String nombreProudcto) {
		this.nombreProudcto = nombreProudcto;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}	

}
