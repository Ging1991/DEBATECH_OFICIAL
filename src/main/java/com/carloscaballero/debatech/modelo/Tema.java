package com.carloscaballero.debatech.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tema {
	private String titulo;
	private List<Mensaje> mensajes;
	
	public Tema(String titulo) {
		this.titulo = titulo;
		mensajes = new ArrayList<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
