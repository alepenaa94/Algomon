package elemento;

import algomon.Charmander;
import algomon.ErrorAtaqueImposible;
import algomon.Squirtle;
import ataque.AtaqueRapido;
import ataque.Fogonazo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 14-Nov-16.
 */
public class VitaminaTest {

    @Test
    public void vitaminaSeCreaCorrectamenteCon5DeCantidad(){

        Vitamina vitamina = new Vitamina();

        assertEquals(5,vitamina.getCantidad(),0.0001D);

    }


    @Test(expected = ErrorCantidadInsuficiente.class)
    public void algomonAgotaVitamina() {

        Vitamina vitamina = new Vitamina();
        Charmander charmander = new Charmander();

        for (int i=0; i<5; i++){

            vitamina.aplicarSobre(charmander);
        }

        vitamina.aplicarSobre(charmander);

    }

/*
   @Test
    public void vitaminaAumentaLaCantidadDeAtaquesDeAlgomon() {

        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Fogonazo fogonazo = new Fogonazo();
        Vitamina vitamina = new Vitamina();

        for (int i=0; i<4; i++){

            charmander.atacar(squirtle,fogonazo);
        }

        try {
            charmander.atacar(squirtle,fogonazo);
            fail("No deberia llegar aca");
        }catch (ErrorAtaqueImposible error){

            assert true;
        }

        vitamina.aplicarSobre(charmander);

        charmander.atacar(squirtle,fogonazo);

        assertEquals(145,squirtle.getVida(),0.0001D);
    }


    @Test
    public void vitaminaAumentaLaCantidadDeAtaquesRapidosDeAlgomon() {

        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        AtaqueRapido ataque = new AtaqueRapido();
        Vitamina vitamina = new Vitamina();

        for (int i=0; i<16; i++){

            charmander.atacar(squirtle,ataque);
        }

        try {
            charmander.atacar(squirtle,ataque);
            fail("No deberia llegar aca");
        }catch (ErrorAtaqueImposible error){

            assert true;
        }

        vitamina.aplicarSobre(charmander);

        charmander.atacar(squirtle,ataque);

    }*/
}