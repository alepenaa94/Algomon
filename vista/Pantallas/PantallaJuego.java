package Pantallas;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import juego.ControladorJuego;
import jugador.Jugador;
import java.io.File;
import algomon.Algomon;
import algomon.VistaAlgomon;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class PantallaJuego extends Pantalla {
	
	private TextArea display2;
	private VistaAlgomon algomonJugadorActual,algomonJugadorOponente;
	private  BorderPane pane2;
	public PantallaJuego(NavegadorPantallas navegador,Stage stage, ControladorJuego controlador) {
		super(navegador,stage,controlador);
	}

	@Override
	protected Parent crearLayout() {
		
        pane2 = new BorderPane();   
        
        GridPane layout3= new GridPane();
		layout3.setPadding(new Insets(5));
		layout3.setAlignment(Pos.TOP_CENTER);
		layout3.setHgap(5);
		layout3.setVgap(5);
		
        this.display2 = new TextArea();
        this.display2.setPrefRowCount(4);
        this.display2.setWrapText(true);
        this.display2.setEditable(false);
        GridPane.setHalignment(this.display2, HPos.CENTER);
        layout3.add(this.display2, 0, 0);

        String string2 = "Pelea.....\n";        
        this.display2.setText(string2);
        
        
        
        this.pane2.setBottom((new PanelTurno(this.getControlador(),this)).getPanel());
        this.pane2.setCenter(layout3);
        
        this.actualizarVistaAlgomon();
	
		return this.pane2;
	}
	
	
	private VistaAlgomon vistaAlgomonJugador(Jugador jugador) {
		Algomon algomon = this.getControlador().getAlgomonActivo(jugador);
		VistaAlgomon vistaAlgomon = new VistaAlgomon(algomon);
		return vistaAlgomon;
	}

	public void actualizarVistaAlgomon(){
		VBox vistaJugadorActual = new VBox();
		vistaJugadorActual.setPadding(new Insets(10, 10, 10, 10));
		vistaJugadorActual.setAlignment(Pos.CENTER);
        Jugador jugadorActual = this.getControlador().getJugadorActual();
        final Label jug1Nombre = new Label(jugadorActual.getNombre());
		jug1Nombre.setPadding(new Insets(15, 10, 10, 10));
		jug1Nombre.setAlignment(Pos.CENTER);
		jug1Nombre.setStyle("-fx-text-transform: capitalize; -fx-font-size: 25px; -fx-background-color: rgba(0, 100, 100, 0.8); -fx-background-radius: 10;");
		jug1Nombre.setTextFill(Color.WHITE);
		jug1Nombre.setPrefWidth(150);
		vistaJugadorActual.getChildren().add(jug1Nombre);
        this.algomonJugadorActual = this.vistaAlgomonJugador(jugadorActual);
        vistaJugadorActual.getChildren().add(this.algomonJugadorActual.getSubEscena());
        ProgressBar barraVidaAlgomonJugadorActual = new ProgressBar();
        barraVidaAlgomonJugadorActual.setProgress( this.getControlador().getVidaActualAlgomon( jugadorActual ) / this.getControlador().getVidaTotalAlgomon( jugadorActual ) );
        vistaJugadorActual.getChildren().add(barraVidaAlgomonJugadorActual);
        Label vidaAlgomonJugadorActual = new Label();
        vidaAlgomonJugadorActual.setAlignment(Pos.CENTER);
        vidaAlgomonJugadorActual.setText(this.getControlador().getVidaActualAlgomon( jugadorActual ) + "/" + this.getControlador().getVidaTotalAlgomon( jugadorActual ));
        vidaAlgomonJugadorActual.setStyle("-fx-text-transform: capitalize; -fx-font-size: 25px; -fx-background-color: rgba(0, 100, 100, 0.8); -fx-background-radius: 10;");
        vidaAlgomonJugadorActual.setTextFill(Color.WHITE);
        vistaJugadorActual.getChildren().add(vidaAlgomonJugadorActual);
        this.pane2.setLeft( vistaJugadorActual );
       
        
        
        VBox vistaJugadorOponente = new VBox();
        vistaJugadorOponente.setPadding(new Insets(10, 10, 10, 10));
        vistaJugadorOponente.setAlignment(Pos.CENTER);
        Jugador jugadorActualOponente = this.getControlador().getJugadorOponente();
        final Label jug2Nombre = new Label(jugadorActualOponente.getNombre());
		jug2Nombre.setPadding(new Insets(15, 10, 10, 10));
		jug2Nombre.setAlignment(Pos.CENTER);
		jug2Nombre.setStyle("-fx-text-transform: capitalize; -fx-font-size: 25px; -fx-background-color: rgba(0, 100, 100, 0.8); -fx-background-radius: 10;");
		jug2Nombre.setTextFill(Color.WHITE);
		jug2Nombre.setPrefWidth(150);
        vistaJugadorOponente.getChildren().add(jug2Nombre);
        this.algomonJugadorOponente = this.vistaAlgomonJugador( jugadorActualOponente );
        vistaJugadorOponente.getChildren().add(this.algomonJugadorOponente.getSubEscena());
        ProgressBar barraVidaAlgomonJugadorOponente = new ProgressBar();
        barraVidaAlgomonJugadorOponente.setProgress( this.getControlador().getVidaActualAlgomon( jugadorActualOponente ) / this.getControlador().getVidaTotalAlgomon( jugadorActualOponente ) );
        vistaJugadorOponente.getChildren().add(barraVidaAlgomonJugadorOponente);
        Label vidaAlgomonJugadorOponente = new Label();
        vidaAlgomonJugadorOponente.setAlignment(Pos.CENTER);
        vidaAlgomonJugadorOponente.setText(this.getControlador().getVidaActualAlgomon( jugadorActualOponente ) + "/" + this.getControlador().getVidaTotalAlgomon( jugadorActualOponente ));
        vidaAlgomonJugadorOponente.setStyle("-fx-text-transform: capitalize; -fx-font-size: 25px; -fx-background-color: rgba(0, 100, 100, 0.8); -fx-background-radius: 10;");
        vidaAlgomonJugadorOponente.setTextFill(Color.WHITE);
        vistaJugadorOponente.getChildren().add(vidaAlgomonJugadorOponente);
   
        this.pane2.setRight( vistaJugadorOponente );
	}

	public void setComentario(String string){
		this.display2.appendText(string);
	}
	
	public void juegoTerminado(){
		this.display2.setText("El Ganador es: "+this.getControlador().getGanador()+" !!");
		this.pane2.setRight(null);
		this.pane2.setLeft(null);
		this.pane2.setBottom(null);
		String musicFile = "Ganador.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
	}
	
}
