package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteCabecera extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	public ComponenteCabecera (){
		Image imagen = new Image(null, new ClassResource("/cabecera.jpg"));
		imagen.addClickListener(e -> {
			irPaginaPrincipal();
		});
		addComponent(imagen);
		setComponentAlignment(imagen, Alignment.TOP_CENTER);
	}
	
	private void irPaginaPrincipal() {
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.irPagina(PaginaPrincipal.NAME);
	}

}
