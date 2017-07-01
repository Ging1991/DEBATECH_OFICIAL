package com.carloscaballero.debatech.servicios.manager;

import com.carloscaballero.debatech.daos.VotoDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.VotoDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;

public class VotoManager {

	public static void votarRepresentante(Escuela escuela, Usuario votante, Usuario votado) {
		VotoDAO dao = new VotoDAONeodatis();
		dao.votarRepresentante(escuela.getID(), votante.getID(), votado.getID());
	}
	
	public static boolean haVotadoAEsteUsuario(Escuela escuela, Usuario votante, Usuario votado) {
		VotoDAO dao = new VotoDAONeodatis();
		return dao.loHaVotado(escuela.getID(), votante.getID(), votado.getID());
	}
	
	public static Integer getCantidadDeVotos(Escuela escuela, Usuario usuario) {
		VotoDAO dao = new VotoDAONeodatis();
		return dao.getCantidadDeVotos(escuela.getID(), usuario.getID());
	}
	
}