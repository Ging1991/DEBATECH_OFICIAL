package com.carloscaballero.debatech.daos;

import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import com.carloscaballero.debatech.daos.interfaces.EscuelaDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;

public class EscuelaDAONeodatis extends DAONeodatis<Escuela> implements EscuelaDAO{
	
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

	@Override
	public boolean nombreTomado(String nombre) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Escuela> escuelas = odb.getObjects(Escuela.class);
		boolean registrado = false;
		
		for (Escuela escuela: escuelas) {
			escuela = escuelas.next();
			if (escuela.getTitulo().equals(nombre))
				registrado = true;
		}
		
		odb.close();
		return registrado;
	}

	public void actualizar(Escuela escuela){
	}

	@Override
	public void afiliarUsuario(Escuela escuela, Usuario usuario) {
		ODB odb = ODBFactory.open(DEBATECH_DB);
		
		IQuery queryEscuela = new CriteriaQuery(Escuela.class, Where.equal("titulo", escuela.getTitulo()));
		IQuery queryUsuario = new CriteriaQuery(Usuario.class, Where.equal("nombre", usuario.getNombre()));
		
		Escuela escuelaGuardada = (Escuela) odb.getObjects(queryEscuela).getFirst();
		Usuario usuarioGuardado = (Usuario) odb.getObjects(queryUsuario).getFirst();
		
		escuelaGuardada.getAfiliados().add(usuarioGuardado);
		
		odb.store(escuelaGuardada);
		odb.close();
	}

	@Override
	public void crearTema(Escuela escuela, Tema tema) {
		ODB odb = ODBFactory.open(DEBATECH_DB);
		IQuery queryEscuela = new CriteriaQuery(Escuela.class, Where.equal("titulo", escuela.getTitulo()));
		Escuela escuelaGuardada = (Escuela) odb.getObjects(queryEscuela).getFirst();
		
		escuelaGuardada.getTemas().add(tema);
		odb.store(escuelaGuardada);
		odb.close();
	}
	
	
	
	
	

}
