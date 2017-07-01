package com.carloscaballero.debatech.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.nq.SimpleNativeQuery;
import com.carloscaballero.debatech.daos.interfaces.VotoDAO;
import com.carloscaballero.debatech.modelo.VotoRepresentante;

public class VotoDAONeodatis extends DAONeodatis<VotoRepresentante> implements VotoDAO{
	
	@Override
	public void votarRepresentante(Integer escuelaID, Integer votanteID, Integer votadoID) {
		VotoRepresentante voto = new VotoRepresentante(escuelaID, votanteID, votadoID);
		guardar(voto);
	}

	@Override
	public boolean loHaVotado(Integer escuelaID, Integer votanteID, Integer votadoID) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		
		SimpleNativeQuery query = new SimpleNativeQuery() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unused")
			public boolean match(VotoRepresentante voto) {
            	boolean mismaEscuela = (voto.getEscuelaID().equals(escuelaID));
            	boolean mismoVotante = (voto.getVotanteID().equals(votanteID));
            	boolean mismoVotado = (voto.getVotadoID().equals(votadoID));
            	return (mismaEscuela && mismoVotante && mismoVotado);
            }
        };
		
		Objects<VotoRepresentante> votosOBJ = odb.getObjects(query);
		odb.close();
		
		boolean loVoto = true;
		if (votosOBJ.isEmpty())
			loVoto = false;
		
		return loVoto;
	}

	@Override
	public Integer getCantidadDeVotos(Integer escuelaID, Integer usuarioID) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		
		SimpleNativeQuery query = new SimpleNativeQuery() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unused")
			public boolean match(VotoRepresentante voto) {
            	boolean mismaEscuela = (voto.getEscuelaID().equals(escuelaID));
            	boolean mismoVotado = (voto.getVotadoID().equals(usuarioID));
            	return (mismaEscuela && mismoVotado);
            }
        };
		
		Objects<VotoRepresentante> votosOBJ = odb.getObjects(query);
		odb.close();
		
		return votosOBJ.size();
	}
	
}