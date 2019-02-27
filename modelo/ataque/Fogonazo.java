package ataque;

import java.io.File;

import algomon.Algomon;
import estado.Quemado;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class Fogonazo extends Ataque {
	
	public Fogonazo(){
		this.setPotencia(2);
		this.setCantidad(4);
		this.setTipo(Tipos.FUEGO);
	}

	@Override
	protected void aplicarEfectosSobreVictima(Algomon victima) {
		victima.setEstado( new Quemado() );
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fogonazo";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "fogonazo.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
