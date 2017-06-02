package com.carloscaballero.debatech.presentacion.paginas;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteAfiliacion;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteCabecera;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteTemas;
import com.carloscaballero.debatech.presentacion.formularios.FormularioCrearTema;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaEscuela extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static final String NAME = "PaginaEscuela";
	
	public PaginaEscuela(){
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(new ComponenteCabecera());
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent(); 
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		addComponent(new Label("Nombre de escuela: "+escuela.getTitulo()));
		addComponent(new ComponenteAfiliacion());
		addComponent(new ComponenteTemas());
		addComponent(new FormularioCrearTema());
	}
}
