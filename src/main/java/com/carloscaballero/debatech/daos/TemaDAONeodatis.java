package com.carloscaballero.debatech.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import com.carloscaballero.debatech.daos.interfaces.TemaDAO;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;

public class TemaDAONeodatis extends DAONeodatis<Tema> implements TemaDAO{
	
	public void responderTema(Tema tema, Mensaje mensaje){
		ODB odb = ODBFactory.open(DEBATECH_DB);
		IQuery queryTema = new CriteriaQuery(Tema.class, Where.equal("titulo", tema.getTitulo()));
		
		Objects<Tema> objetos = odb.getObjects(queryTema);
		
		Tema previo = (Tema) objetos.getFirst();
		
		previo.getMensajes().add(mensaje);
		odb.store(previo);
		odb.close();
	}

}
