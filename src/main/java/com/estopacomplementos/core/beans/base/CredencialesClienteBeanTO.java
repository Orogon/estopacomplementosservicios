package com.estopacomplementos.core.beans.base;

/**
 * @author Cesar M Orozco R
 *
 */
public class CredencialesClienteBeanTO {
	
	private String usuario;
	private String password;
	private String passwordTemporal;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordTemporal() {
		return passwordTemporal;
	}
	public void setPasswordTemporal(String passwordTemporal) {
		this.passwordTemporal = passwordTemporal;
	}
	
}
