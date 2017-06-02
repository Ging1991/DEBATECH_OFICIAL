package com.carloscaballero.debatech.daos.interfaces;

public interface DAO<T> {
		
	public void guardar(T t);

	public void eliminar(T t);

	public void actualizar(T t);
}
