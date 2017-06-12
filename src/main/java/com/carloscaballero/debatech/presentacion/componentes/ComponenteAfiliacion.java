package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteAfiliacion extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public ComponenteAfiliacion(){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent(); 
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		
		if (usuario==null) {
			addComponent(new Label("Debes iniciar sesion para afiliarte o desafiliarte a una escuela"));
			return;
		}
		
		EscuelaManager control = new EscuelaManager();
		if (!control.estaAfiliado(usuario, escuela)) {
			Button btAfiliacion = new Button("Afiliarse a esta escuela");
			btAfiliacion.addClickListener(e -> {
				control.afiliarseAEscuela(usuario, escuela);
				escuela.getAfiliados().add(usuario);
				aplicacionUI.setSesion("escuela", escuela);
				aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
				});
			addComponent(btAfiliacion);
		}
		else {
			Button btAfiliacion = new Button("Salirse de esta escuela");
			btAfiliacion.addClickListener(e -> {
				control.afiliarseAEscuela(usuario, escuela);
				aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
				});
			addComponent(btAfiliacion);
		}
	}
	
}
