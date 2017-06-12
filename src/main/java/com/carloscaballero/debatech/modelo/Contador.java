package com.carloscaballero.debatech.modelo;

public class Contador {
	private Integer escuelaID, mensajaeID, temaID, usuarioID;
	
	public Contador() {
		escuelaID = 0;
		mensajaeID = 0;
		temaID = 0;
		usuarioID = 0;;
	}

	public Integer getEscuelaID() {
		escuelaID += 1;
		return escuelaID;
	}
	public Integer getMensajaeID() {
		mensajaeID += 1;
		return mensajaeID;
	}
	public Integer getTemaID() {
		temaID += 1;
		return temaID;
	}
	public Integer getUsuarioID() {
		usuarioID += 1;
		return usuarioID;
	}
		
}