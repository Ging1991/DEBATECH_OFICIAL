package com.carloscaballero.debatech.daos.interfaces;

import com.carloscaballero.debatech.modelo.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{

	public abstract boolean usuarioRegistrado (String nombre, String password);
	
	public abstract boolean nombreTomado(String nombre);
	
	public void registrarUsuario(String nombre, String password);
	
	public Usuario getUsuario(String nombre);
	
}
