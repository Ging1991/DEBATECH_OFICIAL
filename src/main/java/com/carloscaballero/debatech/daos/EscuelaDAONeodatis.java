package com.carloscaballero.debatech.daos;

import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.core.query.nq.SimpleNativeQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import com.carloscaballero.debatech.daos.interfaces.EscuelaDAO;
import com.carloscaballero.debatech.modelo.Afiliacion;
import com.carloscaballero.debatech.modelo.Contador;
import com.carloscaballero.debatech.modelo.Escuela;

public class EscuelaDAONeodatis extends DAONeodatis<Escuela> implements EscuelaDAO{
	
	@Override
	public boolean nombreDeEscuelaOcupado(String nombre) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		IQuery query = new CriteriaQuery(Escuela.class, Where.equal("nombre", nombre));
		Objects<Escuela> escuelasOBJ = odb.getObjects(query);
		
		boolean ocupado = true;
		if (escuelasOBJ.isEmpty())
			ocupado = false;
		
		odb.close();
		return ocupado;
	}

	public Integer nextEscuelaID(){
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Contador> contadorOBJ = odb.getObjects(Contador.class);

		Contador contador;
		if (contadorOBJ.isEmpty())
			contador = new Contador();
		else
			contador = contadorOBJ.getFirst();
		
		Integer escuelaID = contador.getEscuelaID();
		odb.store(contador);
		odb.close();
		return escuelaID;
	}
	
	public boolean estaAfiliado(Integer usuarioID, Integer escuelaID){
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		
		SimpleNativeQuery query = new SimpleNativeQuery() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unused")
			public boolean match(Afiliacion afiliacion) {
            	boolean usuario = (afiliacion.getUsuarioID().equals(usuarioID));
            	boolean escuela = (afiliacion.getEscuelaID().equals(escuelaID));
            	return (usuario && escuela);
            }
        };
		
		Objects<Afiliacion> escuelasOBJ = odb.getObjects(query);
		odb.close();
		
		boolean ocupado = true;
		if (escuelasOBJ.isEmpty())
			ocupado = false;
		
		return ocupado;
	}
	
	@Override
	public List<Escuela> traerEscuelas() {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Escuela> objetos = odb.getObjects(Escuela.class);
		List<Escuela> escuelas = new ArrayList<Escuela>();
		for (Escuela escuelActual: objetos) {
			escuelActual = objetos.next();
			escuelas.add(escuelActual);
		}
		
		odb.close();
		return escuelas;
	}

	public void actualizar(Escuela escuela){
	}

}