package com.carloscaballero.debatech.servicios.manager;

import java.util.List;

import com.carloscaballero.debatech.daos.UsuarioDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.UsuarioDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;

public class UsuarioManager {

	public static boolean nombreDeUsuarioOcupado(String nombre) {
		UsuarioDAO dao = new UsuarioDAONeodatis();
		return dao.nombreDeUsuarioOcupado(nombre);
	}
	
	public static Usuario crearUsuario(String nombre, String password) {
		if (nombreDeUsuarioOcupado(nombre))
			throw new IllegalArgumentException("Ya existe una cuenta con el nombre de usuario: "+nombre);
		
		UsuarioDAO dao = new UsuarioDAONeodatis();
		Usuario usuario = new Usuario(dao.nextUsuarioID(), nombre, password);
		dao.guardar(usuario);
		return usuario;
	}
	
	public static Usuario ingresarAlSitio(String nombre, String password) {
		UsuarioDAO dao = new UsuarioDAONeodatis();
		Usuario usuario = dao.getUsuario(nombre, password);
		return usuario;
	}
	
	public static Usuario getUsuario(Integer usuarioID) {
		UsuarioDAO dao = new UsuarioDAONeodatis();
		return dao.getUsuario(usuarioID);
	}
	
	public static List<Tema> getTemasDeUsuario(Usuario usuario, Escuela escuela) {
		
		return null;
	}
		
	public static List<Escuela> getEscuelasDeUsuario(Usuario usuario) {
		
		return null;
	}

	public static int getCantidadDeVotos(Usuario usuario, Escuela escuela) {
		
		return 0;
	}
	
	
	
}
