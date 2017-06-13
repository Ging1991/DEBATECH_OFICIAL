package com.carloscaballero.debatech.daos;

import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import com.carloscaballero.debatech.daos.interfaces.TemaDAO;
import com.carloscaballero.debatech.modelo.Contador;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;

public class TemaDAONeodatis extends DAONeodatis<Tema> implements TemaDAO{

	public Integer nextTemaID() {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Contador> contadorOBJ = odb.getObjects(Contador.class);

		Contador contador;
		if (contadorOBJ.isEmpty())
			contador = new Contador();
		else
			contador = contadorOBJ.getFirst();
		
		Integer temaID = contador.getTemaID();
		odb.store(contador);
		odb.close();
		return temaID;
	}
	
	public Integer nextMensajeID() {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Contador> contadorOBJ = odb.getObjects(Contador.class);

		Contador contador;
		if (contadorOBJ.isEmpty())
			contador = new Contador();
		else
			contador = contadorOBJ.getFirst();
		
		Integer mensajeID = contador.getMensajaeID();
		odb.store(contador);
		odb.close();
		return mensajeID;
	}
	
	public boolean haRespondido(Integer usuarioID, Integer temaID){
		return true;
	}
	
	public List<Tema> getTemasDeEscuela(Integer escuelaID){
		ODB odb = ODBFactory.open(DEBATECH_DB);
		IQuery query = new CriteriaQuery(Tema.class, Where.equal("escuelaID", escuelaID));
		Objects<Tema> temasOBJ = odb.getObjects(query);
		List<Tema> temas = new ArrayList<Tema>();
				
		for (Tema temaActual : temasOBJ) {
			temaActual = temasOBJ.next();
			temas.add(temaActual);
		}
		
		odb.close();
		return temas;
	}
	
	public List<Mensaje> getMensajesDeTema(Integer temaID) {
	ODB odb = ODBFactory.open(DEBATECH_DB);
	IQuery query = new CriteriaQuery(Mensaje.class, Where.equal("temaID", temaID));
	Objects<Mensaje> mensajesOBJ = odb.getObjects(query);
	List<Mensaje> mensajes = new ArrayList<Mensaje>();
			
	for (Mensaje mensajeActual : mensajesOBJ) {
		mensajeActual = mensajesOBJ.next();
		mensajes.add(mensajeActual);
	}
	
	odb.close();
	return mensajes;
}

	

}
