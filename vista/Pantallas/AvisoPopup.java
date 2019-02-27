package Pantallas;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AvisoPopup {

	
	private Stage dialog;
	private VBox dialogVbox;
	private Scene dialogScene;
	private Text text;
	private PauseTransition delay;
	
	public AvisoPopup(String string){
		this.dialog = new Stage();
		this.dialogVbox = new VBox();
		this.dialogVbox.setAlignment(Pos.CENTER);
		this.text = new Text(string);
		this.dialogVbox.getChildren().add(this.text);
		this.dialogScene = new Scene(this.dialogVbox, 300, 70);
		this.dialog.setScene(this.dialogScene);
		//this.dialog.show();
		this.delay = new PauseTransition(Duration.seconds(0.8));
		this.delay.setOnFinished( event -> this.dialog.close() );
		//this.delay.play();
	
	}
	
	public void ejecutar(){
		this.dialog.show();
		this.delay.play();
	}
	
	public void setDuracion(double a){
		this.delay = new PauseTransition(Duration.seconds(a));
		this.delay.setOnFinished( event -> this.dialog.close() );
	}

}
