package com.carloscaballero.debatech.modelo;

public class Escuela {
	private Integer ID;
	private String titulo, descripcion;
	
	public Escuela(Integer ID, String titulo, String descripcion) {
		this.ID = ID;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}

}