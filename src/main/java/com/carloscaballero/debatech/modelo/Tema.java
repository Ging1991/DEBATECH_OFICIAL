package com.carloscaballero.debatech.modelo;

public class Tema {
	private Integer ID, usuarioID, escuelaID;
	private String titulo;
	
	public Tema(Integer iD, Integer usuarioID, Integer escuelaID, String titulo) {
		this.ID = iD;
		this.usuarioID = usuarioID;
		this.escuelaID = escuelaID;
		this.titulo = titulo;
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
	public Integer getEscuelaID() {
		return escuelaID;
	}
	public void setEscuelaID(Integer escuelaID) {
		this.escuelaID = escuelaID;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}