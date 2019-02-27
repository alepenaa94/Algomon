package Aplicacion;

import Pantallas.NavegadorPantallas;
import Pantallas.PantallaInicial;
import Pantallas.PantallaJuego;
import Pantallas.PantallaSeleccion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juego.ControladorJuego;

public class Juego extends Application {
	
	private Stage ventanaPrincipal;
	private NavegadorPantallas navegador;

	
	@Override
	public void start(Stage primaryStage) {
		this.ventanaPrincipal = primaryStage;
		this.ventanaPrincipal.setTitle("AlgoMon");
		this.navegador = new NavegadorPantallas();
		ControladorJuego controlador = new ControladorJuego();
		
		
		PantallaInicial bienvenida = new PantallaInicial(this.navegador,this.ventanaPrincipal,controlador);
		bienvenida.setId("bienvenida");
		PantallaSeleccion seleccion = new PantallaSeleccion(this.navegador,this.ventanaPrincipal,controlador);
		seleccion.setId("seleccion");
		
		this.navegador.agregarPantalla("Inicio", bienvenida.getRoot());
		this.navegador.agregarPantalla("Seleccion", seleccion.getRoot());

		Scene escena = new Scene(this.navegador.getPantalla(), 800, 600);
		escena.getStylesheets().addAll(this.getClass().getResource("estilos.css").toExternalForm());

		this.ventanaPrincipal.setScene(escena);
		this.ventanaPrincipal.show();
		
		this.navegador.cargarPantalla("Inicio");
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	
//	String musicFile = "StayTheNight.mp3";     // For example
//
//	Media sound = new Media(new File(musicFile).toURI().toString());
//	MediaPlayer mediaPlayer = new MediaPlayer(sound);
//	mediaPlayer.play();
//	
//	
	
	
	
	
	
	
	
}