package estado;

import algomon.Algomon;
import interfaces.EstadoComparable;
public class Dormido extends EstadoEfimero {

	public Dormido() {
		this.setTurnos(3);
	}


	@Override
	public boolean puedeAtacar() {
		return false;
	}


	@Override
	public double calcularDanios(Algomon algomonAfectado) {
		return  0;
	}
	@Override
	public boolean esEstado(EstadoComparable estado){
		return estado.esEstado(this);
	}
	@Override
	public boolean esEstado(Dormido estado){
		return true;
	}
	@Override
	public boolean esEstado(Muerto estado){
		return false;
	}
	@Override
	public boolean esEstado(Quemado estado){
		return false;
	}



}
