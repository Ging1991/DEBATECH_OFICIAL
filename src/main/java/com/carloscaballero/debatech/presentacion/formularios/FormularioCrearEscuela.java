package com.carloscaballero.debatech.presentacion.formularios;

import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.servicios.manager.EscuelaManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class FormularioCrearEscuela extends Panel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "FormularioCrearEscuela";
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
		String nombre = inNombre.getValue();
		String descripcion = inDescripcion.getValue();
		EscuelaManager control = new EscuelaManager();
		
		try {
			control.crearEscuela(nombre, descripcion);
			getUI().getNavigator().addView(PaginaPrincipal.NAME, new PaginaPrincipal());
			getUI().getNavigator().navigateTo(PaginaPrincipal.NAME);
		} catch (IllegalArgumentException e) {
			Notification.show(e.getMessage());
			return;
		}
	}

}
