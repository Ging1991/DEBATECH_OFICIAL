package com.carloscaballero.debatech.presentacion.paginas;

import com.carloscaballero.debatech.presentacion.componentes.ComponenteCabecera;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteMensajes;
import com.carloscaballero.debatech.presentacion.formularios.FormularioCrearMensaje;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class PaginaTema extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static final String NAME = "PaginaTema";
	
	public PaginaTema(){
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(new ComponenteCabecera());
		addComponent(new ComponenteMensajes());
		addComponent(new FormularioCrearMensaje());
	}
}
