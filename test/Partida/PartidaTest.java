package Partida;

import algomon.*;
import ataque.AtaqueRapido;
import ataque.Canto;
import ataque.Fogonazo;
import elemento.Pocion;
import estado.Muerto;
import jugador.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 16-Nov-16.
 */
public class PartidaTest {

    @Test
    public void agregarCorrectamenteDosJugadoresAPartida(){

        Partida partida = new Partida();

        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

    }


    @Test
    public void partidaDevuelveAlJugadorActualCorrectamente() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

        assertTrue(partida.getJugadorActual().getNombre()=="Ash");

    }


    @Test
    public void avanzarTurnoPasaAlSiguienteJugador() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");
        partida.setJugadorActual("Ash");

        assertTrue(partida.getJugadorActual().getNombre()=="Ash");

        partida.avanzarTurno();

        assertTrue(partida.getJugadorActual().getNombre()=="Ketchup");

    }


    @Test
    public void avanzarTurnoPasaAlSiguienteJugadorvolviendoAlPrimero() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");
        partida.setJugadorActual("Ash");

        assertTrue(partida.getJugadorActual().getNombre()=="Ash");

        partida.avanzarTurno();

        assertTrue(partida.getJugadorActual().getNombre()=="Ketchup");

        partida.avanzarTurno();

        assertTrue(partida.getJugadorActual().getNombre()=="Ash");

    }


    @Test
    public void noSePuedeAgregarJugadorSinNombre() {

        Partida partida = new Partida();

        try {
            partida.crearYAgregarJugador("");
            fail("El nombre estaba vacio");
        }catch (NombreVacioError error){

            assert true;
        }

    }


    @Test
    public void noSePuedeAgregarJugadorPorqueYaExisteUnoConEseNombre(){

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Rodrigo");
        partida.crearYAgregarJugador("Martin");
        partida.crearYAgregarJugador("Damian");
        partida.crearYAgregarJugador("Alejandro");

        try {

            partida.crearYAgregarJugador("Rodrigo");
            fail("Deberia haber saltado excepcion de nombre repetido");
        }catch (NombreJugadorRepetidoError error){

            assert true;
        }

    }


    @Test
    public void juagdorGanaPartidaPorqueElOponenteSeQuedaSinAlgomonesVivos() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

        Jugador jugador = partida.getJugadorActual();
        partida.avanzarTurno();
        Jugador jugador2 = partida.getJugadorActual();

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();

        squirtle.setEstado(new Muerto());
        charmander.setEstado(new Muerto());
        bulbasaur.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        jugador2.agregarAlgomon(jigglypuff);
        jugador2.agregarAlgomon(chansey);
        jugador2.agregarAlgomon(rattata);

        assertTrue(partida.hayGanador());

    }


    @Test
    public void jugadorTieneAlgomonQuemadoYRecibeDanioCuandoAtacaConEste(){

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Fogonazo fogonazo = new Fogonazo();
        AtaqueRapido ataque = new AtaqueRapido();

        partida.getJugadorActual().agregarAlgomon(rattata);
        partida.getJugadorActual().agregarAlgomon(charmander);
        partida.getJugadorActual().agregarAlgomon(bulbasaur);

        partida.pasarASiguienteJugador();

        partida.getJugadorActual().agregarAlgomon(squirtle);
        partida.getJugadorActual().agregarAlgomon(jigglypuff);
        partida.getJugadorActual().agregarAlgomon(chansey);

        partida.pasarASiguienteJugador();

        partida.getJugadorActual().cambiarAlgomonActivo(charmander);

        partida.getJugadorActual().atacar(partida.getOponente(),fogonazo);

        partida.avanzarTurno();

        assertEquals(149,partida.getJugadorActual().getAlgomoActivo().getVida(),0.0001D);

        partida.getJugadorActual().atacar(partida.getOponente(),ataque);

        assertEquals(134,partida.getJugadorActual().getAlgomoActivo().getVida(),0.0001D);

        partida.avanzarTurno();

        assertEquals(160,partida.getJugadorActual().getAlgomoActivo().getVida(),0.0001D);
    }


    @Test
    public void jugadorTieneAlgomonDormidoYNoPuedeAtacarPor3Turnos() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Canto canto = new Canto();
        AtaqueRapido ataque = new AtaqueRapido();
        Pocion pocion = new Pocion();

        partida.getJugadorActual().agregarAlgomon(rattata);
        partida.getJugadorActual().agregarAlgomon(charmander);
        partida.getJugadorActual().agregarAlgomon(bulbasaur);

        partida.pasarASiguienteJugador();//Ketchup

        partida.getJugadorActual().agregarAlgomon(squirtle);
        partida.getJugadorActual().agregarAlgomon(jigglypuff);
        partida.getJugadorActual().agregarAlgomon(chansey);

        partida.pasarASiguienteJugador();//Ash

        partida.getJugadorActual().cambiarAlgomonActivo(charmander);

        partida.pasarASiguienteJugador();//Ketchup
        partida.getJugadorActual().cambiarAlgomonActivo(chansey);

        partida.getJugadorActual().atacar(partida.getOponente(),canto);

        partida.avanzarTurno();//Pasa a Ash

        try {

            partida.getJugadorActual().atacar(partida.getOponente(),ataque);
            fail("Deberia saltar excepcion porque Charmander esta dormido");
        }catch (ErrorAtaqueImposible error){

            assert true;
        }

        partida.avanzarTurno();//Le quedan 2 turnos sin poder atacar a Charmander
        partida.getJugadorActual().aplicarElementoAAlgomonActivo(pocion);

        partida.avanzarTurno();//Pasa a Ash

        try {

            partida.getJugadorActual().atacar(partida.getOponente(),ataque);
            fail("Deberia saltar excepcion porque Charmander esta dormido");
        }catch (ErrorAtaqueImposible error){

            assert true;
        }

        partida.avanzarTurno();//Le quedan 1 turno sin poder atacar a Charmander
        partida.getJugadorActual().aplicarElementoAAlgomonActivo(pocion);

        partida.avanzarTurno();//Pasa a Ash

        try {

            partida.getJugadorActual().atacar(partida.getOponente(),ataque);
            fail("Deberia saltar excepcion porque Charmander esta dormido");
        }catch (ErrorAtaqueImposible error){

            assert true;
        }

        partida.avanzarTurno();//Charmander puede atacar la proxima
        partida.getJugadorActual().aplicarElementoAAlgomonActivo(pocion);

        partida.avanzarTurno();//Ash

        partida.getJugadorActual().atacar(partida.getOponente(),ataque);
        partida.avanzarTurno();

        assertEquals(120,partida.getJugadorActual().getAlgomoActivo().getVida(),0.0001D);

    }


    @Test
    public void obtenerGanadorCorrectamente() {

        Partida partida = new Partida();
        partida.crearYAgregarJugador("Ash");
        partida.crearYAgregarJugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Canto canto = new Canto();
        AtaqueRapido ataque = new AtaqueRapido();
        Pocion pocion = new Pocion();
        rattata.setEstado(new Muerto());
        charmander.setEstado(new Muerto());
        bulbasaur.setEstado(new Muerto());

        partida.getJugadorActual().agregarAlgomon(rattata);
        partida.getJugadorActual().agregarAlgomon(charmander);
        partida.getJugadorActual().agregarAlgomon(bulbasaur);

        partida.pasarASiguienteJugador();//Ketchup

        partida.getJugadorActual().agregarAlgomon(squirtle);
        partida.getJugadorActual().agregarAlgomon(jigglypuff);
        partida.getJugadorActual().agregarAlgomon(chansey);

        assertTrue(partida.hayGanador());
        assertEquals("Ketchup",partida.getGanador());


    }
}