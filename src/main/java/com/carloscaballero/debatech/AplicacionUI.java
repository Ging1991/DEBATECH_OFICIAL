package com.carloscaballero.debatech;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

import com.carloscaballero.debatech.presentacion.paginas.PaginaEscuela;
import com.carloscaballero.debatech.presentacion.paginas.PaginaPrincipal;
import com.carloscaballero.debatech.presentacion.paginas.PaginaTema;
import com.carloscaballero.debatech.presentacion.paginas.PaginaValidarUsuario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("debatema")
public class AplicacionUI extends UI {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> sesion;
	private Navigator navegador;
		
	@Override
    protected void init(VaadinRequest vaadinRequest) {
		sesion = new HashMap<String, Object> ();
		sesion.put("usuario", null);
		sesion.put("escuela", null);
		sesion.put("tema", null);
		navegador = new Navigator(this, this);
		navegador.addView(PaginaValidarUsuario.NAME, new PaginaValidarUsuario());
		navegador.addView(PaginaPrincipal.NAME, new PaginaPrincipal());
		navegador.addView(PaginaEscuela.NAME, new PaginaEscuela());
		navegador.addView(PaginaTema.NAME, new PaginaTema());
		navegador.navigateTo(PaginaPrincipal.NAME);
    }

	public void irPagina(String pagina) {
		navegador.navigateTo(pagina);
	}	
	
	public void setSesion(String clave, Object valor){
		sesion.put(clave, valor);
	}
	
	public Object getSesion(String clave){
		return sesion.get(clave);
	}
	
	public void recargarVista(String nombre, View vista) {
		navegador.addView(nombre, vista);
		irPagina(nombre);
	}
	
    @WebServlet(urlPatterns = "/*", name = "AplicacionUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AplicacionUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }
}
