package estado;

import algomon.Algomon;
import interfaces.EstadoComparable;
public abstract class Estado implements EstadoComparable {
	
	public abstract boolean puedeAtacar();
	public abstract void actualizarEstado();
	public abstract double calcularDanios(Algomon algomonAfectado);
    public abstract boolean sigueVigente();
}
