package estado;

import algomon.Algomon;
import interfaces.EstadoComparable;

public class Muerto extends Estado {

	@Override
	public boolean puedeAtacar() {
		return false;
	}


	@Override
	public void actualizarEstado() {}

	@Override
	public double calcularDanios(Algomon algomonAfectado) {
		return 0;
	}

	@Override
	public boolean sigueVigente() {
		return true;
	}

	@Override
	public boolean esEstado(EstadoComparable estado){
		return estado.esEstado(this);
	}
	@Override
	public boolean esEstado(Dormido estado){
		return false;
	}
	@Override
	public boolean esEstado(Muerto estado){
		return true;
	}
	@Override
	public boolean esEstado(Quemado estado){
		return false;
	}
}
