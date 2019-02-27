package algomon;

import ataque.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class SquirtleTest {

    @Test
    public void squirtleSeCreaCorrectamenteCon150DeVida() {

        Squirtle squirtle = new Squirtle();

        assertEquals(150,squirtle.getVida(),0.0001D);
    }


    @Test
    public void squirtleAtacaCharmanderConBurbuja() {

        Squirtle squirtle = new Squirtle();
        Charmander algomon = new Charmander();
        Burbuja ataque = new Burbuja();

        squirtle.atacar(algomon,ataque);

        assertEquals(150,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaBulbasaurConBurbuja() {

        Squirtle squirtle = new Squirtle();
        Bulbasaur algomon = new Bulbasaur();
        Burbuja ataque = new Burbuja();

        squirtle.atacar(algomon,ataque);

        assertEquals(135,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaJigglypuffConBurbuja() {

        Squirtle squirtle = new Squirtle();
        Jigglypuff algomon = new Jigglypuff();
        Burbuja ataque = new Burbuja();

        squirtle.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaChanseyConBurbuja() {

        Squirtle squirtle = new Squirtle();
        Chansey algomon = new Chansey();
        Burbuja ataque = new Burbuja();

        squirtle.atacar(algomon,ataque);

        assertEquals(120,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaRattataConBurbuja() {

        Squirtle squirtle = new Squirtle();
        Rattata algomon = new Rattata();
        Burbuja ataque = new Burbuja();

        squirtle.atacar(algomon,ataque);

        assertEquals(160,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void squirtleAgotaBurbuja() {

        Squirtle squirtle = new Squirtle();
        Rattata algomon = new Rattata();
        Burbuja ataque = new Burbuja();

        for (int i=0; i<15; i++){

            squirtle.atacar(algomon,ataque);
        }

        squirtle.atacar(algomon,ataque);

    }


    @Test
    public void squirtleAtacaCharmanderConCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Charmander algomon = new Charmander();
        CanionDeAgua ataque = new CanionDeAgua();

        squirtle.atacar(algomon,ataque);

        assertEquals(130,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaBulbasaurConCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Bulbasaur algomon = new Bulbasaur();
        CanionDeAgua ataque = new CanionDeAgua();

        squirtle.atacar(algomon,ataque);

        assertEquals(130,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaJigglypuffConCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Jigglypuff algomon = new Jigglypuff();
        CanionDeAgua ataque = new CanionDeAgua();

        squirtle.atacar(algomon,ataque);

        assertEquals(110,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaChanseyConCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Chansey algomon = new Chansey();
        CanionDeAgua ataque = new CanionDeAgua();

        squirtle.atacar(algomon,ataque);

        assertEquals(110,algomon.getVida(),0.0001D);

    }


    @Test
    public void squirtleAtacaRattataConCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Rattata algomon = new Rattata();
        CanionDeAgua ataque = new CanionDeAgua();

        squirtle.atacar(algomon,ataque);

        assertEquals(150,algomon.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void squirtleAgotaCanionDeAgua() {

        Squirtle squirtle = new Squirtle();
        Rattata algomon = new Rattata();
        CanionDeAgua ataque = new CanionDeAgua();

        for (int i=0; i<8; i++){

            squirtle.atacar(algomon,ataque);
        }

        squirtle.atacar(algomon,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void squirtleNoPuedeAtacarConCanto(){

        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();
        Canto ataque = new Canto();

        squirtle.atacar(chansey,ataque);


    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void squirtleNoPuedeAtacarConChupavidas(){

        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();
        Chupavidas ataque = new Chupavidas();

        squirtle.atacar(chansey,ataque);


    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void squirtleNoPuedeAtacarConLatigoCepa(){

        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();
        LatigoCepa ataque = new LatigoCepa();

        squirtle.atacar(chansey,ataque);


    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void squirtleNoPuedeAtacarConBrasas(){

        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();
        Brasas ataque = new Brasas();

        squirtle.atacar(chansey,ataque);


    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void squirtleNoPuedeAtacarConFogonazo(){

        Squirtle squirtle = new Squirtle();
        Chansey chansey = new Chansey();
        Fogonazo ataque = new Fogonazo();

        squirtle.atacar(chansey,ataque);


    }
}