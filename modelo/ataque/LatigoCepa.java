package ataque;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class LatigoCepa extends Ataque {
	
	public LatigoCepa() {
		this.setPotencia(15);
		this.setCantidad(10);
		this.setTipo(Tipos.PLANTA);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Latigo Cepa";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "latigoCepa.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
