package algomon;

import ataque.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class RattataTest {

    @Test
    public void rattataSeCreaCorrectamenteCon170DeVida() {

        Rattata rattata = new Rattata();

        assertEquals(170,rattata.getVida(),0.0001D);
    }


    @Test
    public void rattataAtacaCharmanderConBurbuja() {

        Rattata rattata = new Rattata();
        Charmander algomon = new Charmander();
        Burbuja ataque = new Burbuja();

        rattata.atacar(algomon,ataque);

        assertEquals(150,algomon.getVida(),0.0001D);

    }



    @Test
    public void rattataAtacaSquirtleConBurbuja() {

        Rattata rattata = new Rattata();
        Squirtle algomon = new Squirtle();
        Burbuja ataque = new Burbuja();

        rattata.atacar(algomon,ataque);

        assertEquals(145,algomon.getVida(),0.0001D);

    }


    @Test
    public void rattataAtacaBulbasaurConBurbuja() {

        Rattata rattata = new Rattata();
        Bulbasaur algomon = new Bulbasaur();
        Burbuja ataque = new Burbuja();

        rattata.atacar(algomon,ataque);

        assertEquals(135,algomon.getVida(),0.0001D);

    }


    @Test
    public void rattataAtacaChanseyConBurbuja() {

        Rattata rattata = new Rattata();
        Chansey algomon = new Chansey();
        Burbuja ataque = new Burbuja();

        rattata.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test
    public void rattataAtacaJigglypuffConBurbuja() {

        Jigglypuff algomon = new Jigglypuff();
        Rattata rattata = new Rattata();
        Burbuja ataque = new Burbuja();

        rattata.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void rattataAgotaBurbuja() {

        Jigglypuff algomon= new Jigglypuff();
        Rattata rattata = new Rattata();
        Burbuja ataque = new Burbuja();

        for (int i=0; i<15; i++){

            rattata.atacar(algomon,ataque);
        }

        rattata.atacar(algomon,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void rattataNoPuedeAtacarConCanto() {

        Rattata rattata = new Rattata();
        Chansey chansey = new Chansey();
        Canto ataque = new Canto();

        rattata.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void rattataNoPuedeAtacarConCanionDeAgua() {

        Rattata rattata = new Rattata();
        Chansey chansey = new Chansey();
        CanionDeAgua ataque = new CanionDeAgua();

        rattata.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void rattataNoPuedeAtacarConChupavidas() {

        Rattata rattata = new Rattata();
        Chansey chansey = new Chansey();
        Chupavidas ataque = new Chupavidas();

        rattata.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void rattataNoPuedeAtacarConLatigoCepa() {

        Rattata rattata = new Rattata();
        Chansey chansey = new Chansey();
        LatigoCepa ataque = new LatigoCepa();

        rattata.atacar(chansey,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void rattataNoPuedeAtacarConBrasas() {

        Rattata rattata = new Rattata();
        Chansey chansey = new Chansey();
        Brasas ataque = new Brasas();

        rattata.atacar(chansey,ataque);

    }
}