package Pantallas;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import juego.ControladorJuego;

public abstract class Pantalla {
	
	private NavegadorPantallas navegador;
	private BorderPane root;
	private Stage stage;
	private ControladorJuego controlador;
	
	public Pantalla(NavegadorPantallas navegador,Stage stage,ControladorJuego controlador) {
		this.controlador = controlador;
		this.stage = stage;
		this.root = new BorderPane();
		this.navegador = navegador;
		this.root.setTop((new BarraMenu(stage)).getMenuBar());
		this.root.setCenter(this.crearLayout());
		}
	
	protected abstract Parent crearLayout();	
	
	public Parent getRoot() {
		return this.root;
	}
	
	protected NavegadorPantallas getNavegador(){
		return this.navegador;
	}
	
	public Stage getStage(){
		return this.stage;
	}
	
	public void setId(String id){
		this.root.setId(id);
	}
	
	public void setMenuBar(Stage stage){
		this.root.getChildren().addAll((new BarraMenu(stage)).getMenuBar());
	}
	
	public void irAPantalla(String nombre) {
		this.navegador.cargarPantalla(nombre);
	}

	public ControladorJuego getControlador() {
		return controlador;
	}
	
}