package com.carloscaballero.debatech.modelo;

import java.util.List;

public class Postura {
	private String descripcion;
	private List<Usuario> afiliados;
	
	public Postura(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Usuario> getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(List<Usuario> afiliados) {
		this.afiliados = afiliados;
	}
	
}
