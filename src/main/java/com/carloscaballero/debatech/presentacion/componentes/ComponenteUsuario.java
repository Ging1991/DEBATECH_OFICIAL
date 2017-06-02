package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaValidarUsuario;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteUsuario extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public ComponenteUsuario (){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		if (usuario != null) {
			addComponent(new Label("Has ingresado como: "+usuario.getNombre()));
		}
		else {
			Button button = new Button("ingresar al sitio");
			button.addClickListener(e -> {
				aplicacionUI.irPagina(PaginaValidarUsuario.NAME);
				});
			addComponent(button);
		}
	}
	
}