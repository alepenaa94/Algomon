package ataque;

import java.io.File;

import algomon.Algomon;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class AtaqueRapido extends Ataque {


	public AtaqueRapido(){
		this.setPotencia(10);
		this.setCantidad(16);
		this.setTipo(Tipos.COMUN);
	}
	
	@Override
	public void aplicarEfectosSobreVictima(Algomon victima) {}

	@Override
	public void aplicarEfectosSobreAtacante(Algomon atacante, double danioCausado) {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ataque Rapido";
	}
	
	
	public void ejecutarSonido(){
		String musicFile = "ataqueRapido.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
	
	
	
}
