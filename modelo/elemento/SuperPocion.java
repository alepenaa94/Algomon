package elemento;

import algomon.Algomon;

public class SuperPocion extends Elemento {

    public SuperPocion() {
        this.cantidad = 2;
    }


    @Override
    public void aplicarEfectosSobre(Algomon algomon) {
    	algomon.restituirVida(40);
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SuperPocion";
	}
}
