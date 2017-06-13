package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.UsuarioManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class FormularioLogin extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inNombre, inPassword;
	
	public FormularioLogin(){		
		super("Ingreso para usuarios registrados");
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inNombre = new TextField("Usuario"));
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
		if (!validarCampos())
			return;
		
		String nombre = inNombre.getValue();
		String password = inPassword.getValue();
		Usuario usuario = UsuarioManager.ingresarAlSitio(nombre, password);		
		
		if (usuario==null)
			Notification.show("Password incorrecta");
		else {			
			AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
			aplicacionUI.setSesion("usuario", usuario);
			aplicacionUI.irPagina(PaginaPrincipal.NAME);
		}
	}

	private boolean validarCampos(){
		String nombre = inNombre.getValue();
		if (nombre==null || nombre.equals("")) {
			Notification.show("El nombre de usuario no puede estar vacio");
			return false;
		}
		
		if (!UsuarioManager.nombreDeUsuarioOcupado(nombre)) {
			Notification.show("No existe una cuenta con el nombre: "+nombre);
			return false;
		}
	
		String password = inPassword.getValue();
		if (password==null || password.equals("")) {
			Notification.show("La password no puede estar vacia");
			return false;
		}
		
		return true;		
	}

}
