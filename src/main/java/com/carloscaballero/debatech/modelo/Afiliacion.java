package com.carloscaballero.debatech.modelo;

public class Afiliacion {
	private Integer usuarioID, escuelaID;

	public Afiliacion(Integer usuarioID, Integer escuelaID) {
		this.usuarioID = usuarioID;
		this.escuelaID = escuelaID;
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
	
}