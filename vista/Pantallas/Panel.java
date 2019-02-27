package Pantallas;

import java.util.ArrayList;

import algomon.Algomon;
import algomon.ErrorAlgomonMuerto;
import algomon.ErrorAtaqueImposible;
import ataque.Ataque;
import ataque.ErrorAtaqueDesconocido;
import ataque.ErrorCantidadAtaque;
import elemento.Elemento;
import elemento.ErrorCantidadInsuficiente;
import javafx.animation.PauseTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import juego.ControladorJuego;
import jugador.ErrorCambioAlgomonEsActivo;

public class Panel {
	
	private GridPane grid;
	private PanelTurno pantalla;
	private TextArea display;
	private ArrayList lista;
	private ControladorJuego controlador;
	private TextField field;
	private PantallaJuego pantallaJuego;
	private boolean juegoTerminado=false;
	
	
	public Panel(PanelTurno pantalla, ArrayList lista,ControladorJuego controlador, PantallaJuego pantallaJuego){
		this.controlador=controlador;
		this.lista=lista;
		this.pantalla = pantalla;
		this.pantallaJuego = pantallaJuego;
		this.grid = new GridPane();
		grid.setPadding(new Insets(5));
	  	grid.setAlignment(Pos.BOTTOM_CENTER);
	  	grid.setHgap(5);
	   	grid.setVgap(5);
	   	
        this.display = new TextArea();
        this.display.setPrefRowCount(4);
        this.display.setPrefColumnCount(32);
        this.display.setWrapText(true);
        this.display.setEditable(false);
        GridPane.setHalignment(this.display, HPos.LEFT);
        grid.add(this.display, 0, 1);
        
        
        this.field = new TextField();
        this.field.setPrefWidth(60);
        this.field.setPromptText("N°:");
		grid.add(this.field,3,1);
		
		Button boton4 = new Button("Insertar");
		boton4.setOnAction(e -> {
			//Logica de opcion elegida...
			try{
				int a=0;
				a=Integer.parseInt(this.field.getText());
				insertarOpcionElegida(a);
				if(!this.juegoTerminado){
					pantallaJuego.actualizarVistaAlgomon();
				}
			}catch (NumberFormatException e1) {
				// TODO: handle exception
				AvisoPopup popup = new AvisoPopup("Ingrese nuevamente un parametro valido!");
				popup.setDuracion(2);
				popup.ejecutar();
				this.field.clear();
			}
			
			
		});
		
		grid.add(boton4, 4, 1);
	}
	
	public GridPane getPanel(){
		return this.grid;
	}
	
	public void setTexto(String string){
		this.display.setText(string);
	}

	
	public void insertarOpcionElegida(int a){
		if (a<0 || a>this.lista.size()){
			throw new NumberFormatException();
		}
		if (this.lista.get(a-1) instanceof Ataque){
			eleccion((Ataque)this.lista.get(a-1));
			
			return;
		}
		if (this.lista.get(a-1) instanceof Elemento){
			eleccion((Elemento)this.lista.get(a-1));
			return;
		}
		eleccion((Algomon)this.lista.get(a-1));		
	}
	
	private void eleccion(Elemento elemento){
		try{
			this.controlador.usarElemento(elemento);
		}catch (ErrorCantidadInsuficiente e) {
			// TODO: handle exception
			AvisoPopup popup = new AvisoPopup("Cantidad de Elemento insuficiente");
			popup.ejecutar();
			this.field.clear();
			return;
		}catch(ErrorAlgomonMuerto e){
			this.pantalla.setComentario("El algomon "+ this.controlador.getAlgomonActivo(this.controlador.getJugadorActual())+" murio, se elige el proximo disponible.\n");
			this.controlador.proximoAlgomonVivo();
			finalizarEleccion();
			return;
		}
		this.pantalla.setComentario("Se le aplica al algomon el elemento " +elemento +"\n");
		finalizarEleccion();
	}
	private void eleccion(Ataque ataque){
		try {
			this.controlador.atacarCon(ataque);
		} catch (ErrorCantidadAtaque e) {
			AvisoPopup popup = new AvisoPopup("Cantidad de Ataque insuficiente");
			popup.ejecutar();
			this.field.clear();
			return;
		}catch(ErrorAtaqueImposible e){
			this.pantalla.setComentario("El algomon no puede atacar esta dormido y pierde el turno.\n");
			this.pantalla.setCambioObligado();
			finalizarEleccion();
			return;
		}catch(ErrorAlgomonMuerto e){
			this.pantalla.setComentario("El algomon "+ this.controlador.getAlgomonActivo(this.controlador.getJugadorActual())+" murio, se elige el proximo disponible.\n");
			this.controlador.proximoAlgomonVivo();
			finalizarEleccion();
			return;
		}
		
		
		this.pantalla.setComentario("Se realiza el ataque " +ataque+"\n");
		finalizarEleccion();
	}
	private void eleccion(Algomon algomon){
		try {
			this.controlador.cambiarAlgomon(algomon);
		} catch (ErrorCambioAlgomonEsActivo e) {
			// Algomon activo
			AvisoPopup popup = new AvisoPopup("El algomon es el activo");
			popup.ejecutar();
			this.field.clear();
			return;
		}
		this.pantalla.setComentario("Se cambio el algomon activo al algomon " +algomon+"\n");
		finalizarEleccion();
	}
	
	private void finalizarEleccion(){
		this.pantalla.finalizoEleccion();
		avanzarTurno();
	}

	private void avanzarTurno() {
		this.controlador.avanzarTurno();
		if(this.controlador.esJuegoTerminado()){
			this.pantallaJuego.juegoTerminado();
			this.juegoTerminado = true;
			return;
		}
		AvisoPopup popup = new AvisoPopup("Turno de:  "+this.controlador.getNombreJugadorActual());
		popup.setDuracion(1.2);
		popup.ejecutar();
		if (this.controlador.requiereCambioAlgomonActivo(this.controlador.getJugadorActual())){
			this.pantalla.setCambioObligado();
		}
		
	}
	
	

	
}










