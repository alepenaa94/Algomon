package jugador;

import java.util.ArrayList;
import algomon.Algomon;
import algomon.ErrorAlgomonMuerto;
import algomon.ErrorAtaqueImposible;
import ataque.Ataque;
import ataque.ErrorAtaqueDesconocido;
import ataque.ErrorCantidadAtaque;
import elemento.*;

public class Jugador {

	private ArrayList<Algomon> algomones;
	private String nombre;
    private ArrayList<Elemento> elementos;
	private Algomon algomoActivo;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.algomones = new ArrayList<Algomon>();
        this.elementos = new ArrayList<Elemento>();
        this.algomoActivo = null;

        Pocion pocion = new Pocion();
        SuperPocion superPocion = new SuperPocion();
        Restaurador restaurador = new Restaurador();
        Vitamina vitamina = new Vitamina();

        this.elementos.add(pocion);
        this.elementos.add(superPocion);
        this.elementos.add(restaurador);
        this.elementos.add(vitamina);
	}


	public void agregarAlgomon(Algomon algomon) throws ErrorCapacidadMaxima {
		if(this.algomones.size() >= 3)
			throw new ErrorCapacidadMaxima();
		else {
			if (this.algomones.isEmpty()) {//Si es el primero en agregar es el actual
				this.algomoActivo = algomon;
			}
			this.algomones.add(algomon);
		}
	}


	public void quitarAlgomon(Algomon algomon) throws ErrorAlgomonDesconocido {
		if( !this.algomones.remove(algomon) )
			throw new ErrorAlgomonDesconocido();
	}


	public void avanzarTurno(){
		for(Algomon algomon : this.algomones){
			algomon.avanzarTurno();
		}
	}


	public String getNombre() {
		return this.nombre;
	}


    public void aplicarElementoAAlgomonActivo(Elemento elemento) throws ErrorAlgomonMuerto {

        this.algomoActivo.usarElemento(elemento);
    }


	public Algomon getAlgomoActivo() {

		return this.algomoActivo;
	}


    public boolean tieneNombre(String nombreJugador) {
        return (this.nombre.trim().equals(nombreJugador));
    }


    public void cambiarAlgomonActivo(Algomon algomonNuevo) throws ErrorCambioAlgomonEsActivo {
    	
    	if(this.getAlgomoActivo().equals(algomonNuevo)){
    		throw new ErrorCambioAlgomonEsActivo();
    	}

        for (Algomon algomon : this.algomones){

            if (algomon.equals(algomonNuevo)){

                this.algomoActivo = algomon;
            }
        }
    }

    
    public ArrayList<Algomon> getAlgomonesVivos() {

        ArrayList<Algomon> algomonesVivos = new ArrayList<Algomon>();

        for (Algomon algomon : this.algomones){

            if (!algomon.estaMuerto()){

                algomonesVivos.add(algomon);
            }
        }

        return algomonesVivos;

    }


    public boolean perdioPartida() {

        boolean perdio = true;

        for (Algomon algomon : this.algomones){

            if (!algomon.estaMuerto()){

                perdio = false;
            }
        }

        return perdio;
    }


    public ArrayList<Elemento> getElementos() {

        return this.elementos;
    }


    public void atacar(Jugador jugador, Ataque ataque) throws ErrorAtaqueDesconocido, ErrorAtaqueImposible, ErrorCantidadAtaque, ErrorAlgomonMuerto {

        Algomon algomonEnemigo = jugador.getAlgomoActivo();

        this.algomoActivo.atacar(algomonEnemigo, ataque);
    }
    
    public ArrayList<Ataque> getAtaquesAlgomonAct(){
    	return this.algomoActivo.getAtaquesPosibles();
    }
    
}
