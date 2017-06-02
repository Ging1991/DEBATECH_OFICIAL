package com.carloscaballero.debatech.modelo;

public class Mensaje {
	
	private String texto;
	private Usuario usuario;
	public Mensaje(String texto, Usuario usuario) {
		super();
		this.texto = texto;
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
