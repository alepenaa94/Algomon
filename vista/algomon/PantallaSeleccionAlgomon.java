package algomon;

import java.util.ArrayList;
import java.util.Iterator;

import Pantallas.AvisoPopup;
import Pantallas.NavegadorPantallas;
import Pantallas.Pantalla;
import Pantallas.PantallaJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import juego.ControladorJuego;
import pantallaSeleccionAlgomon.Contador;

public class PantallaSeleccionAlgomon extends Pantalla{

	private ArrayList<PanelJugador> jugadores ;
	private BorderPane pane;
	private PanelConfirmacion panelConfirmacion;
	private PanelInformacion panelInformacion;
	private Group algomonYaElegido,comenzarJuego;
	private Contador contador;
	
	public PantallaSeleccionAlgomon(NavegadorPantallas navegador,Stage stage,ControladorJuego controlador) {
		super(navegador,stage,controlador);
	}
	
	@Override
	public Parent crearLayout() {
		this.jugadores = new ArrayList<PanelJugador>();
		this.contador = new Contador();
		this.pane = new BorderPane();
		this.pane.setCenter( algomones() );
		this.pane.setTop( jugadores() );
		this.pane.setBottom( this.panelInferior() );
		this.panelInformacion = new PanelInformacion(this.getControlador());
		this.pane.setRight( this.panelInformacion );
		return this.pane;
	}
	
	private StackPane panelInferior() {		
		Button botonAtras = new Button("Atrás");
		botonAtras.setOnAction(e -> {
			this.getControlador().limpiarSeleccionAlgomon();
			this.irAPantalla("Seleccion");
		});
		
		this.panelConfirmacion = new PanelConfirmacion(this,this.getControlador(),contador);
		this.panelConfirmacion.setVisible(false);
		
		this.algomonYaElegido = algomonYaElegido();
		this.algomonYaElegido.setVisible(false);
		
		this.comenzarJuego = comenzarJuego();
		this.comenzarJuego.setVisible(false);
		
		StackPane panelInferior = new StackPane();
		panelInferior.setPadding(new Insets(0, 0, 10, 10));
		panelInferior.setAlignment(Pos.BOTTOM_CENTER);
		panelInferior.setAlignment(this.panelConfirmacion, Pos.BOTTOM_CENTER);
		panelInferior.setAlignment(this.algomonYaElegido, Pos.BOTTOM_CENTER);
		panelInferior.setAlignment(this.comenzarJuego, Pos.BOTTOM_CENTER);
		panelInferior.setAlignment(botonAtras, Pos.BOTTOM_LEFT);
		panelInferior.getChildren().addAll(this.panelConfirmacion,this.algomonYaElegido,this.comenzarJuego,botonAtras);
		
		return panelInferior;
	}

	private Group comenzarJuego() {
		Group pane = new Group();
		Button boton = new Button("Comenzar Juego");
		boton.setOnAction(e -> {
			PantallaJuego juego = new PantallaJuego(this.getNavegador(),this.getStage(),this.getControlador());
			juego.setId("juego");
			this.getNavegador().agregarPantalla("Juego", juego.getRoot());
			this.irAPantalla("Juego");
			AvisoPopup popup = new AvisoPopup("Turno de:  "+this.getControlador().getNombreJugadorActual());
    		popup.setDuracion(1.2);
    		popup.ejecutar();
			});
		pane.getChildren().add(boton);
		return pane;
	}

	private BorderPane jugadores() {
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(20, 20, 20, 20));
		this.jugadores.add(new PanelJugador( this.getControlador().getNombreJugadorActual(), false ) );
		this.jugadores.add(new PanelJugador( this.getControlador().getNombreJugadorOponente(), true ));

		pane.setLeft( this.jugadores.get(0));
		pane.setRight( this.jugadores.get(1) );
		
		return pane;
	}

	private GridPane algomones(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(3);
		grid.setHgap(2);
		
		Iterator<Algomon> it = this.getControlador().getAlgomonesParaElegir().iterator();
		for (int x = 0 ; x < 2 ; x++) {
			for (int y = 0; y < 3 ;y++) {
				if ( it.hasNext()) {
					Algomon algomon = it.next();
					VistaAlgomon vistaAlgomon = new VistaAlgomon(algomon);
					GridPane.setConstraints(vistaAlgomon.getSubEscena(), y, x);
					vistaAlgomon.getSubEscena().setOnMouseClicked(e -> {
						String jugadorActual = this.getControlador().getNombreJugadorActual();
						for (PanelJugador panelJugador : jugadores){
							if ( panelJugador.getJugador().equals(jugadorActual) ) {
								this.algomonSeleccionado(this.getControlador().getNombreAlgomon(algomon), panelJugador,vistaAlgomon,algomon);
								this.panelInformacion.setAlgomon(algomon);
								this.panelInformacion.actualizarInformacion();
								break;
							}
						}
					});
					grid.getChildren().add(vistaAlgomon.getSubEscena());
				}
			}
		}
		return grid;
	}

	private void algomonSeleccionado(String nombreAlgomon, PanelJugador panelJugador, VistaAlgomon vistaAlgomon,Algomon algomon) {
		if ( !vistaAlgomon.getEstoyElegido() ){
			this.algomonYaElegido.setVisible(false);
			this.panelConfirmacion.setVistaAlgomon(vistaAlgomon);
			this.panelConfirmacion.setAlgomon(nombreAlgomon);
			this.panelConfirmacion.setAlgomon(algomon);
			this.panelConfirmacion.setPanelJugador(panelJugador);
			this.panelConfirmacion.setVisible(true);
		}else{
			if ( !this.comenzarJuego.isVisible() ) {
				this.panelConfirmacion.setVisible(false);
				this.algomonYaElegido.setVisible(true);
			}
			
		}
	}

	private Group algomonYaElegido() {
		Group grupo = new Group();
		VBox boxV = new VBox();
		boxV.setSpacing(5);
		Label confirmarSeleccion = new Label("El algomon seleccionado ya fue elegido!!!");
		boxV.getChildren().add(confirmarSeleccion);
		grupo.getChildren().add(boxV);
		return grupo;
	}

	public void actContinuar(){
		this.algomonYaElegido.setVisible(false);
		this.panelConfirmacion.setVisible(false);
		this.comenzarJuego.setVisible(true);
	}
	
}
