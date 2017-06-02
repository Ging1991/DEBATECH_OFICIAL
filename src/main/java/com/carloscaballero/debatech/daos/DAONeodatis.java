package com.carloscaballero.debatech.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import com.carloscaballero.debatech.daos.interfaces.DAO;

public class DAONeodatis<T> implements DAO<T>{
	protected final String DEBATECH_DB = "pruebaDB1";
	
	public void guardar(T t){
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		odb.store(t);
		odb.close();
	}
	
	public void eliminar(T t){
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		odb.store(t);
		odb.close();
	}

	public void actualizar(T t) {
		System.out.println("-----------------ERROR ESTO NO DEBERIA IMPRIMIRSE DAONEODATIS ACTUALIZAR");
	}
}
