package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.carloscaballero.debatech.servicios.manager.TemaManager;
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
	private TextField inTitulo;
	
	public FormularioCrearTema(){
		Label lbTitulo = new Label("Crear nuevo tema");
		
		Label lbNombre = new Label("Nombre del tema");
		inTitulo = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Crear tema");
		btAceptar.addClickListener(e -> {
			crearTema();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 2);
		glInputs.addComponent(lbNombre, 0, 0);
		glInputs.addComponent(inTitulo, 1, 0);

		VerticalLayout vlPrincipal = new VerticalLayout();
		vlPrincipal.addComponent(lbTitulo);
		vlPrincipal.addComponent(glInputs);
		vlPrincipal.addComponent(btAceptar);
		vlPrincipal.setSizeFull();

		// seteo la alineacion
		glInputs.setComponentAlignment(lbNombre, Alignment.MIDDLE_CENTER);		
		glInputs.setComponentAlignment(inTitulo, Alignment.MIDDLE_CENTER);		
		
		vlPrincipal.setComponentAlignment(lbTitulo, Alignment.BOTTOM_CENTER);
		vlPrincipal.setComponentAlignment(glInputs, Alignment.MIDDLE_CENTER);
		vlPrincipal.setComponentAlignment(btAceptar, Alignment.TOP_CENTER);
		addComponent(vlPrincipal);
	}
	
	private void crearTema() {
		if (!validarCampos())
			return;

		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		String titulo = inTitulo.getValue();
		
		TemaManager.crearTema(titulo, usuario, escuela);
		aplicacionUI.recargarVista(PaginaEscuela.NAME, new PaginaEscuela());
	}
	
	private boolean validarCampos(){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		String titulo = inTitulo.getValue();
		
		if (titulo==null || titulo.equals("")) {
			Notification.show("El titulo no puede estar vacia");
			return false;
		}
		
		if (escuela==null) {
			Notification.show("Para crear un tema debe hacerlo desde una escuela");
			return false;
		}

		if (usuario==null) {
			Notification.show("Para crear un tema debe iniciar sesion");
			return false;
		}

		return true;		
	}

}