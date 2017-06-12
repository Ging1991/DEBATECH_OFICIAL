package com.carloscaballero.debatech.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import com.carloscaballero.debatech.daos.interfaces.UsuarioDAO;
import com.carloscaballero.debatech.modelo.Contador;
import com.carloscaballero.debatech.modelo.Usuario;

public class UsuarioDAONeodatis extends DAONeodatis<Usuario> implements UsuarioDAO{

	@Override
	public boolean nombreDeUsuarioOcupado(String nombre) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		IQuery query = new CriteriaQuery(Usuario.class, Where.equal("nombre", nombre));
		Objects<Usuario> usuarios = odb.getObjects(query);
		
		boolean ocupado = true;
		if (usuarios.isEmpty())
			ocupado = false;
		
		odb.close();
		return ocupado;
	}
	
	public Integer nextUsuarioID() {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		Objects<Contador> contadorOBJ = odb.getObjects(Contador.class);

		Contador contador;
		if (contadorOBJ.isEmpty())
			contador = new Contador();
		else
			contador = contadorOBJ.getFirst();
		
		Integer usuarioID = contador.getUsuarioID();
		odb.store(contador);
		odb.close();
		return usuarioID;
	}
	
	public Usuario getUsuario(String nombre, String password) {
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		IQuery query = new CriteriaQuery(Usuario.class, Where.equal("nombre", nombre));
		Objects<Usuario> usuariosOBJ = odb.getObjects(query);
		
		Usuario usuario = null;
		if (!usuariosOBJ.isEmpty())
			usuario = (Usuario) usuariosOBJ.getFirst();
		
		odb.close();
		return usuario;
	}
	
	public Usuario getUsuario(Integer usuarioID) {	
		ODB odb  = ODBFactory.open(DEBATECH_DB);
		IQuery query = new CriteriaQuery(Usuario.class, Where.equal("ID", usuarioID));
		Objects<Usuario> usuariosOBJ = odb.getObjects(query);
		
		Usuario usuario = null;
		if (!usuariosOBJ.isEmpty())
			usuario = (Usuario) usuariosOBJ.getFirst();
		
		odb.close();
		return usuario;
	}
	
}
