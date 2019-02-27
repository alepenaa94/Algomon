package estado;

public abstract class EstadoEfimero extends Estado {
	
	private int turnosValidez;


	protected void setTurnos(int turnos) {
		this.turnosValidez = turnos;
	}


	@Override
	public void actualizarEstado() {
		this.turnosValidez -= 1;
	}


	@Override
	public boolean sigueVigente() {

		if (this.turnosValidez == 0)
			return false;
		else
			return true;
	}


}
