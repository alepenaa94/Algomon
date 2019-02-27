package Partida;

import algomon.*;
import ataque.Ataque;
import ataque.ErrorAtaqueDesconocido;
import ataque.ErrorCantidadAtaque;
import elemento.Elemento;
import jugador.ErrorCambioAlgomonEsActivo;
import jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Rodrigo on 16-Nov-16.
 */
public class Partida {

    private ArrayList<Jugador> jugadores;
    private int jugadorActual;

    public Partida(){

        this.jugadores = new ArrayList<Jugador>();
        this.jugadorActual = 0;
    }


    public void crearYAgregarJugador(String nombre) {


        if (nombre.trim().equals("") ){
            throw new NombreVacioError();
        }else {
            if (this.existeJugador(nombre)) {
                throw new NombreJugadorRepetidoError();
            } else {
                Jugador jugadorNuevo = new Jugador(nombre);
                this.jugadores.add(jugadorNuevo);
            }
        }
    }


    private boolean existeJugador(String nombre) {

        for (Jugador jugadorActual : this.jugadores){

            if (jugadorActual.tieneNombre(nombre)){

                return true;
            }
        }

        return false;
    }


    public Jugador getJugadorActual() {

        return (this.jugadores.get(jugadorActual));
    }


    public void avanzarTurno() {

       this.jugadores.get(this.jugadorActual).avanzarTurno();
       // Aca tambien deberia chequear que si el algomon muere le de opcion a elegir otro vivo ya que el actual murio.
       // si no tiene mas vivos perdio. ?
       this.pasarASiguienteJugador();

    }


    public void pasarASiguienteJugador() {

        int totalJugadores = this.jugadores.size();

        if (this.jugadorActual == totalJugadores-1){

            this.jugadorActual = 0;
        }else {

            this.jugadorActual++;
        }
    }


    public void setJugadorActual(String nombreJugador) {

        int totalJugadores = this.jugadores.size();
        for (int i=0; i<totalJugadores; i++){

            Jugador jugadorActual = this.jugadores.get(i);
            if (jugadorActual.tieneNombre(nombreJugador)){
                this.jugadorActual = i;
            }
        }
    }


    private Jugador buscarJugador(String nombreJugador) {

        for (Jugador jugadorActual : this.jugadores){

            if (jugadorActual.tieneNombre(nombreJugador)){

                return jugadorActual;
            }
        }

        return null;
    }


    public boolean hayGanador() {

        boolean ganador = false;

        for (Jugador jugadorActual : this.jugadores){

            if (jugadorActual.perdioPartida()){

                ganador = true;
            }
        }

        return ganador;
    }


    public Jugador getOponente() {

        int totalJugadores = this.jugadores.size();
        int oponente = 0;

        if (this.jugadorActual == totalJugadores-1){

            oponente = 0;
        }else {

            oponente = this.jugadorActual+1;
        }

        return (this.jugadores.get(oponente));
    }


    public ArrayList<Algomon> crearAlgomones(){
        ArrayList<Algomon> listaAlgomones = new ArrayList<Algomon>();

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        Rattata rattata = new Rattata();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();

        listaAlgomones.add(charmander);
        listaAlgomones.add(chansey);
        listaAlgomones.add(bulbasaur);
        listaAlgomones.add(rattata);
        listaAlgomones.add(squirtle);
        listaAlgomones.add(jigglypuff);

        return listaAlgomones;
    }
    
    
    public ArrayList<Elemento> getElementosJugActual(){
    	return this.getJugadorActual().getElementos();
    }
    
    public ArrayList<Ataque> getAtaquesJugAct(){
    	return this.getJugadorActual().getAtaquesAlgomonAct();
    }
    
    public void usarElemento(Elemento elemento) throws ErrorAlgomonMuerto{
    	this.getJugadorActual().aplicarElementoAAlgomonActivo(elemento);
    }
    
    public void cambiarAlgomon(Algomon algomon) throws ErrorCambioAlgomonEsActivo{
    	this.getJugadorActual().cambiarAlgomonActivo(algomon);
    }
    
    public void atacarCon(Ataque ataque) throws ErrorAtaqueDesconocido, ErrorAtaqueImposible, ErrorCantidadAtaque, ErrorAlgomonMuerto {

    	this.getJugadorActual().atacar(getOponente(), ataque);
    	ataque.ejecutarSonido();
    }
    
    public void agregarAlgomon(Jugador jugador,Algomon algomon){
    	jugador.agregarAlgomon(algomon);
    }
    
    
    public ArrayList<Algomon> getAlgomonesVivos(){
    	return this.getJugadorActual().getAlgomonesVivos();
    }


	public String getNombreJugadorActual() {
		return this.getJugadorActual().getNombre();
	}
    
    
    
    public boolean requiereCambioAlgomonActivo(Jugador jugador){
    	return jugador.getAlgomoActivo().estaMuerto();
    }
    
    public ArrayList getAtaques(Algomon algomon){
    	return algomon.getAtaquesPosibles();
    }


	public ArrayList getVidaAlgomon(Algomon algomon) {
		ArrayList lista = new ArrayList();
		lista.add(algomon.getVida());
		return lista;
	}
    
    public String getGanador(){

        Jugador jugadorActual = this.jugadores.get(this.jugadorActual);

        if (jugadorActual.perdioPartida()){

            return (this.getOponente().getNombre());
        }else
        {
            return jugadorActual.getNombre();
        }
    }
    
    
    
    
    
    
    
}


















