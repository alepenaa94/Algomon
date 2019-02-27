package estado;

public abstract class EstadoPersistente extends Estado {
	
	public void actualizarEstado(){
	}


	@Override
	public boolean sigueVigente() {
		return true;
	}


}
