package com.carloscaballero.debatech.servicios.manager;

import com.carloscaballero.debatech.daos.DAONeodatis;
import com.carloscaballero.debatech.daos.EscuelaDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.DAO;
import com.carloscaballero.debatech.daos.interfaces.EscuelaDAO;
import com.carloscaballero.debatech.modelo.Afiliacion;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;

public class EscuelaManager {

	public static boolean nombreDeEscuelaOcupado(String nombre) {
		EscuelaDAO dao = new EscuelaDAONeodatis();
		return dao.nombreDeEscuelaOcupado(nombre);
	}

	public static void crearEscuela(String nombre, String descripcion) {
		if (nombreDeEscuelaOcupado(nombre))
			throw new IllegalArgumentException("Ya existe una escuela con el nombre: "+nombre);
		
		EscuelaDAO dao = new EscuelaDAONeodatis();
		Escuela escuela = new Escuela(dao.nextEscuelaID(), nombre, descripcion);
		dao.guardar(escuela);		
	}
		
	public static void afiliarUsuario(Usuario usuario, Escuela escuela) {
		if (estaAfiliado(usuario, escuela))
			throw new IllegalArgumentException("El usuario ya estaba afiliado a esta escuela");
		
		Afiliacion afiliacion = new Afiliacion(usuario.getID(), escuela.getID());
		DAO<Afiliacion> dao = new DAONeodatis<Afiliacion>();
		dao.guardar(afiliacion);
	}
	
	public static boolean estaAfiliado(Usuario usuario, Escuela escuela) {
		EscuelaDAO dao = new EscuelaDAONeodatis();
		return dao.estaAfiliado(usuario.getID(), escuela.getID());
	}
	
	public static void desafiliarUsuario(Usuario usuario, Escuela escuela) {
		//EscuelaDAO dao = new EscuelaDAONeodatis();
	}

	public static Escuela getEscuela(Integer escuelaID) {
		EscuelaDAO dao = new EscuelaDAONeodatis();
		return dao.getEscuela(escuelaID);
	}
	
	public static int getCantidadDeAfiliados(Escuela escuela) {
		
		return 0;
	}	
		
}
