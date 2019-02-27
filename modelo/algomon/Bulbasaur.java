package algomon;

import ataque.AtaqueRapido;
import ataque.Chupavidas;
import ataque.LatigoCepa;
import tipo.Tipos;

public class Bulbasaur extends Algomon {

	public Bulbasaur(){
		super();
		this.setVida(140);
		this.setTipo(Tipos.PLANTA );
		this.setAtaques(new Chupavidas(), new LatigoCepa(), new AtaqueRapido());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bulbasaur";
	}









}
