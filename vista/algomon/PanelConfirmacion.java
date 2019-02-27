package algomon;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import juego.ControladorJuego;
import pantallaSeleccionAlgomon.Contador;

public class PanelConfirmacion extends Group {

	public String nombreAlgomon;
	public PanelJugador panelJugador;
	private VistaAlgomon vistaAlgomon;
	private Algomon algomon;
	private Contador contador;
	
	public PanelConfirmacion(PantallaSeleccionAlgomon pantalla, ControladorJuego controlador, Contador contador){
		this.contador = contador;
		VBox boxV = new VBox();
		boxV.setSpacing(5);
		Label confirmarSeleccion = new Label("¿Confirmar algomon seleccionado?");
		boxV.getChildren().add(confirmarSeleccion);
		
		GridPane grid = new GridPane();
		grid.setHgap(70);
		Button botonAceptar = new Button("Aceptar");
		botonAceptar.setOnMouseClicked(e -> {
			if(this.contador.getValor()==5){
				pantalla.actContinuar();
			}
		    this.contador.incrementar();
			controlador.setAlgomon(controlador.getJugadorActual(), this.algomon);
			this.vistaAlgomon.setEstoyElegido(true);
			this.panelJugador.algomonSeleccionado(this.nombreAlgomon);	
			setVisible(false);
		});
		grid.add(botonAceptar,0,0);
		
		Button botonCancelar = new Button("Cancelar");
		botonCancelar.setOnMouseClicked(e -> {
			setVisible(false);		
		});
		grid.add(botonCancelar,1,0);
		
		boxV.getChildren().add(grid);
		getChildren().add(boxV);
		
	}

	public void setAlgomon(String nombreAlgomon) {
		this.nombreAlgomon = nombreAlgomon;	
	}

	public void setPanelJugador(PanelJugador panelJugador) {
		this.panelJugador = panelJugador;
	}

	public void setVistaAlgomon(VistaAlgomon vistaAlgomon) {
		this.vistaAlgomon = vistaAlgomon;		
	}
	
	public void setAlgomon(Algomon algomon){
		this.algomon = algomon;
	}
}
