package com.carloscaballero.debatech.presentacion.componentes;

import java.util.List;
import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.presentacion.paginas.PaginaTema;
import com.carloscaballero.debatech.servicios.manager.TemaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteTemas extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	public ComponenteTemas(){
		addComponent(new Label("Temas abiertos en esta escuela"));
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent(); 
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
			
		List<Tema> temas = TemaManager.getTemasDeEscuela(escuela);
		for (Tema tema:temas) {
			Button boton = new Button(tema.getTitulo());
			boton.addClickListener(e -> {
				irATema(tema);
			});
			addComponent(boton);
		}
	}
	
	private void irATema(Tema tema) {
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.setSesion("tema", tema);
		aplicacionUI.irPagina(PaginaTema.NAME);
	}
}
