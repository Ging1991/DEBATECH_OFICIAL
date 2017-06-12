package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.modelo.Mensaje;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class ComponenteMensaje extends Panel{
	private static final long serialVersionUID = 1L;

	public ComponenteMensaje(Mensaje mensaje) {
		super("Respuesta 1");
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(new Label(mensaje.getUsuario().getNombre()));
		panel.setSecondComponent(new Label(mensaje.getTexto()));
	}
}
