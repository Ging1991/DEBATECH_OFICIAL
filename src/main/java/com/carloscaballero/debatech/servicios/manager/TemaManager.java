package com.carloscaballero.debatech.servicios.manager;

import java.util.List;

import com.carloscaballero.debatech.daos.DAONeodatis;
import com.carloscaballero.debatech.daos.TemaDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.DAO;
import com.carloscaballero.debatech.daos.interfaces.TemaDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;

public class TemaManager {

	static public void crearTema(String titulo, Usuario usuario, Escuela escuela){
		TemaDAO dao = new TemaDAONeodatis();
		Tema tema = new Tema(dao.nextTemaID(), usuario.getID(), escuela.getID(), titulo);
		dao.guardar(tema);
	}
	
	static public void responderTema(Tema tema, Usuario usuario, String texto) {
		TemaDAO dao = new TemaDAONeodatis();
		Mensaje mensaje = new Mensaje(dao.nextMensajeID(), usuario.getID(), tema.getID(), texto);
		DAO<Mensaje> dao2 = new DAONeodatis<Mensaje>();
		dao2.guardar(mensaje); 
	}
	
	static public boolean haRespondido(Tema tema, Usuario usuario) {
		//TemaDAO dao = new TemaDAONeodatis();
		//return dao.haRespondido(usuario.getID(), tema.getID());
		return false;
	}
	
	static public List<Tema> getTemasDeEscuela(Escuela escuela){
		TemaDAO dao = new TemaDAONeodatis();
		return dao.getTemasDeEscuela(escuela.getID());
	}
	
	static public List<Mensaje> getMensajesDeTema(Tema tema){
		TemaDAO dao = new TemaDAONeodatis();
		return dao.getMensajesDeTema(tema.getID());
	}
	
}