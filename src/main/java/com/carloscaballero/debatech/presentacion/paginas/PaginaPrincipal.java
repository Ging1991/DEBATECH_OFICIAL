package com.carloscaballero.debatech.presentacion.paginas;

import com.carloscaballero.debatech.presentacion.componentes.ComponenteCabecera;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteEscuelas;
import com.carloscaballero.debatech.presentacion.formularios.FormularioCrearEscuela;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static final String NAME = "PaginaPrincipal";
	
	public PaginaPrincipal() {
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		setWidth("100%");
		setHeight("200%");
		setMargin(false);
		setMargin(new MarginInfo(false, true, true, true));

		ComponenteCabecera cabecera = new ComponenteCabecera(); 
		addComponent(cabecera);
		setComponentAlignment(cabecera, Alignment.TOP_CENTER);		
		
		ComponenteEscuelas componenteEscuelas = new ComponenteEscuelas();
		addComponent(componenteEscuelas);
		setComponentAlignment(componenteEscuelas, Alignment.TOP_LEFT);
		
		addComponent(new FormularioCrearEscuela());
	}

}
