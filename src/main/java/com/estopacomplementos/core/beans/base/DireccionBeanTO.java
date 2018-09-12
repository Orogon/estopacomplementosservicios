package com.estopacomplementos.core.beans.base;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Cesar M Orozco R
 *
 */
public class DireccionBeanTO {
	
	@NotBlank(message="La calle no puede venir vacio.")
	private String calle;
	@NotBlank(message="El numero interior no puede venir vacio.")
	private String numInterior;
	@NotBlank(message="La delegacion o municipio no puede venir vacio.")
	private String delgacionMunicipio;
	@NotBlank(message="El codigo postal no puede venir vacio.")
	private String codigoPostal;
	@NotBlank(message="El estado no puede venir vacio.")
	private String estado;
	@NotBlank(message="La colonia no puede venir vacia.")
	private String colonia;
	private String numExterior;	
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
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getTxtLibre() {
		return txtLibre;
	}
	public void setTxtLibre(String txtLibre) {
		this.txtLibre = txtLibre;
	}
	

}
