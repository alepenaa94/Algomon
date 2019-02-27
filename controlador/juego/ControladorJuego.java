package juego;

import java.util.ArrayList;

import Partida.Partida;
import algomon.Algomon;
import algomon.ErrorAlgomonMuerto;
import algomon.ErrorAtaqueImposible;
import ataque.Ataque;
import ataque.ErrorAtaqueDesconocido;
import ataque.ErrorCantidadAtaque;
import elemento.Elemento;
import jugador.ErrorCambioAlgomonEsActivo;
import jugador.Jugador;

public class ControladorJuego {

	Partida partida;
	
	public ControladorJuego(){
		this.partida = new Partida();
	}

	public Partida getPartida() {
		return this.partida;
	}


	public void crearJugadores(String jugador,String oponente){
		this.partida.crearYAgregarJugador(jugador);
		this.partida.crearYAgregarJugador(oponente);
	}
	
	public void setAlgomon(Jugador jugador,Algomon algomon) {
		this.partida.agregarAlgomon(jugador,algomon);
		this.partida.pasarASiguienteJugador();	
	}
	
	public ArrayList<Elemento> getElementos(){
		return this.partida.getElementosJugActual();
	}

	public ArrayList<Ataque> getAtaques() {
		return this.partida.getAtaquesJugAct();
	}
	
	public void usarElemento (Elemento elemento) throws ErrorAlgomonMuerto {
		this.partida.usarElemento(elemento);
	}
	
	public void cambiarAlgomon(Algomon algomon) throws ErrorCambioAlgomonEsActivo{
		this.partida.cambiarAlgomon(algomon);
		
	}
	
	public void atacarCon(Ataque ataque) throws ErrorAtaqueDesconocido, ErrorAtaqueImposible, ErrorCantidadAtaque,  ErrorAlgomonMuerto{
		this.partida.atacarCon(ataque);
	}
	
    public ArrayList<Algomon> getAlgomonesVivos(){
    	return this.partida.getAlgomonesVivos();
    }

    public void proximoAlgomonVivo(){
    	this.getJugadorActual().cambiarAlgomonActivo(this.getAlgomonesVivos().get(0));
    }
    
	public void avanzarTurno() {
		this.partida.avanzarTurno();
		
	}

	public String getNombreJugadorActual() {
		return this.partida.getNombreJugadorActual();
	}
	
	public String getNombreJugadorOponente(){
		return partida.getOponente().getNombre();
	}
	
	public boolean requiereCambioAlgomonActivo(Jugador jugador){
		return this.partida.requiereCambioAlgomonActivo(jugador);
	}

	public Jugador getJugadorActual() {
		return this.partida.getJugadorActual();
	}
	
	public Jugador getJugadorOponente() {
		return this.partida.getOponente();
	}
	
	public ArrayList getAtaques(Algomon algomon){
		return this.partida.getAtaques(algomon);
	}

	public ArrayList getVida(Algomon algomon) {
		return this.partida.getVidaAlgomon(algomon);
	}
	
	
	public ArrayList<Algomon> getAlgomonesParaElegir() {
		return this.partida.crearAlgomones();
	}

	public String getNombreAlgomon(Algomon algomon) {
		return algomon.getClass().getSimpleName();
	}
	
	public void limpiarSeleccionAlgomon(){
		for ( Algomon algomon:this.getJugadorActual().getAlgomonesVivos()){
			this.getJugadorActual().quitarAlgomon(algomon);
		}
		for ( Algomon algomon:this.getJugadorOponente().getAlgomonesVivos()){
			this.getJugadorOponente().quitarAlgomon(algomon);
		}
		
	}
	
	public Algomon getAlgomonActivo(Jugador jugador){
		return jugador.getAlgomoActivo();
	}

	public double getVidaActualAlgomon(Jugador jugador){
		return jugador.getAlgomoActivo().getVida();
	}
	
	public double getVidaTotalAlgomon(Jugador jugador){
		return jugador.getAlgomoActivo().getVidaTotal();
	}

	public boolean esJuegoTerminado() {
		return this.partida.hayGanador();
	}
	
	public String getGanador(){
		return this.partida.getGanador();
	}
}
