package com.carloscaballero.debatech.daos.interfaces;

import java.util.List;

import com.carloscaballero.debatech.modelo.Escuela;

public interface EscuelaDAO extends DAO<Escuela>{

	public abstract boolean nombreDeEscuelaOcupado(String nombre);

	public abstract Integer nextEscuelaID();
	
	public abstract boolean estaAfiliado(Integer usuarioID, Integer escuelaID); 
	
	public abstract List<Escuela> traerEscuelas();
	
}