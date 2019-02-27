package Pantallas;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PantallaDeCarga extends Preloader {

    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    private Stage preloaderStage;
    private Scene scene;
    private ProgressBar progressBar;
    private Label progress;
    
    public PantallaDeCarga() {
    }

    @Override
    public void init() throws Exception {
        Platform.runLater(() -> {
        	Image imagen = new Image("file:" + this.getClass().getResource("pikachu.gif").getPath());
            ImageView vistaImagen = new ImageView(imagen);
            progressBar = new ProgressBar(0);
            progress = new Label("0%");
            
            VBox root = new VBox(vistaImagen,progress, progressBar);
            root.setAlignment(Pos.CENTER);
            root.backgroundProperty().set(new Background(new BackgroundFill(javafx.scene.paint.Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            
            scene = new Scene(root, WIDTH, HEIGHT);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preloaderStage = primaryStage;
        
        preloaderStage.setScene(scene);
        preloaderStage.show();       
    }

	@Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info instanceof ProgressNotification) {
        	progress.setText(((ProgressNotification) info).getProgress() + "%");
        	progressBar.setProgress(((ProgressNotification) info).getProgress()/100);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                break;
            case BEFORE_INIT:
                break;
            case BEFORE_START:
                preloaderStage.hide();
                break;
        }
    }
 
}
