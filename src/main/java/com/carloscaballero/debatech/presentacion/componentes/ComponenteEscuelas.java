package com.carloscaballero.debatech.presentacion.componentes;

import java.util.List;
import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.daos.EscuelaDAONeodatis;
import com.carloscaballero.debatech.daos.interfaces.EscuelaDAO;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class ComponenteEscuelas extends VerticalLayout implements View {	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "ComponenteEscuelas";
	
	public ComponenteEscuelas (){
		EscuelaDAO dao = new EscuelaDAONeodatis();
		List<Escuela> escuelas = dao.traerEscuelas();
		
		for (Escuela escuela:escuelas) {
			Button boton = new Button(escuela.getTitulo());
			boton.addClickListener(e -> {
				irAEscuela(escuela);
			});
			addComponent(boton);
		}	
	}
	
	private void irAEscuela(Escuela escuela) {
		AplicacionUI aplicacionUI = (AplicacionUI) getUI();
		aplicacionUI.setSesion("escuela", escuela);
		aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
		aplicacionUI.irPagina(PaginaEscuela.NAME);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
