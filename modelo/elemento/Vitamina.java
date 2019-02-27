package elemento;

import algomon.Algomon;

public class Vitamina extends Elemento {

    public Vitamina() {
        this.cantidad = 5;
    }


    @Override
    public void aplicarEfectosSobre(Algomon algomon) {
    	algomon.aumentarCantidadAtaques(2);
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vitamina";
	}
}
