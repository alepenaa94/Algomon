package ataque;

import java.io.File;

import algomon.Algomon;
import estado.Dormido;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class Canto extends Ataque {
	
	public Canto() {
		this.setPotencia(0);
		this.setCantidad(6);
		this.setTipo(Tipos.COMUN);
	}

	@Override
	protected void aplicarEfectosSobreVictima(Algomon victima) {
		victima.setEstado( new Dormido() );
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Canto";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "canto.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
