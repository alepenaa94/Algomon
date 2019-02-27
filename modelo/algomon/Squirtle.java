package algomon;

import ataque.AtaqueRapido;
import ataque.Burbuja;
import ataque.CanionDeAgua;
import tipo.Tipos;

public class Squirtle extends Algomon {
	
	public Squirtle(){
		this.setVida(150);
		this.setTipo(Tipos.AGUA );
		this.setAtaques(new Burbuja(), new CanionDeAgua(), new AtaqueRapido());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Squirtle";
	}
}
