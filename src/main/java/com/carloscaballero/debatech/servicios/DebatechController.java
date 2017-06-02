package com.carloscaballero.debatech.servicios;

import java.util.List;

import com.carloscaballero.debatech.daos.DAONeodatis;
import com.carloscaballero.debatech.daos.EscuelaDAONeodatis;
import com.carloscaballero.debatech.daos.TemaDAONeodatis;
import com.carloscaballero.debatech.daos.UsuarioDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.DAO;
import com.carloscaballero.debatech.daos.interfaces.EscuelaDAO;
import com.carloscaballero.debatech.daos.interfaces.TemaDAO;
import com.carloscaballero.debatech.daos.interfaces.UsuarioDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Postura;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;

public class DebatechController {

	// USUARIOS
	public void registrarUsuario(String usuario, String password, String passwordRepetido) throws IllegalArgumentException {
		if (usuario==null || usuario.equals(""))
			throw new IllegalArgumentException("El usuario no puede estar vacio");
		
		if (password==null || password.equals(""))
			throw new IllegalArgumentException("El password no puede estar vacio");
		
		if (!password.equals(passwordRepetido))
			throw new IllegalArgumentException("El password no se repitio correctamente");
			
		UsuarioDAO dao = new UsuarioDAONeodatis();
		if (dao.nombreTomado(usuario))
			throw new IllegalArgumentException("Ese nombre de usuario ya esta tomado");
					
		dao.registrarUsuario(usuario, password);
	}
	
	public boolean estaRegistrado (String usuario, String password) {
		UsuarioDAO dao = new UsuarioDAONeodatis();
		return dao.usuarioRegistrado(usuario, password);
	}
	
	public Usuario getUsuario (String usuario, String password) {
		UsuarioDAO dao = new UsuarioDAONeodatis();
		Usuario u = dao.getUsuario(usuario);
		
		if (u==null)
			throw new IllegalArgumentException("el usuario no se encontraba registrado");
		
		return u;
	}

	
	
	
	
	// ESCUELAS
	public void crearEscuela(String titulo, String descripcion) throws IllegalArgumentException {
		if (titulo==null || titulo.equals(""))
			throw new IllegalArgumentException("El titulo no puede estar vacio");
		
		if (descripcion==null || descripcion.equals(""))
			throw new IllegalArgumentException("La descripcion no puede estar vacia");
			
		EscuelaDAO dao = new EscuelaDAONeodatis();
		if (dao.nombreTomado(titulo))
			throw new IllegalArgumentException("Ese nombre de escuela ya esta tomado");
					
		dao.guardar(new Escuela(titulo, descripcion));
	}

	public void afiliarseAEscuela(Usuario usuario, Escuela escuela) {
		for (Usuario actual : escuela.getAfiliados()) {
			if (actual.equals(usuario))
				throw new IllegalArgumentException("El usuario ya estaba afiliado a esta escuela");
		}

		EscuelaDAO dao = new EscuelaDAONeodatis();
		dao.afiliarUsuario(escuela, usuario);
	}

	
	public boolean estaAfiliado(Usuario usuario, Escuela escuela) {
		List<Usuario> usuarios = escuela.getAfiliados();
		
		for (Usuario actual : usuarios) {
			if (actual.getNombre().equals(usuario.getNombre()))
				return true;
		}
		
		return false;
	}
	
	
	
	// TEMAS
	public void crearTema(Escuela escuela, Usuario usuario, String titulo) {
		
		if (!estaAfiliado(usuario, escuela))
			throw new IllegalArgumentException("El usuario no esta afiliado a esta escuela");
		
		Tema tema = new Tema(titulo);
		escuela.getTemas().add(tema);
		EscuelaDAO dao = new EscuelaDAONeodatis();
		dao.crearTema(escuela, tema);
	}
	
	

	// MENSAJE
	public void crearMensaje(Tema tema, Usuario usuario, String texto) {
		Mensaje mensaje = new Mensaje(texto, usuario);		
		TemaDAO dao = new TemaDAONeodatis();
		dao.responderTema(tema, mensaje);
	}
	
	
	
	
	
	// POSTURAS
	public void crearPosturas(String contenido) {
		Postura postura = new Postura(contenido);
		DAO<Postura> dao = new DAONeodatis<Postura>();
		dao.guardar(postura);
	}
	
	

}
