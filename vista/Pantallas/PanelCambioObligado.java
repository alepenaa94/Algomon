package Pantallas;


import java.util.ArrayList;

import algomon.Algomon;
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
public class PanelCambioObligado {
		
		private GridPane grid;
		private PanelTurno pantalla;
		private TextArea display;
		private ArrayList lista;
		private ControladorJuego controlador;
		private TextField field;
		
		public PanelCambioObligado(PanelTurno pantalla, ArrayList lista,ControladorJuego controlador, PantallaJuego pantallaJuego){
			this.controlador=controlador;
			this.lista=lista;
			this.pantalla = pantalla;
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
				try{
					int a=0;
					a=Integer.parseInt(this.field.getText());
					insertarOpcionElegida(a);
					pantallaJuego.actualizarVistaAlgomon();
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
		
		private void insertarOpcionElegida(int parseInt) {
			if (parseInt<0 || parseInt>this.lista.size()){
				throw new NumberFormatException();
			}
			eleccion((Algomon)this.lista.get(parseInt-1));
			this.pantalla.finalizoEleccion();
		}

		public GridPane getPanel(){
			return this.grid;
		}
		
		public void setTexto(String string){
			this.display.setText(string);
		}


		private void eleccion(Algomon algomon){
			this.controlador.cambiarAlgomon(algomon);
		}
	
}
