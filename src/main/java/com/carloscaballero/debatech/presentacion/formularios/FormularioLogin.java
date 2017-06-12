package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class FormularioLogin extends Panel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "FormularioLogin";
	private TextField inUsuario, inPassword;
	
	public FormularioLogin(){		
		super("Ingreso para usuarios registrados");
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inUsuario = new TextField("Usuario"));
		formulario.addComponent(inPassword = new TextField("Password"));
		
		Button btAceptar = new Button("Ingresar a debatech");
		btAceptar.addClickListener(e -> {
			loginUsuario();
		});
		formulario.addComponent(btAceptar);
		setContent(formulario);
		setWidthUndefined();
	}
	
	private void loginUsuario() {
		String usuario = inUsuario.getValue();
		String password = inPassword.getValue();
		EscuelaManager control = new EscuelaManager();
		
		try {
			if (control.estaRegistrado(usuario, password)) {
				AplicacionUI aplicacionUI = (AplicacionUI) getUI();
				aplicacionUI.setSesion("usuario", new Usuario(usuario, password));
				aplicacionUI.irPagina(PaginaPrincipal.NAME);
			}else {
				Notification.show("El usuario no esta registrado");
			}
			
		} catch (IllegalArgumentException e) {
			Notification.show(e.getMessage());
		}
	}

}
