package com.carloscaballero.debatech.daos.interfaces;

import java.util.List;

import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;

public interface EscuelaDAO extends DAO<Escuela>{

	public abstract List<Escuela> traerEscuelas();
	
	public abstract boolean nombreTomado(String nombre);

	public void afiliarUsuario(Escuela escuela, Usuario usuario);
	
	public void crearTema(Escuela escuela, Tema tema);
}
