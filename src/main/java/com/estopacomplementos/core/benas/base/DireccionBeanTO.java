package com.estopacomplementos.core.benas.base;

import org.hibernate.validator.constraints.NotBlank;

public class DireccionBeanTO {
	
	@NotBlank
	private String calle;
	@NotBlank
	private String numInterior;
	private String numExterior;
	@NotBlank
	private String delgacionMunicipio;
	@NotBlank
	private String codigoPostal;
	@NotBlank
	private String estado;
	private String referencias;
	private String txtLibre;
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumInterior() {
		return numInterior;
	}
	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	public String getNumExterior() {
		return numExterior;
	}
	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}
	public String getDelgacionMunicipio() {
		return delgacionMunicipio;
	}
	public void setDelgacionMunicipio(String delgacionMunicipio) {
		this.delgacionMunicipio = delgacionMunicipio;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReferencias() {
		return referencias;
	}
	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}
	public String getTxtLibre() {
		return txtLibre;
	}
	public void setTxtLibre(String txtLibre) {
		this.txtLibre = txtLibre;
	}
	

}
