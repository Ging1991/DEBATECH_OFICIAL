package com.carloscaballero.debatech.modelo;

public class Mensaje {
	private Integer ID, usuarioID, temaID;
	private String texto;
	
	public Mensaje(Integer iD, Integer usuarioID, Integer temaID, String texto) {
		this.ID = iD;
		this.usuarioID = usuarioID;
		this.temaID = temaID;
		this.texto = texto;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}
	public Integer getTemaID() {
		return temaID;
	}
	public void setTemaID(Integer temaID) {
		this.temaID = temaID;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}