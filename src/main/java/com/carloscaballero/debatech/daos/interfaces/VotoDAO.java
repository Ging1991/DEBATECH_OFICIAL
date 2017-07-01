package com.carloscaballero.debatech.daos.interfaces;

import com.carloscaballero.debatech.modelo.VotoRepresentante;

public interface VotoDAO extends DAO<VotoRepresentante>{

	public abstract void votarRepresentante(Integer escuelaID, Integer votanteID, Integer votadoID);
	
	public abstract boolean loHaVotado(Integer escuelaID, Integer votanteID, Integer votadoID);
	
	public abstract Integer getCantidadDeVotos(Integer escuelaID, Integer usuarioID);
		
}