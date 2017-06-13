package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.carloscaballero.debatech.presentacion.paginas.PaginaValidarUsuario;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteAfiliacion extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public ComponenteAfiliacion(){
		Button boton = new Button();
		
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent(); 
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		
		if (usuario==null) {
			boton.setCaption("Ingresar al sitio");
			boton.addClickListener(e -> {
				aplicacionUI.irPagina(PaginaValidarUsuario.NAME);
				});
		}
		
		if (usuario!=null && !EscuelaManager.estaAfiliado(usuario, escuela)) {
			boton.setCaption("Afiliarse a esta escuela");
			boton.addClickListener(e -> {
				EscuelaManager.afiliarUsuario(usuario, escuela);
				aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
				});
		}
		
		if (usuario!=null && EscuelaManager.estaAfiliado(usuario, escuela)) {
			boton.setCaption("Salirse de esta escuela");
			boton.addClickListener(e -> {
				EscuelaManager.desafiliarUsuario(usuario, escuela);
				aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
				});
		}
		
		addComponent(boton);
	}
	
}
