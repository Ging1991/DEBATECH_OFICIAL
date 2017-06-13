package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaTema;
import com.carloscaballero.debatech.servicios.manager.TemaManager;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FormularioCrearMensaje extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	private TextField inMensaje;
	
	public FormularioCrearMensaje(){
		Label lbTitulo = new Label("Responder a este tema");
		Label lbNombre = new Label("Su respuesta ");
		inMensaje = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Responder");
		btAceptar.addClickListener(e -> {
			responderTema();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 2);
		glInputs.addComponent(lbNombre, 0, 0);
		glInputs.addComponent(inMensaje, 1, 0);

		VerticalLayout vlPrincipal = new VerticalLayout();
		vlPrincipal.addComponent(lbTitulo);
		vlPrincipal.addComponent(glInputs);
		vlPrincipal.addComponent(btAceptar);
		vlPrincipal.setSizeFull();

		// seteo la alineacion
		glInputs.setComponentAlignment(lbNombre, Alignment.MIDDLE_CENTER);		
		glInputs.setComponentAlignment(inMensaje, Alignment.MIDDLE_CENTER);		
		
		vlPrincipal.setComponentAlignment(lbTitulo, Alignment.BOTTOM_CENTER);
		vlPrincipal.setComponentAlignment(glInputs, Alignment.MIDDLE_CENTER);
		vlPrincipal.setComponentAlignment(btAceptar, Alignment.TOP_CENTER);
		addComponent(vlPrincipal);
	}
	
	private void responderTema() {
		if (!validarCampos())
			return;
		
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Tema tema = (Tema) aplicacionUI.getSesion("tema");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		String respuesta = inMensaje.getValue();
		
		TemaManager.responderTema(tema, usuario, respuesta);
		aplicacionUI.recargarVista(PaginaTema.NAME, new PaginaTema());
	}
	
	private boolean validarCampos(){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Tema tema = (Tema) aplicacionUI.getSesion("tema");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		String respuesta = inMensaje.getValue();
		
		if (respuesta==null || respuesta.equals("")) {
			Notification.show("El campo respuesta no puede estar vacio");
			return false;
		}
		
		if (usuario==null) {
			Notification.show("Para responder al tema debe ingresar al sitio con su cuenta de usuario");
			return false;
		}
		
		if (tema==null) {
			Notification.show("Para responder al tema debe seleccionar un tema");
			return false;
		}
		
		if (TemaManager.haRespondido(tema, usuario)) {
			Notification.show("Ya ha respondido a este tema, solo se puede responder una vez");
			return false;
		}
		
		return true;		
	}

}