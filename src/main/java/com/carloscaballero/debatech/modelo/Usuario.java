package com.carloscaballero.debatech.modelo;

public class Usuario {
	private Integer ID;
	private String nombre, password;

	public Usuario(Integer ID, String nombre, String password) {
		super();
		this.ID = ID;
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
}