package com.carloscaballero.debatech.presentacion.paginas;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.presentacion.componentes.ComponenteCabecera;
import com.carloscaballero.debatech.presentacion.formularios.FormularioLogin;
import com.carloscaballero.debatech.presentacion.formularios.FormularioRegistrarUsuario;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaValidarUsuario extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static final String NAME = "PaginaValidarUsuario";
	
	public PaginaValidarUsuario(){
	}
	
	@Override
	public void enter(ViewChangeEvent event) {		
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.setSesion("usuario", null);
		
		removeAllComponents();
		addComponent(new ComponenteCabecera());
		
		addComponent(new Label("Validacion de usuarios: "));
		
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(new FormularioLogin());
		panel.setSecondComponent(new FormularioRegistrarUsuario());
		addComponent(panel);
	}
}
