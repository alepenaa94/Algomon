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
 * Created by Rodrigo on 08-Nov-16.
 */
public class AtaqueRapidoTest{


    @Test
    public void CharmanderAtacaASquirtleConAtaqueRapido() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(squirtle,charmander);

        assertEquals(140,squirtle.getVida(),0.0001D);

    }


    @Test
    public void SquirtleAtacaACharmander() {

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(charmander,squirtle);

        assertEquals(160,charmander.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaAJigglypuff() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(jigglypuff,bulbasaur);

        assertEquals(120,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void JigglypuffAtacaABulbasaur() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(bulbasaur,jigglypuff);

        assertEquals(130,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaARattata() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(rattata,chansey);

        assertEquals(160,rattata.getVida(),0.0001D);
    }


    @Test
    public void rattataAtacaAChansey() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        AtaqueRapido ataque = new AtaqueRapido();

        assertTrue(ataque.puedeAtacar());

        ataque.atacar(chansey,rattata);

        assertEquals(120,chansey.getVida(),0.0001D);
    }


    @Test
    public void noSePuedeAtacarPorqueSeAgotanLosAtaques() {

        Chansey chansey = new Chansey();
        Rattata rattata = new Rattata();
        AtaqueRapido ataque = new AtaqueRapido();

        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);
        ataque.atacar(chansey,rattata);

        assertFalse(ataque.puedeAtacar());

    }
}