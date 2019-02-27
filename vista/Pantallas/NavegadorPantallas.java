package Pantallas;
import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class NavegadorPantallas {
	
	private StackPane ventana;
	private HashMap<String, Parent> pantallas;
	
	public NavegadorPantallas() {
		this.ventana = new StackPane();
		this.pantallas = new HashMap<String, Parent>();
	}
	
	public void agregarPantalla(String nombre, Parent pantalla) {
		this.pantallas.put(nombre, pantalla);
	}
	
	public void cargarPantalla(String nombre) {

        if ( !this.ventana.getChildren().isEmpty() )
        	this.ventana.getChildren().remove(0);

        this.ventana.getChildren().add(0, pantallas.get(nombre));
	}
	
	public StackPane getPantalla() {
		return this.ventana;
	}
	
}