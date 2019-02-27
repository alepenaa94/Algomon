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
public class BrasasTest {

    @Test
    public void CharmanderAtacaASquirtle() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Brasas ataque = new Brasas();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(squirtle,charmander);

        assertEquals(142,squirtle.getVida(),0.0001D);

    }


    @Test
    public void SquirtleAtacaACharmander() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        Brasas ataque = new Brasas();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(charmander,squirtle);

        assertEquals(162,charmander.getVida(),0.0001D);
    }


    @Test
    public void JigglypuffAtacaABulbasaur() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Brasas ataque = new Brasas();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(bulbasaur,jigglypuff);

        assertEquals(108,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaAJigglypuff() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        Brasas ataque = new Brasas();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(jigglypuff,bulbasaur);

        assertEquals(114,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaARattata() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        Brasas ataque = new Brasas();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(rattata,chansey);

        assertEquals(154,rattata.getVida(),0.0001D);
    }

}