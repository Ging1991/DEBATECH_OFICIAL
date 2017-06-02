package com.carloscaballero.debatech.daos.interfaces;

import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;

public interface TemaDAO extends DAO<Tema>{

	public void responderTema(Tema tema, Mensaje mensaje);
	
}
