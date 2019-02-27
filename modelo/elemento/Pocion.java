package elemento;

import algomon.Algomon;

public class Pocion extends Elemento {

    public Pocion() {
        this.cantidad = 4;
    }


    @Override
    public void aplicarEfectosSobre(Algomon algomon) {
    	algomon.restituirVida(20);
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pocion";
	}
}
