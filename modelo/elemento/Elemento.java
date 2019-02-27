package elemento;

import algomon.Algomon;

public abstract class Elemento {

    protected int cantidad;


    public int getCantidad() {

        return this.cantidad;
    }


    public void aplicarSobre(Algomon algomon) {
        if (this.puedeAplicarEfectos()) {
            this.cantidad = cantidad - 1;
            
            try {
            	this.aplicarEfectosSobre(algomon);
            }
            catch (ErrorAplicacionImposible error) {
            	throw error;
            }
        }
        else {
            throw new ErrorCantidadInsuficiente();
        }
    }

    protected abstract void aplicarEfectosSobre(Algomon algomon);

    public boolean puedeAplicarEfectos() {
        return (this.cantidad > 0);
    }
    
    public abstract String toString();
    
}
