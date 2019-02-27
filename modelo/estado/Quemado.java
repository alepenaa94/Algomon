package estado;

import algomon.Algomon;
import interfaces.EstadoComparable;
public class Quemado extends EstadoPersistente {


	@Override
	public boolean puedeAtacar() {
		return true;
	}


	@Override
	public double calcularDanios(Algomon algomonAfectado) {
		return algomonAfectado.getVidaTotal() * 0.10;
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
		return false;
	}
	@Override
	public boolean esEstado(Quemado estado){
		return true;
	}
}
