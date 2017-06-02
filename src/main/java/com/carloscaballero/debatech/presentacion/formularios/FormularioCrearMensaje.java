package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaTema;
import com.carloscaballero.debatech.servicios.DebatechController;
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
	private TextField tfMensaje;
	
	public FormularioCrearMensaje(){
		Label lbTitulo = new Label("Responder a este tema");
		
		Label lbNombre = new Label("Su respuesta ");
		tfMensaje = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Responder");
		btAceptar.addClickListener(e -> {
			responderTema();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 2);
		glInputs.addComponent(lbNombre, 0, 0);
		glInputs.addComponent(tfMensaje, 1, 0);

		VerticalLayout vlPrincipal = new VerticalLayout();
		vlPrincipal.addComponent(lbTitulo);
		vlPrincipal.addComponent(glInputs);
		vlPrincipal.addComponent(btAceptar);
		vlPrincipal.setSizeFull();

		// seteo la alineacion
		glInputs.setComponentAlignment(lbNombre, Alignment.MIDDLE_CENTER);		
		glInputs.setComponentAlignment(tfMensaje, Alignment.MIDDLE_CENTER);		
		
		vlPrincipal.setComponentAlignment(lbTitulo, Alignment.BOTTOM_CENTER);
		vlPrincipal.setComponentAlignment(glInputs, Alignment.MIDDLE_CENTER);
		vlPrincipal.setComponentAlignment(btAceptar, Alignment.TOP_CENTER);
		addComponent(vlPrincipal);
	}
	
	private void responderTema() {
		String respuesta = tfMensaje.getValue();
		DebatechController control = new DebatechController();
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		//Escuela escuela = (Escuela) aplicacionUI.getSesion("escuela");
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		Tema tema = (Tema) aplicacionUI.getSesion("tema");
		try {
			control.crearMensaje(tema, usuario, respuesta);
			tema.getMensajes().add(new Mensaje(respuesta, usuario));
			aplicacionUI.recargarVista(PaginaTema.NAME, new PaginaTema());
		} catch (IllegalArgumentException e) {
			Notification.show(e.getMessage());
			return;
		}
	}
	
}
