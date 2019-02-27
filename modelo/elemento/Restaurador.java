package elemento;

import algomon.Algomon;

public class Restaurador extends Elemento {

    public Restaurador() {
        this.cantidad = 3;
    }


    @Override
    public void aplicarEfectosSobre(Algomon algomon) throws ErrorAplicacionImposible {
        if (!algomon.estaMuerto()) {
            algomon.restaurarEstados();
        }
        else {
            throw new ErrorAplicacionImposible();
        }
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Restaurador";
	}
}
