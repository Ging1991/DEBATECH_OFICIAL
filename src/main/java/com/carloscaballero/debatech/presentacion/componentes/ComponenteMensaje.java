package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Escuela;
import com.carloscaballero.debatech.modelo.Mensaje;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.servicios.manager.MensajeManager;
import com.carloscaballero.debatech.servicios.manager.UsuarioManager;
import com.carloscaballero.debatech.servicios.manager.VotoManager;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteMensaje extends Panel{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public ComponenteMensaje(Mensaje mensaje) {
		super("Respuestas");
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		
		Usuario autor = UsuarioManager.getUsuario(mensaje.getUsuarioID());
		Label nombre = new Label(autor.getNombre());
		Escuela escuela = MensajeManager.getEscuelaDeMensaje(mensaje);
		Integer cantidadDeVotos = VotoManager.getCantidadDeVotos(escuela, autor);
		Image imagen = new Image(null, new ClassResource("/avatar.png"));
		
		VerticalLayout panelUsuario = new VerticalLayout();
		panelUsuario.addComponent(imagen);
		panelUsuario.addComponent(nombre);
		panelUsuario.addComponent(new Label(cantidadDeVotos+" votos en esta escuela"));
		
		if (usuario!= null) {
			if (!VotoManager.haVotadoAEsteUsuario(escuela, usuario, autor)){
				Button votar = new Button("Votar como representante");
				votar.addClickListener(e -> {
					VotoManager.votarRepresentante(escuela, usuario, autor);
				});
				panelUsuario.addComponent(votar);
			}
		}
				
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(panelUsuario);
		panel.setSecondComponent(new Label(mensaje.getTexto()));
		panel.setSplitPosition(20, Sizeable.UNITS_PERCENTAGE);
		setContent(panel);
	}
}
