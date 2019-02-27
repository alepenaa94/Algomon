package algomon;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.shape.MeshView;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaAlgomon extends Group {

	private SubScene subEscena;
	private Algomon algomon;
	private boolean estoyElegido;
	
	public VistaAlgomon(Algomon algomon) {
		this.algomon = algomon;
		if ( Platform.isSupported(ConditionalFeature.SCENE3D) ) {
			this.crearAlgomon3D();
		}else {
			this.crearAlomon2D();
		}
		this.estoyElegido = false;
	}

	private void crearAlomon2D() {
		try{
			Image imagen = new Image( this.getClass().getResource("algomones/" + this.algomon.getClass().getSimpleName() + ".png").toString() );
			ImageView vistaImagen = new ImageView(imagen);
			vistaImagen.setFitWidth(200);
			vistaImagen.setPreserveRatio(true);
			vistaImagen.setSmooth(true);
			vistaImagen.setCache(true);
			getChildren().add(vistaImagen);
			this.subEscena = new SubScene(this, 200, 200);
		}catch (Exception e) {
			System.out.println("No estan los archivos necesarios");
		}	
	}

	private void crearAlgomon3D() {
		ObjModelImporter station = new ObjModelImporter();
		try{
			station.read(this.getClass().getResource("algomones/" + this.algomon.getClass().getSimpleName() + ".obj"));
			
			MeshView[] meshViews = station.getImport();
			
			for (MeshView mesh : meshViews){
				getChildren().add(mesh);	
			}
			setScaleX(20);
			setScaleY(20);
			setScaleZ(20);
			this.subEscena = new SubScene(this, 200, 200,true,SceneAntialiasing.BALANCED);
			
			PerspectiveCamera camera = new PerspectiveCamera();
			camera.setTranslateX(this.subEscena.getWidth() / -2.0);
			camera.setTranslateY(this.subEscena.getWidth() / -2.0);
			
	        RotateTransition rt = new RotateTransition(Duration.seconds(10), this);
	        rt.setCycleCount(Animation.INDEFINITE);
	        rt.setFromAngle(0);
	        rt.setToAngle(360);
	        rt.setAxis(new Point3D(0, 1, 0));
	        rt.play();
	        
	        this.subEscena.setCamera(camera);
	        this.subEscena.setId(this.algomon.getClass().getSimpleName());
		}catch (Exception e) {
			System.out.println("No estan los archivos necesarios");
		}		
	}

	public SubScene getSubEscena() {
		return this.subEscena;
	}

	public void setEstoyElegido(boolean estoyElegido) {
		this.estoyElegido = estoyElegido;		
	}
	
	public boolean getEstoyElegido() {
		return this.estoyElegido;		
	}
}
