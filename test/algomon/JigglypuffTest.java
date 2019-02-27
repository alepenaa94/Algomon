package algomon;

import ataque.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class JigglypuffTest {

    @Test
    public void jigglypuffSeCreaCorrectamenteCon130DeVida(){

        Jigglypuff jigglypuff = new Jigglypuff();

        assertEquals(130,jigglypuff.getVida(),0.0001D);
    }


    @Test
    public void jigglypuffAtacaCharmanderConBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Charmander algomon = new Charmander();
        Burbuja ataque = new Burbuja();

        jigglypuff.atacar(algomon,ataque);

        assertEquals(150,algomon.getVida(),0.0001D);

    }



    @Test
    public void jigglypuffAtacaSquirtleConBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle algomon = new Squirtle();
        Burbuja ataque = new Burbuja();

        jigglypuff.atacar(algomon,ataque);

        assertEquals(145,algomon.getVida(),0.0001D);

    }


    @Test
    public void jigglypuffAtacaBulbasaurConBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Bulbasaur algomon = new Bulbasaur();
        Burbuja ataque = new Burbuja();

        jigglypuff.atacar(algomon,ataque);

        assertEquals(135,algomon.getVida(),0.0001D);

    }


    @Test
    public void jigglypuffAtacaChanseyConBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Chansey algomon = new Chansey();
        Burbuja ataque = new Burbuja();

        jigglypuff.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test
    public void jigglypuffAtacaRattataConBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Rattata algomon = new Rattata();
        Burbuja ataque = new Burbuja();

        jigglypuff.atacar(algomon,ataque);

        assertEquals(160,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void jigglypuffAgotaBurbuja() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Rattata algomon = new Rattata();
        Burbuja ataque = new Burbuja();

        for (int i=0; i<15; i++){

            jigglypuff.atacar(algomon,ataque);
        }

        jigglypuff.atacar(algomon,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void jigglypuffNoPuedeAtacarConCanionDeAgua() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle squirtle = new Squirtle();
        CanionDeAgua ataque = new CanionDeAgua();

        jigglypuff.atacar(squirtle,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void jigglypuffNoPuedeAtacarConChupavidas() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle squirtle = new Squirtle();
        Chupavidas ataque = new Chupavidas();

        jigglypuff.atacar(squirtle,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void jigglypuffNoPuedeAtacarConLatigoCepa() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle squirtle = new Squirtle();
        LatigoCepa ataque = new LatigoCepa();

        jigglypuff.atacar(squirtle,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void jigglypuffNoPuedeAtacarConBrasas() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle squirtle = new Squirtle();
        Brasas ataque = new Brasas();

        jigglypuff.atacar(squirtle,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void jigglypuffNoPuedeAtacarConFogonazo() {

        Jigglypuff jigglypuff = new Jigglypuff();
        Squirtle squirtle = new Squirtle();
        Fogonazo ataque = new Fogonazo();

        jigglypuff.atacar(squirtle,ataque);

    }
}