package jugador;

import algomon.*;
import ataque.AtaqueRapido;
import ataque.CanionDeAgua;
import ataque.Fogonazo;
//import com.sun.org.apache.regexp.internal.RE;
import elemento.Pocion;
import elemento.Restaurador;
import elemento.SuperPocion;
import estado.Muerto;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 16-Nov-16.
 */
public class JugadorTest {


    @Test
    public void jugadorSeCreaCorrectamenteConNombre() {

        Jugador jugador = new Jugador("Rodrigo");

        assertTrue(jugador.getNombre()=="Rodrigo");

    }


    @Test
    public void jugadorNoPuedeAgregarAlgomonPorqueYaTiene3() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();

        Jugador jugador = new Jugador("Ash");

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        try {

            jugador.agregarAlgomon(chansey);
            fail("No deberia poder agregar a chansey");
        }catch (ErrorCapacidadMaxima error){

            assert true;
        }

    }


    @Test
    public void jugadorQuitaAlgomonCorrectamente() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();

        Jugador jugador = new Jugador("Ash");

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        jugador.quitarAlgomon(squirtle);

        try {

            jugador.agregarAlgomon(chansey);
            assert true;

        }catch (ErrorCapacidadMaxima error){

            fail("No pudo quitar a squirtle");
        }

    }


    @Test
    public void jugadorNoPuedeQuitarAlgomonPorqueNoLoTiene() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();

        Jugador jugador = new Jugador("Ash");

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);


        try {

            jugador.quitarAlgomon(chansey);
            fail("No deberia tener a chansey");
        }catch (ErrorAlgomonDesconocido error){

            assert true;
        }

    }


    @Test
    public void jugadorAplicaPocionASuAlgomon() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jugador jugador = new Jugador("Ash");
        AtaqueRapido ataqueRapido = new AtaqueRapido();

        charmander.atacar(squirtle,ataqueRapido);

        assertEquals(140,squirtle.getVida(),0.0001D);

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        Pocion pocion = new Pocion();

        jugador.cambiarAlgomonActivo(squirtle);
        jugador.aplicarElementoAAlgomonActivo(pocion);

        assertEquals(150,squirtle.getVida(),0.0001D);

    }


    @Test
    public void jugadorDevuelveElAlgomonAlctualCorrectamente() {

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(bulbasaur,jugador.getAlgomoActivo());

    }


    @Test
    public void jugadorSeleccionaAlgomonCorrectamente() {

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(bulbasaur,jugador.getAlgomoActivo());

        jugador.cambiarAlgomonActivo(squirtle);

        assertEquals(squirtle,jugador.getAlgomoActivo());
    }


    @Test
    public void jugadorDevuelveSusAlgomonesVivos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(3,jugador.getAlgomonesVivos().size(),0.0001D);

    }


    @Test
    public void jugadorDevuelveDosAlgomonesVivos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        squirtle.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(2,jugador.getAlgomonesVivos().size(),0.0001D);

    }


    @Test
    public void jugadorDevuelveUnAlgomonVivo(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        squirtle.setEstado(new Muerto());
        charmander.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(1,jugador.getAlgomonesVivos().size(),0.0001D);

    }


    @Test
    public void jugadorNoDevuelveAlgomonesPorqueEstanTodosMuertos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        squirtle.setEstado(new Muerto());
        charmander.setEstado(new Muerto());
        bulbasaur.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertEquals(0,jugador.getAlgomonesVivos().size(),0.0001D);

    }


    @Test
    public void jugadorPerdioPorqueSeQuedaSinAlgomonesVivos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        squirtle.setEstado(new Muerto());
        charmander.setEstado(new Muerto());
        bulbasaur.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertTrue(jugador.perdioPartida());

    }


    @Test
    public void jugadorNoPerdioPorqueLeQuedaUnAlgomonVivo(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        bulbasaur.setEstado(new Muerto());
        charmander.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertFalse(jugador.perdioPartida());

    }


    @Test
    public void jugadorNoPerdioPorqueLeQuedanDosAlgomonesVivos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        bulbasaur.setEstado(new Muerto());

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertFalse(jugador.perdioPartida());

    }


    @Test
    public void jugadorNoPerdioPorqueTieneTodosAlgomonesVivos(){

        Jugador jugador = new Jugador("Ash");
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        assertFalse(jugador.perdioPartida());

    }


    @Test
    public void jugadorDevuelveSusElementos(){

        Jugador jugador = new Jugador("Ash");

        assertEquals(4,jugador.getElementos().size(),0.0001D);

    }


    @Test
    public void jugadorAplicaSuperPocionAAlgomonActivo() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jugador jugador = new Jugador("Ash");
        AtaqueRapido ataqueRapido = new AtaqueRapido();

        charmander.atacar(squirtle,ataqueRapido);
        charmander.atacar(squirtle,ataqueRapido);
        charmander.atacar(squirtle,ataqueRapido);
        charmander.atacar(squirtle,ataqueRapido);

        assertEquals(110,squirtle.getVida(),0.0001D);

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        SuperPocion superPocion = new SuperPocion();

        jugador.cambiarAlgomonActivo(squirtle);
        jugador.aplicarElementoAAlgomonActivo(superPocion);

        assertEquals(150,squirtle.getVida(),0.0001D);

    }


    @Test
    public void jugadorAplicaRestauradorAlgomonActivo() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jugador jugador = new Jugador("Ash");
        Fogonazo fogonazo = new Fogonazo();
        AtaqueRapido ataque = new AtaqueRapido();

        charmander.atacar(squirtle,fogonazo);

        assertEquals(149,squirtle.getVida(),0.0001D);

        squirtle.atacar(charmander,ataque);

        assertEquals(134,squirtle.getVida(),0.0001D);

        jugador.agregarAlgomon(bulbasaur);
        jugador.agregarAlgomon(charmander);
        jugador.agregarAlgomon(squirtle);

        Restaurador restaurador = new Restaurador();

        jugador.cambiarAlgomonActivo(squirtle);
        jugador.aplicarElementoAAlgomonActivo(restaurador);

        assertEquals(119,squirtle.getVida(),0.0001D);

        squirtle.atacar(charmander,ataque);
        assertEquals(119,squirtle.getVida(),0.0001D);
    }


    @Test
    public void jugadorAtacaAJigglypuffConSquirtleConCanionDeAgua() {

        Jugador jugador = new Jugador("Ash");
        Jugador jugador2 = new Jugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        CanionDeAgua canion = new CanionDeAgua();

        jugador.agregarAlgomon(squirtle);
        jugador.agregarAlgomon(chansey);
        jugador.agregarAlgomon(rattata);

        jugador2.agregarAlgomon(jigglypuff);
        jugador2.agregarAlgomon(charmander);
        jugador2.agregarAlgomon(bulbasaur);

        jugador.atacar(jugador2,canion);

        assertEquals(110,jugador2.getAlgomoActivo().getVida(),0.0001D);
    }


    @Test
    public void jugadorAtacaACharmanderConSquirtleConCanionDeAgua() {

        Jugador jugador = new Jugador("Ash");
        Jugador jugador2 = new Jugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        CanionDeAgua canion = new CanionDeAgua();

        jugador.agregarAlgomon(squirtle);
        jugador.agregarAlgomon(chansey);
        jugador.agregarAlgomon(rattata);

        jugador2.agregarAlgomon(jigglypuff);
        jugador2.agregarAlgomon(charmander);
        jugador2.agregarAlgomon(bulbasaur);
        jugador2.cambiarAlgomonActivo(charmander);

        jugador.atacar(jugador2,canion);

        assertEquals(130,jugador2.getAlgomoActivo().getVida(),0.0001D);
    }


    @Test
    public void jugadorAtacaABulbasaurConSquirtleConCanionDeAgua() {

        Jugador jugador = new Jugador("Ash");
        Jugador jugador2 = new Jugador("Ketchup");

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        CanionDeAgua canion = new CanionDeAgua();

        jugador.agregarAlgomon(squirtle);
        jugador.agregarAlgomon(chansey);
        jugador.agregarAlgomon(rattata);

        jugador2.agregarAlgomon(jigglypuff);
        jugador2.agregarAlgomon(charmander);
        jugador2.agregarAlgomon(bulbasaur);
        jugador2.cambiarAlgomonActivo(bulbasaur);

        jugador.atacar(jugador2,canion);

        assertEquals(130,jugador2.getAlgomoActivo().getVida(),0.0001D);
    }
}