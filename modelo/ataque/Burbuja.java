package ataque;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class Burbuja extends Ataque {
	
	public Burbuja() {
		this.setPotencia(10);
		this.setCantidad(15);
		this.setTipo(Tipos.AGUA);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Burbuja";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "burbujas.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}

	
}
