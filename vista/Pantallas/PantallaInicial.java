package Pantallas;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import juego.ControladorJuego;

public class PantallaInicial extends Pantalla {
	private boolean flag1=true;
	private boolean flag2=true;
	
	public PantallaInicial(NavegadorPantallas navegador,Stage stage, ControladorJuego controlador) {
		super(navegador,stage,controlador);
	}
	
	protected Parent crearLayout() {
		HBox layout = new HBox();
		layout.setAlignment(Pos.CENTER);
		
		Button botonJugar = new Button("Jugar");
		botonJugar.setOnAction(e -> {
			this.irAPantalla("Seleccion");
		});
		
		layout.getChildren().add(botonJugar);
		
		return layout;
	}
}