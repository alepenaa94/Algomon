package algomon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Vida.Vida;
import ataque.*;
import elemento.Elemento;
import estado.Estado;
import estado.Muerto;
import tipo.Tipos;

public abstract class Algomon {
	
	private Vida vida;
	private List<Estado> estados;
	private Tipos tipo;
	private List<Ataque> ataques;


	protected Algomon() {
		this.estados = new ArrayList<Estado>();
		this.ataques = new ArrayList<Ataque>();
	}


    private boolean puedeAtacar(Ataque ataque) throws ErrorCantidadAtaque {
        if( !ataque.puedeAtacar() ){
        	throw new ErrorCantidadAtaque();
        }
        
        for(Estado estado : this.estados){
        	if(!estado.puedeAtacar()){
        		return false;
        	}
        }
        return true;
    }


	public void atacar(Algomon enemigo, Ataque ataque) throws ErrorAtaqueDesconocido, ErrorAtaqueImposible, ErrorCantidadAtaque {

		if( !ataquePosible(ataque) ) {
            throw new ErrorAtaqueDesconocido();
        }

		if( this.puedeAtacar(ataque) )
			this.aplicarDaniosPorEstado();
		
		if ( this.estaMuerto() )
			throw new ErrorAlgomonMuerto();
		
		if( this.puedeAtacar(ataque) ){
			ataque.atacar(enemigo, this);}
		else
			throw new ErrorAtaqueImposible();
	}

	public double recibirDanio(double potencia) {
		double danioCausado = this.vida.restarPuntos(potencia);
		
		if( this.vida.muerto() ) {
			this.estados = new ArrayList<Estado>();
			this.estados.add( new Muerto() );
		}
		
		return danioCausado;
	}


	public void restaurar() {
		this.estados = new ArrayList<Estado>();
	}


	public void restituirVida(double puntos) {
		if( this.vida.muerto() )
			this.restaurar();
		
		this.vida.restituirPuntos(puntos);
	}

	
	public void setEstado(Estado estado) {
		if (!estadoPosible(estado))
			return;
		
		this.estados.add(estado);
	}

	
	private void aplicarDaniosPorEstado() {
		for(Estado estado : this.estados)
			this.recibirDanio(estado.calcularDanios(this));
	}


	public void actualizarEstado() {
		Iterator<Estado> it = this.estados.iterator();
		
		while(it.hasNext()) {
			Estado estado = it.next();
			estado.actualizarEstado();
			if(!estado.sigueVigente())
				it.remove();
		}
	}


	protected void setAtaques(Ataque... ataques) {
		for(int i = 0 ; i < ataques.length ; i++)
			this.ataques.add(ataques[i]);
	}


	protected void setVida(double puntosDeVida) {
		this.vida = new Vida(puntosDeVida);
	}


	protected void setTipo(Tipos tipo) {
        this.tipo = tipo;
	}


	public double getVida() {
		return this.vida.getVidaActual();
	}


	public double getVidaTotal() {
		return this.vida.getVidaTotal();
	}


	public Tipos getTipo() {
		return tipo;
	}


	private boolean ataquePosible(Ataque ataquePosible){
		for(Ataque ataque : this.ataques){
			if(ataque.esAtaque(ataquePosible)){
				return true;
			}
		}
		return false;
	}


	private boolean estadoPosible(Estado nuevoEstado){
		for(Estado estado : this.estados){
			if(estado.esEstado(nuevoEstado)){
				return false;
			}
		}
		return true;
	}


	public boolean estaMuerto(){
        for(Estado estado : this.estados){
            if(estado.esEstado(new Muerto())){
                return true;
            }
        }
        return false;

    }


	public void avanzarTurno() {
		this.actualizarEstado();
	}


    public  void usarElemento(Elemento elemento) throws ErrorAlgomonMuerto{

        this.aplicarDaniosPorEstado();
        
        if ( this.estaMuerto() )
			throw new ErrorAlgomonMuerto();
        
        elemento.aplicarSobre(this);
    }

    public void restaurarEstados() {

        this.estados = new ArrayList<Estado>();
    }

    public void aumentarCantidadAtaques(int cantidad) {

        for(Ataque ataque : this.ataques){

            ataque.aumentarCantidad(cantidad);
        }
    }
    
    public ArrayList<Ataque> getAtaquesPosibles(){	
    	return (ArrayList<Ataque>) this.ataques;   	
    }
    
    public abstract String toString();
    
    
    
}
