package algomon;

import ataque.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class ChanseyTest {

    @Test
    public void chanseySeCreaCorrectamenteCon130DeVida()  {

        Chansey chansey = new Chansey();

        assertEquals(130,chansey.getVida(),0.0001D);
    }


    @Test
    public void chanseyAtacaCharmanderConLatigoCepa() {

        Chansey chansey = new Chansey();
        Charmander algomon = new Charmander();
        LatigoCepa ataque = new LatigoCepa();

        chansey.atacar(algomon,ataque);

        assertEquals(162.5,algomon.getVida(),0.0001D);

    }


    @Test
    public void chanseyAtacaSquirtleConLatigoCepa() {

        Chansey chansey = new Chansey();
        Squirtle algomon = new Squirtle();
        LatigoCepa ataque = new LatigoCepa();

        chansey.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test
    public void chanseyAtacaBulbasaurConLatigoCepa() {

        Chansey chansey = new Chansey();
        Bulbasaur algomon = new Bulbasaur();
        LatigoCepa ataque = new LatigoCepa();

        chansey.atacar(algomon,ataque);

        assertEquals(132.5,algomon.getVida(),0.0001D);

    }


    @Test
    public void chanseyAtacaJigglypuffConLatigoCepa() {

        Chansey chansey = new Chansey();
        Jigglypuff algomon = new Jigglypuff();
        LatigoCepa ataque = new LatigoCepa();

        chansey.atacar(algomon,ataque);

        assertEquals(115,algomon.getVida(),0.0001D);

    }


    @Test
    public void chanseyAtacaRattataConLatigoCepa() {

        Chansey chansey = new Chansey();
        Rattata algomon = new Rattata();
        LatigoCepa ataque = new LatigoCepa();

        chansey.atacar(algomon,ataque);

        assertEquals(155,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void chanseyAgotaLatigoCepa() {

        Chansey chansey = new Chansey();
        Jigglypuff algomon = new Jigglypuff();
        LatigoCepa ataque = new LatigoCepa();

        for (int i=0; i<10; i++){

            chansey.atacar(algomon,ataque);
        }

        chansey.atacar(algomon,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void chanseyNoPuedeAtacarConBurbuja() {

        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        Burbuja ataque = new Burbuja();

        chansey.atacar(bulbasaur,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void chanseyNoPuedeAtacarConCanionDeAgua() {

        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        CanionDeAgua ataque = new CanionDeAgua();

        chansey.atacar(bulbasaur,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void chanseyNoPuedeAtacarConChupavidas() {

        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        Chupavidas ataque = new Chupavidas();

        chansey.atacar(bulbasaur,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void chanseyNoPuedeAtacarConBrasas() {

        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        Brasas ataque = new Brasas();

        chansey.atacar(bulbasaur,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void chanseyNoPuedeAtacarConFogonazo() {

        Chansey chansey = new Chansey();
        Bulbasaur bulbasaur = new Bulbasaur();
        Fogonazo ataque = new Fogonazo();

        chansey.atacar(bulbasaur,ataque);
    }
}