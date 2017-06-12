package com.carloscaballero.debatech.daos.interfaces;

import com.carloscaballero.debatech.modelo.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{
	
	public abstract boolean nombreDeUsuarioOcupado(String nombre);
	
	public abstract Integer nextUsuarioID();
	
	public abstract Usuario getUsuario(String nombre, String password);
	
	public abstract Usuario getUsuario(Integer usuarioID);
	
}
