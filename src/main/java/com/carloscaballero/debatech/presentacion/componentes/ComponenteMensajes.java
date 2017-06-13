package com.carloscaballero.debatech.presentacion.componentes;

import java.util.List;
import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Tema;
import com.carloscaballero.debatech.servicios.manager.TemaManager;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteMensajes extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	public ComponenteMensajes (){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Tema tema = (Tema) aplicacionUI.getSesion("tema");
		
		addComponent(new Label(tema.getTitulo()));
		List<Mensaje> mensajes = TemaManager.getMensajesDeTema(tema);
	
		for (Mensaje mensaje:mensajes)
			addComponent(new ComponenteMensaje(mensaje));
		
	}
}
