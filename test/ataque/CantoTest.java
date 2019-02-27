package ataque;

import org.junit.Test;

import algomon.Bulbasaur;
import algomon.Chansey;
import algomon.Charmander;
import algomon.ErrorAtaqueImposible;
import algomon.Jigglypuff;
import algomon.Rattata;
import algomon.Squirtle;
import pantallaSeleccionAlgomon.*;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 09-Nov-16.
 */
public class CantoTest {

    @Test
    public void CharmanderAtacaASquirtle() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(squirtle,charmander);

        assertEquals(150,squirtle.getVida(),0.0001D);

    }


    @Test
    public void SquirtleAtacaACharmander() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(charmander,squirtle);

        assertEquals(170,charmander.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaAJigglypuff() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(jigglypuff,bulbasaur);

        assertEquals(130,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void JigglypuffAtacaABulbasaur() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(bulbasaur,jigglypuff);

        assertEquals(140,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaARattata() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(rattata,chansey);

        assertEquals(170,rattata.getVida(),0.0001D);
    }


    @Test
    public void rattataAtacaAChansey() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Canto ataque = new Canto();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(chansey,rattata);

        assertEquals(130,chansey.getVida(),0.0001D);
    }


    @Test
    public void algomonAtacadoConCantoActualizaEstadoYLuegoEsAtacadoConCantoNuevamente() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey chansey = new Chansey();

        Rattata rattata = new Rattata();

        Canto canto = new Canto();
        AtaqueRapido ataqueRapido = new AtaqueRapido();

        jigglypuff.atacar(rattata, canto);
        chansey.atacar(rattata, canto);

        rattata.actualizarEstado();//Le quedan 2 turnos sin poder atacar

        chansey.atacar(rattata,canto);

        for (int i=0; i<2; i++){

            try {
                rattata.atacar(jigglypuff, ataqueRapido);
                assert false;//No deberia llegar aca
            }
            catch(ErrorAtaqueImposible error) {
                assert true;
            }

            rattata.actualizarEstado();
        }


        try {
            rattata.atacar(chansey, ataqueRapido);
            assert true;
        }catch (ErrorAtaqueImposible error){
            assert false;
        }

    }
}