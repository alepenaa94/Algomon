package ataque;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class CanionDeAgua extends Ataque {
	
	public CanionDeAgua() {
		this.setPotencia(20);
		this.setCantidad(8);
		this.setTipo(Tipos.AGUA);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Canion de Agua";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "canionDeAgua.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
