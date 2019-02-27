package algomon;

import ataque.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class CharmanderTest {

    @Test
    public void charmanderSeCreaCorrectamenteCon170DeVida() {

        Charmander charmander = new Charmander();

        assertEquals(170,charmander.getVida(),0.0001D);
    }


    @Test
    public void charmanderAtacaSquirtleConBrasas() {

        Charmander charmander = new Charmander();
        Squirtle algomon = new Squirtle();
        Brasas ataque = new Brasas();

        charmander.atacar(algomon,ataque);

        assertEquals(142,algomon.getVida(),0.0001D);

    }


    @Test
    public void charmanderAtacaBulbasaurConBrasas() {

        Charmander charmander = new Charmander();
        Bulbasaur algomon = new Bulbasaur();
        Brasas ataque = new Brasas();

        charmander.atacar(algomon,ataque);

        assertEquals(108,algomon.getVida(),0.0001D);

    }


    @Test
    public void charmanderAtacaJigglypuffConBrasas() {

        Charmander charmander = new Charmander();
        Jigglypuff algomon = new Jigglypuff();
        Brasas ataque = new Brasas();

        charmander.atacar(algomon,ataque);

        assertEquals(114,algomon.getVida(),0.0001D);

    }


    @Test
    public void charmanderAtacaChanseyConBrasas() {

        Charmander charmander = new Charmander();
        Chansey algomon = new Chansey();
        Brasas ataque = new Brasas();

        charmander.atacar(algomon,ataque);

        assertEquals(114,algomon.getVida(),0.0001D);

    }


    @Test
    public void charmanderAtacaRattataConBrasas() {

        Charmander charmander = new Charmander();
        Rattata algomon = new Rattata();
        Brasas ataque = new Brasas();

        charmander.atacar(algomon,ataque);

        assertEquals(154,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void charmanderAgotaBrasas() {

        Charmander charmander = new Charmander();
        Chansey algomon = new Chansey();
        Brasas ataque = new Brasas();

        for (int i=0; i<10; i++){

            charmander.atacar(algomon,ataque);
        }

        charmander.atacar(algomon,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void charmanderNoPuedeAtacarConCanto() {

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        Canto ataque = new Canto();

        charmander.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void charmanderNoPuedeAtacarConBurbuja() {

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        Burbuja ataque = new Burbuja();

        charmander.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void charmanderNoPuedeAtacarConCanionDeAgua() {

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        CanionDeAgua ataque = new CanionDeAgua();

        charmander.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void charmanderNoPuedeAtacarConChupavidas() {

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        Chupavidas ataque = new Chupavidas();

        charmander.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void charmanderNoPuedeAtacarConLatigoCepa() {

        Charmander charmander = new Charmander();
        Chansey chansey = new Chansey();
        LatigoCepa ataque = new LatigoCepa();

        charmander.atacar(chansey,ataque);

    }
}