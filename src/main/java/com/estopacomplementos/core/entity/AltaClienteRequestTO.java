package com.estopacomplementos.core.entity;

import org.hibernate.validator.constraints.NotBlank;

import com.estopacomplementos.core.benas.base.DireccionBeanTO;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;

/**
 * @author Cesar M Orozco R
 *
 */
public class AltaClienteRequestTO {
	
	@NotBlank(message="El nombre del responsable no puede venir vacio.")
	private String nombreResponsable;
	@NotBlank(message="El nombre del negocio no puede venir vacio.")
	private String nombreNegocio;
	private TelefonosBeanTO telefonos;	
	private DireccionBeanTO direccion;	
	private String rfc;	
	@NotBlank(message="El correo electronico del encargado o negocio no puede venir vacio.")
	private String correoElectronico;
	private String notaLibre;
	
	
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	public TelefonosBeanTO getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(TelefonosBeanTO telefonos) {
		this.telefonos = telefonos;
	}
	public DireccionBeanTO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionBeanTO direccion) {
		this.direccion = direccion;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNotaLibre() {
		return notaLibre;
	}
	public void setNotaLibre(String notaLibre) {
		this.notaLibre = notaLibre;
	}
}
