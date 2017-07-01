package com.carloscaballero.debatech.servicios.manager;

import com.carloscaballero.debatech.daos.TemaDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.TemaDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Mensaje;

public class MensajeManager {

	public static Escuela getEscuelaDeMensaje(Mensaje mensaje) {
		TemaDAO dao = new TemaDAONeodatis();
		return dao.getEscuelaDeTema(mensaje.getTemaID());
	}
	
}
