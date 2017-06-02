package com.carloscaballero.debatech.modelo;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
	
	private String titulo, descripcion;
	private List<Tema> temas;
	private List<Usuario> afiliados;
	
	public Escuela(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.temas = new ArrayList<Tema>();
		this.afiliados = new ArrayList<Usuario>();
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
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public List<Usuario> getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(List<Usuario> afiliados) {
		this.afiliados = afiliados;
	}
	
	
	
	
	
	
	

}
