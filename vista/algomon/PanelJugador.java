package algomon;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PanelJugador extends HBox {

	private ArrayList<IconoAlgomon> iconos;
	
	public PanelJugador(String nombreJugador, boolean esOponente ){
		iconos = new ArrayList<IconoAlgomon>();
		setId(nombreJugador);
		setStyle("-fx-background-color: rgba(0, 100, 100, 0.3); -fx-background-radius: 10;");
		setPrefSize(350, 70);
		
		GridPane algomonesJugador = new GridPane();
		algomonesJugador.setPadding(new Insets(10, 10, 10, 10));
		algomonesJugador.setHgap(5);
		iconos.add(new IconoAlgomon());
		iconos.add(new IconoAlgomon());
		iconos.add(new IconoAlgomon());
		algomonesJugador.add( iconos.get(0) , 0, 0);
		algomonesJugador.add( iconos.get(1) , 1, 0);
		algomonesJugador.add( iconos.get(2), 2, 0);
		
		final Label jug1Nombre = new Label(nombreJugador);
		jug1Nombre.setPrefWidth(250);
		jug1Nombre.setPadding(new Insets(15, 10, 10, 10));
		jug1Nombre.setAlignment(Pos.CENTER);
		jug1Nombre.setStyle("-fx-text-transform: capitalize; -fx-font-size: 25px");
		if ( esOponente ){ 
			getChildren().addAll(algomonesJugador,jug1Nombre);
		}else{
			getChildren().addAll(jug1Nombre,algomonesJugador);
		}	
	}
	
	public String getJugador(){
		return getId();
	}

	public void algomonSeleccionado(String algomon) {
		for ( IconoAlgomon icono : this.iconos ){
			if ( !icono.getOcupado() ){
				icono.setFondo(algomon);
				break;
			}
		}
	}
	
	
}
