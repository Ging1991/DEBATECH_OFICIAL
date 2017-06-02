package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.carloscaballero.debatech.servicios.DebatechController;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FormularioCrearTema extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	private TextField tfNombre;
	
	public FormularioCrearTema(){
		Label lbTitulo = new Label("Crear nuevo tema");
		
		Label lbNombre = new Label("Nombre del tema");
		tfNombre = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Crear tema");
		btAceptar.addClickListener(e -> {
			crearTema();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 2);
		glInputs.addComponent(lbNombre, 0, 0);
		glInputs.addComponent(tfNombre, 1, 0);

		VerticalLayout vlPrincipal = new VerticalLayout();
		vlPrincipal.addComponent(lbTitulo);
		vlPrincipal.addComponent(glInputs);
		vlPrincipal.addComponent(btAceptar);
		vlPrincipal.setSizeFull();

		// seteo la alineacion
		glInputs.setComponentAlignment(lbNombre, Alignment.MIDDLE_CENTER);		
		glInputs.setComponentAlignment(tfNombre, Alignment.MIDDLE_CENTER);		
		
		vlPrincipal.setComponentAlignment(lbTitulo, Alignment.BOTTOM_CENTER);
		vlPrincipal.setComponentAlignment(glInputs, Alignment.MIDDLE_CENTER);
		vlPrincipal.setComponentAlignment(btAceptar, Alignment.TOP_CENTER);
		addComponent(vlPrincipal);
	}
	
	private void crearTema() {
		String nombre = tfNombre.getValue();
		DebatechController control = new DebatechController();
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		
		try {
			control.crearTema(escuela, usuario, nombre);
			aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
		} catch (IllegalArgumentException e) {
			Notification.show(e.getMessage());
			return;
		}
	}
	
}
