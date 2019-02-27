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
public class CanionDeAguaTest {

    @Test
    public void CharmanderAtacaASquirtle() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(squirtle,charmander);

        assertEquals(140,squirtle.getVida(),0.0001D);

    }


    @Test
    public void SquirtleAtacaACharmander() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(charmander,squirtle);

        assertEquals(130,charmander.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaAJigglypuff() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(jigglypuff,bulbasaur);

        assertEquals(110,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void JigglypuffAtacaABulbasaur() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(bulbasaur,jigglypuff);

        assertEquals(130,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaARattata() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(rattata,chansey);

        assertEquals(150,rattata.getVida(),0.0001D);
    }


    @Test
    public void rattataAtacaAChansey() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        CanionDeAgua ataque = new CanionDeAgua();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(chansey,rattata);

        assertEquals(110,chansey.getVida(),0.0001D);
    }

}