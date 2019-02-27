package algomon;

import ataque.AtaqueRapido;
import ataque.Burbuja;
import ataque.Canto;
import tipo.Tipos;

public class Jigglypuff extends Algomon {
	
	public Jigglypuff(){
		this.setVida(130);
		this.setTipo(Tipos.COMUN );
		this.setAtaques(new Canto(), new Burbuja(), new AtaqueRapido());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Jigglypuff";
	}



}
