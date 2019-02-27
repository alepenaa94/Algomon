
package Pantallas;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu {
	
	private MenuBar menuBar;

	public BarraMenu(Stage primaryStage){
		//Barra Menu
	    this.menuBar = new MenuBar();
	    this.menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    // File menu - new, save, exit
	    Menu fileMenu = new Menu("File");
	    Menu opciones = new Menu("Opciones");
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    MenuItem maximizar = new MenuItem("Maximizar");
	    MenuItem minimizar = new MenuItem("Minimizar");
	    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
	    maximizar.setOnAction(BotonHandlerMaximizar(primaryStage,maximizar,minimizar));
	    minimizar.setDisable(true);
	    minimizar.setOnAction(BotonHandlerMinimizar(primaryStage,maximizar,minimizar));
	    fileMenu.getItems().addAll(exitMenuItem);
	    opciones.getItems().addAll(maximizar,minimizar);
	    
	    this.menuBar.getMenus().addAll(fileMenu,opciones);
		
		
	}
	
	public MenuBar getMenuBar(){
		return this.menuBar;
	}

	
	private EventHandler<ActionEvent> BotonHandlerMaximizar(Stage primaryStage, MenuItem maximizar,MenuItem minimizar) {
			
		return (new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    	primaryStage.setMaximized(true);
		    	maximizar.setDisable(true);
		    	minimizar.setDisable(false);
		    }
		});
	}
	
	private EventHandler<ActionEvent> BotonHandlerMinimizar(Stage primaryStage, MenuItem maximizar,MenuItem minimizar) {
		
		return (new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    	primaryStage.setMaximized(false);
		    	maximizar.setDisable(false);
		    	minimizar.setDisable(true);
		    }
		});
	}

	
	
	
}
