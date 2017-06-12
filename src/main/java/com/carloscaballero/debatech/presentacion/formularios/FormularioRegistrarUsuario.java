package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FormularioRegistrarUsuario extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	private TextField tfUsuario, tfPassword, tfPasswordRepetido;
	
	public FormularioRegistrarUsuario(){
		Label lbTitulo = new Label("Registro de usuarios");
		Label lbUsuario = new Label("Ingrese su nombre de usuario ");
		Label lbPassword = new Label("Ingrese una password ");
		Label lbPasswordRepetido = new Label("Vuelva a ingresar la password ");
		tfUsuario = new TextField();
		tfPassword = new TextField();
		tfPasswordRepetido = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Registrarse en debatech");
		btAceptar.addClickListener(e -> {
			registrarUsuario();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 3);
		glInputs.addComponent(lbUsuario, 0, 0);
		glInputs.addComponent(tfUsuario, 1, 0);
		glInputs.addComponent(lbPassword, 0, 1);
		glInputs.addComponent(tfPassword, 1, 1);
		glInputs.addComponent(lbPasswordRepetido, 0, 2);
		glInputs.addComponent(tfPasswordRepetido, 1, 2);

		addComponent(lbTitulo);
		addComponent(glInputs);
		addComponent(btAceptar);
	}
	
	private void registrarUsuario() {
		String usuario = tfUsuario.getValue();
		String password = tfPassword.getValue();
		String passwordRepetido = tfPasswordRepetido.getValue();
		
		EscuelaManager control = new EscuelaManager();
		try {
			control.registrarUsuario(usuario, password, passwordRepetido);
		} catch (IllegalArgumentException e) {
			Notification.show(e.getMessage());
			return;
		}
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.irPagina(PaginaPrincipal.NAME);
	}

}
