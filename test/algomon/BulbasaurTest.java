package algomon;

import ataque.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class BulbasaurTest {

    @Test
    public void bulbasaurSeCreaCorrectamenteCon140DeVida() {

        Bulbasaur bulbasaur = new Bulbasaur();

        Assert.assertEquals(140,bulbasaur.getVida(),0.0001D);
    }


    @Test
    public void bulbasaurAtacaACharmanderConLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        LatigoCepa ataque = new LatigoCepa();

        bulbasaur.atacar(charmander,ataque);

        Assert.assertEquals(162.5,charmander.getVida(),0.0001D);

    }


    @Test
    public void bulbasaurAtacaASquirtleConLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Squirtle squirtle = new Squirtle();
        LatigoCepa ataque = new LatigoCepa();

        bulbasaur.atacar(squirtle, ataque);

        Assert.assertEquals(120, squirtle.getVida(), 0.0001D);

    }


    @Test
    public void bulbasaurAtacaAJigglypuffConLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Jigglypuff jigglypuff = new Jigglypuff();
        LatigoCepa ataque = new LatigoCepa();

        bulbasaur.atacar(jigglypuff,ataque);

        Assert.assertEquals(115,jigglypuff.getVida(),0.0001D);

    }


    @Test
    public void bulbasaurAtacaAChanseyConLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Chansey chansey = new Chansey();
        LatigoCepa ataque = new LatigoCepa();

        bulbasaur.atacar(chansey,ataque);

        Assert.assertEquals(115,chansey.getVida(),0.0001D);

    }


    @Test
    public void bulbasaurAtacaARattataConLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Rattata rattata = new Rattata();
        LatigoCepa ataque = new LatigoCepa();

        bulbasaur.atacar(rattata,ataque);

        Assert.assertEquals(155,rattata.getVida(),0.0001D);

    }


    @Test(expected = ErrorCantidadAtaque.class)
    public void bulbasaurAgotaLatigoCepa() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Rattata rattata = new Rattata();
        LatigoCepa ataque = new LatigoCepa();

        for (int i=0; i<10; i++)
            bulbasaur.atacar(rattata,ataque);
        
        bulbasaur.atacar(rattata, ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void bulbasaurNoPuedeAtacarConCanto() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Canto ataque = new Canto();

        bulbasaur.atacar(charmander, ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void bulbasaurNoPuedeAtacarConBurbuja() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Burbuja ataque = new Burbuja();

        bulbasaur.atacar(charmander,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void bulbasaurNoPuedeAtacarConCanionDeAgua() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        CanionDeAgua ataque = new CanionDeAgua();

        bulbasaur.atacar(charmander,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void bulbasaurNoPuedeAtacarConBrasas() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Brasas ataque = new Brasas();

        bulbasaur.atacar(charmander,ataque);

    }


    @Test(expected = ErrorAtaqueDesconocido.class)
    public void bulbasaurNoPuedeAtacarConFogonazo() {

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Fogonazo ataque = new Fogonazo();

        bulbasaur.atacar(charmander,ataque);

    }


    @Test
    public void bulbasaurEstaMuerto(){

        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        AtaqueRapido ataque = new AtaqueRapido();
        Brasas brasas = new Brasas();

        for (int i=0; i<10; i++){

            charmander.atacar(bulbasaur,ataque);
        }

        Assert.assertFalse(bulbasaur.estaMuerto());

        for (int i=0; i<3; i++){

            charmander.atacar(bulbasaur,brasas);
        }

        Assert.assertTrue(bulbasaur.estaMuerto());

    }
}
