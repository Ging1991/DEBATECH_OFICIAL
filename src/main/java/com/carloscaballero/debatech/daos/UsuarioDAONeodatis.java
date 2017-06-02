package com.carloscaballero.debatech.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.carloscaballero.debatech.daos.interfaces.UsuarioDAO;
import com.carloscaballero.debatech.modelo.Usuario;

public class UsuarioDAONeodatis extends DAONeodatis<Usuario> implements UsuarioDAO{
	
	public Usuario getUsuario(String nombre) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Usuario> usuarios = odb.getObjects(Usuario.class);
		Usuario usuario = null;
		
		for (Usuario actual: usuarios) {
			actual = usuarios.next();
			if (actual.getNombre().equals(nombre))
				usuario = actual;
		}
		
		odb.close();
		return usuario;
	}

	@Override
	public boolean usuarioRegistrado(String usuario, String password) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Usuario> usuarios = odb.getObjects(Usuario.class);
		boolean registrado = false;
		
		for (Usuario usuarioActual: usuarios) {
			usuarioActual = usuarios.next();
			if (usuarioActual.getNombre().equals(usuario) && usuarioActual.getPassword().equals(password))
				registrado = true;
		}
		
		odb.close();
		return registrado;
	}

	@Override
	public boolean nombreTomado(String nombre) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Usuario> clientes = odb.getObjects(Usuario.class);
		boolean registrado = false;
		
		for (Usuario usuario: clientes) {
			usuario = clientes.next();
			if (usuario.getNombre().equals(nombre))
				registrado = true;
		}
		
		odb.close();
		return registrado;
	}

	@Override
	public void registrarUsuario(String mail, String password) {
		Usuario cliente = new Usuario(mail, password);
		guardar(cliente);
	}
}
