package ataque;

import org.junit.Test;

import algomon.Bulbasaur;
import algomon.Chansey;
import algomon.Charmander;
import algomon.Jigglypuff;
import algomon.Rattata;
import algomon.Squirtle;
import pantallaSeleccionAlgomon.*;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 09-Nov-16.
 */
public class FogonazoTest {

    @Test
    public void CharmanderAtacaASquirtle() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(squirtle,charmander);

        assertEquals(149,squirtle.getVida(),0.0001D);

    }


    @Test
    public void SquirtleAtacaACharmander() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(charmander,squirtle);

        assertEquals(169,charmander.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaAJigglypuff() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(jigglypuff,bulbasaur);

        assertEquals(128,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void JigglypuffAtacaABulbasaur() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(bulbasaur,jigglypuff);

        assertEquals(136,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaARattata() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(rattata,chansey);

        assertEquals(168,rattata.getVida(),0.0001D);
    }


    @Test
    public void rattataAtacaAChansey() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Fogonazo ataque = new Fogonazo();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(chansey,rattata);

        assertEquals(128,chansey.getVida(),0.0001D);
    }

}