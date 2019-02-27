package algomon;

import ataque.AtaqueRapido;
import ataque.Burbuja;
import ataque.Fogonazo;
import tipo.Tipos;

public class Rattata extends Algomon{
	
	public Rattata(){
		this.setVida(170);
		this.setTipo(Tipos.COMUN);
		this.setAtaques(new Fogonazo(), new Burbuja(), new AtaqueRapido());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rattata";
	}
}
