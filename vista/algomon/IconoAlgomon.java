package algomon;

import javafx.geometry.Insets;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class IconoAlgomon extends Pane {

	private String nombre;
	private boolean ocupado;
	
	public IconoAlgomon(){
		setPrefSize(100, 50);
		setStyle("-fx-background-color: white;-fx-border-style: solid; -fx-border-width: 2px 2px 2px 2px;");
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setFondo(String nombre){
		Image imagen = new Image( this.getClass().getResource("algomones/" + nombre + ".png").toString() );
		ImageView vistaImagen = new ImageView(imagen);
		vistaImagen.setFitWidth(getWidth());
		vistaImagen.setPreserveRatio(true);
		vistaImagen.setSmooth(true);
		vistaImagen.setCache(true);
		getChildren().add(vistaImagen);
		setOcupado(true);
	}
	
	public void setOcupado(boolean ocupado){
		this.ocupado = ocupado;
	}
	
	public boolean getOcupado(){
		return this.ocupado;
	}
}
