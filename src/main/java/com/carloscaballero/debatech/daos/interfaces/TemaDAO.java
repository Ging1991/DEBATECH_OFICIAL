package com.carloscaballero.debatech.daos.interfaces;

import java.util.List;

import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;

public interface TemaDAO extends DAO<Tema>{
	
	public abstract Integer nextTemaID();

	public abstract Integer nextMensajeID();
	
	public abstract boolean haRespondido(Integer usuarioID, Integer temaID);
	
	public abstract List<Tema> getTemasDeEscuela(Integer escuelaID);
	
	public abstract List<Mensaje> getMensajesDeTema(Integer temaID);
	
	public abstract Escuela getEscuelaDeTema(Integer temaID);
	
}
