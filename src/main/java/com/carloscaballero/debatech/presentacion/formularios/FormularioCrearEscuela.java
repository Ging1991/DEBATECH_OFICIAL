package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class FormularioCrearEscuela extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inNombre, inDescripcion;
	
	public FormularioCrearEscuela(){
		super("Crear escuela");
		FormLayout formulario = new FormLayout();
		formulario.setSizeUndefined();
		formulario.addComponent(inNombre = new TextField("Nombre"));
		formulario.addComponent(inDescripcion = new TextField("Descripcion"));
		
		Button btAceptar = new Button("Crear escuela");
		btAceptar.addClickListener(e -> {
			crearEscuela();
		});
		formulario.addComponent(btAceptar);
		
		setContent(formulario);
		setWidthUndefined();
	}
	
	private void crearEscuela() {
		if (!validarCampos())
			return;
		
		String nombre = inNombre.getValue();
		String descripcion = inDescripcion.getValue();
		EscuelaManager.crearEscuela(nombre, descripcion);

		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		aplicacionUI.recargarVista(PaginaPrincipal.NAME, new PaginaPrincipal());
		aplicacionUI.irPagina(PaginaPrincipal.NAME);
	}
	
	private boolean validarCampos(){
		String nombre = inNombre.getValue();
		if (nombre==null || nombre.equals("")) {
			Notification.show("El nombre de la escuela no puede estar vacio");
			return false;
		}
		
		if (EscuelaManager.nombreDeEscuelaOcupado(nombre)) {
			Notification.show("Ya existe una escuela con el nombre: "+nombre);
			return false;
		}
	
		String descripcion = inDescripcion.getValue();
		if (descripcion==null || descripcion.equals("")) {
			Notification.show("La descripcion de la escuela no puede estar vacia");
			return false;
		}
		
		return true;		
	}

}
