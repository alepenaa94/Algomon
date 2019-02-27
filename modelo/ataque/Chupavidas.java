package ataque;

import java.io.File;

import algomon.Algomon;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tipo.Tipos;

public class Chupavidas extends Ataque {
	
	public Chupavidas(){
		this.setPotencia(15);
		this.setCantidad(8);
		this.setTipo(Tipos.PLANTA);
	}

	@Override
	protected void aplicarEfectosSobreAtacante(Algomon atacante, double danioCausado) {
		atacante.restituirVida(danioCausado*0.3);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chupavidas";
	}

	@Override
	public void ejecutarSonido(){
		String musicFile = "chupavidas.wav";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
			
	}
}
