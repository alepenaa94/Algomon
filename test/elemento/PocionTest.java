package elemento;

import algomon.Charmander;
import algomon.Squirtle;
import ataque.AtaqueRapido;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 14-Nov-16.
 */
public class PocionTest {

    @Test
    public void pocionSeCreaCorrectamenteCon4DeCantidad(){

        Pocion pocion = new Pocion();

        assertEquals(4,pocion.getCantidad(),0.0001D);

    }


    @Test
    public void algomonAgotaPocion() {

        Pocion pocion = new Pocion();
        Charmander charmander = new Charmander();

        for (int i=0; i<4; i++){

            pocion.aplicarSobre(charmander);
        }

        try{

            pocion.aplicarSobre(charmander);
            fail("No deberia llegar aca");
        }catch (ErrorCantidadInsuficiente error){

            assert true;
        }

    }


    @Test
    public void pocionAumenta20PuntosDeVidaDeAlgomon(){

        Squirtle squirtle = new Squirtle();
        Charmander charmander = new Charmander();
        AtaqueRapido ataque = new AtaqueRapido();
        Pocion pocion = new Pocion();

        charmander.atacar(squirtle,ataque);
        charmander.atacar(squirtle,ataque);

        assertEquals(130,squirtle.getVida(),0.0001D);

        pocion.aplicarSobre(squirtle);

        assertEquals(150,squirtle.getVida(),0.0001D);


    }
}