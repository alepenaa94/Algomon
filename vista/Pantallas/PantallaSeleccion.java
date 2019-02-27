package Pantallas;
import Botones.ComenzarHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import juego.ControladorJuego;


public class PantallaSeleccion extends Pantalla {
	
	public PantallaSeleccion(NavegadorPantallas navegador,Stage stage, ControladorJuego controlador) {
		super(navegador,stage,controlador);
	}
	
	protected Parent crearLayout() {
		BorderPane layout = new BorderPane();

		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER_LEFT);
		grid.setVgap(5);
		grid.setHgap(5);
		
		Button botonAtras = new Button("Atrás");
		botonAtras.setOnAction(e -> {
			this.irAPantalla("Inicio");
		});

		Button botonComenzar = new Button("Comenzar");

		VBox cont = new VBox();
		cont.setAlignment(Pos.BOTTOM_CENTER);
		cont.setPadding(new Insets(10, 10, 10, 10));
		VBox cont2 = new VBox();
		cont2.setAlignment(Pos.BOTTOM_CENTER);
		cont2.setPadding(new Insets(10, 10, 10, 10));
		cont.getChildren().add(botonAtras);
		cont2.getChildren().add(botonComenzar);
		layout.setLeft(cont);
		layout.setRight(cont2);

		final TextFieldNombre jug1Nombre = new TextFieldNombre();
		jug1Nombre.setPrefWidth(250);
		jug1Nombre.setPromptText("Jugador1: Nombre");
		GridPane.setConstraints(jug1Nombre, 0, 0);
		grid.getChildren().add(jug1Nombre);

		TextField infoJugador1 = new TextField();
		infoJugador1.setDisable(true);
		infoJugador1.setOpacity(1000);
		infoJugador1.setFont(Font.font(20));
		//infoJugador1.setStyle("-fx-text-inner-color: #ff0916;");
		infoJugador1.setBackground(Background.EMPTY);
		infoJugador1.setPrefSize(250,30);
		GridPane.setConstraints(infoJugador1,2,0);
		grid.getChildren().add(infoJugador1);

		TextField infoJugador2 = new TextField();
		infoJugador2.setDisable(true);
		infoJugador2.setOpacity(1000);
		infoJugador2.setFont(Font.font(20));
		//infoJugador2.setStyle("-fx-text-inner-color: #ff0a00;");
		infoJugador2.setBackground(Background.EMPTY);
		infoJugador2.setPrefSize(250,30);
		GridPane.setConstraints(infoJugador2,2,1);
		grid.getChildren().add(infoJugador2);


		final TextFieldNombre jug2Nombre = new TextFieldNombre();
		jug2Nombre.setPromptText("Jugador2: Nombre");
		GridPane.setConstraints(jug2Nombre, 0, 1);
		grid.getChildren().add(jug2Nombre);

		ComenzarHandler handlerBotonComenzar = new ComenzarHandler(botonComenzar,jug1Nombre,jug2Nombre,infoJugador1,infoJugador2,this,getControlador(),this.getNavegador());
		botonComenzar.setOnAction(handlerBotonComenzar);

		
		layout.setCenter(grid);
		
		return layout;
		
	}
	

		
	
		
}