package algomon;

import ataque.AtaqueRapido;
import ataque.Brasas;
import ataque.Fogonazo;
import tipo.Tipos;

public class Charmander extends Algomon {
	
	public Charmander(){
		this.setVida(170);
		this.setTipo(Tipos.FUEGO );
		this.setAtaques(new Brasas(), new Fogonazo(), new AtaqueRapido());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Charmander";
	}
}
