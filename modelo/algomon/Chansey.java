package algomon;

import ataque.AtaqueRapido;
import ataque.Canto;
import ataque.LatigoCepa;
import tipo.Tipos;

public class Chansey extends Algomon {

	public Chansey(){
		this.setVida(130);
		this.setTipo(Tipos.COMUN);
		this.setAtaques(new Canto(), new AtaqueRapido(), new LatigoCepa());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chansey";
	}
}
