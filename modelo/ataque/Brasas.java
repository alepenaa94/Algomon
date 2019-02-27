package ataque;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class Brasas extends Ataque {

	public Brasas() {
		this.setPotencia(16);
		this.setCantidad(10);
		this.setTipo(Tipos.FUEGO);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Brasas";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "brasas.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
