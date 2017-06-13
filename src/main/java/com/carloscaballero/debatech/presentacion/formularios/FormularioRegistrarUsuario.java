package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.UsuarioManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FormularioRegistrarUsuario extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	private TextField inNombre, inPassword, inPasswordRepetido;
	
	public FormularioRegistrarUsuario(){
		Label lbTitulo = new Label("Registro de usuarios");
		Label lbUsuario = new Label("Ingrese su nombre de usuario ");
		Label lbPassword = new Label("Ingrese una password ");
		Label lbPasswordRepetido = new Label("Vuelva a ingresar la password ");
		inNombre = new TextField();
		inPassword = new TextField();
		inPasswordRepetido = new TextField();
		
		Button btAceptar = new Button();
		btAceptar.setCaption("Registrarse en debatech");
		btAceptar.addClickListener(e -> {
			registrarUsuario();
		});
		
		// los añado al layout
		GridLayout glInputs = new GridLayout(2, 3);
		glInputs.addComponent(lbUsuario, 0, 0);
		glInputs.addComponent(inNombre, 1, 0);
		glInputs.addComponent(lbPassword, 0, 1);
		glInputs.addComponent(inPassword, 1, 1);
		glInputs.addComponent(lbPasswordRepetido, 0, 2);
		glInputs.addComponent(inPasswordRepetido, 1, 2);

		addComponent(lbTitulo);
		addComponent(glInputs);
		addComponent(btAceptar);
	}
	
	private void registrarUsuario() {
		if (!validarCampos())
			return;
		
		String nombre = inNombre.getValue();
		String password = inPassword.getValue();
		
		Usuario usuario = UsuarioManager.crearUsuario(nombre, password);
		Notification.show("Se ha registrado exitosamente");

		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.setSesion("usuario", usuario);
		aplicacionUI.irPagina(PaginaPrincipal.NAME);
	}

	private boolean validarCampos(){
		String nombre = inNombre.getValue();
		if (nombre==null || nombre.equals("")) {
			Notification.show("El nombre de usuario no puede estar vacio");
			return false;
		}
		
		if (UsuarioManager.nombreDeUsuarioOcupado(nombre)) {
			Notification.show("Ya existe un usuario con el nombre: "+nombre);
			return false;
		}
	
		String password = inPassword.getValue();
		if (password==null || password.equals("")) {
			Notification.show("La password no puede estar vacia");
			return false;
		}
		
		if (!password.equals(inPasswordRepetido.getValue())) {
			Notification.show("La password no se ha repetido correctamente");
			return false;
		}
		
		return true;		
	}

}
