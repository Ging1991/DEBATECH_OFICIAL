package com.carloscaballero.debatech.presentacion.componentes;

import com.carloscaballero.debatech.AplicacionUI;
import com.carloscaballero.debatech.modelo.Usuario;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.presentacion.paginas.PaginaValidarUsuario;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteCabecera extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	public ComponenteCabecera (){
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		
		Image imagenDeCabecera = new Image(null, new ClassResource("/cabecera.jpg"));
		imagenDeCabecera.addClickListener(e -> {
			aplicacionUI.irPagina(PaginaPrincipal.NAME);
		});
		addComponent(imagenDeCabecera);
		setComponentAlignment(imagenDeCabecera, Alignment.TOP_CENTER);
		
		MenuBar barra = crearBarraMenu();
		addComponent(barra);
		setComponentAlignment(barra, Alignment.TOP_CENTER);
	}

	private MenuBar crearBarraMenu() {
		AplicacionUI aplicacionUI = (AplicacionUI) UI.getCurrent();
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		MenuBar barra = new MenuBar();

		// usuario como caso especial
		if (usuario==null) {
			MenuItem  usuarioItem = barra.addItem("Usuarios", null);
			usuarioItem.addItem("Ingresar", e -> {
				aplicacionUI.irPagina(PaginaValidarUsuario.NAME);
			});
		} else {
			MenuItem usuarioItem = barra.addItem("Bienvenido/a: "+usuario.getNombre(), null);
			usuarioItem.addItem("Perfil de usuario", null);
			usuarioItem.addItem("Cerrar sesion", null);
		}
			
		// agrego lo demas
		MenuItem escuelaItem = barra.addItem("Escuelas", null);		
		MenuItem temaItem = barra.addItem("Temas", null);
		MenuItem mensajeItem = barra.addItem("Mensajes", null);
		MenuItem debateItem = barra.addItem("Debates", null);
		
		escuelaItem.addItem("Ver todas", null);
		temaItem.addItem("Ver ultimos temas", null);
		mensajeItem.addItem("ver ultimos mensajes", null);
		debateItem.addItem("Ver ultimos debates", null);

		if (usuario!=null) {
			escuelaItem.addItem("Ver mis escuelas", null);
			temaItem.addItem("Mis temas", null);
			mensajeItem.addItem("ver mis mensajes", null);
			debateItem.addItem("Crear debate", null);			
		}
		
		return barra;
	}

}
