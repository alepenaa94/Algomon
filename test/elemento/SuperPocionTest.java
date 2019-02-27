package elemento;

import algomon.Bulbasaur;
import algomon.Squirtle;
import ataque.LatigoCepa;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 14-Nov-16.
 */
public class SuperPocionTest {

    @Test
    public void superPocionSeCreacorrectamenteCon2DeCantidad() {

        SuperPocion superPocion = new SuperPocion();

        assertEquals(2,superPocion.getCantidad(),0.0001D);

    }


    @Test
    public void algomonAgotaSuperPocion(){

        Squirtle squirtle = new Squirtle();
        SuperPocion pocion = new SuperPocion();

        pocion.aplicarSobre(squirtle);
        pocion.aplicarSobre(squirtle);

        try{
            pocion.aplicarSobre(squirtle);
            fail("No deberia llegar aca");
        }catch (ErrorCantidadInsuficiente error){
            assert true;
        }

    }


    @Test
    public void superPocionAumenta40PuntosDeVidaDeAlgomon(){

        SuperPocion superPocion = new SuperPocion();
        Squirtle squirtle = new Squirtle();
        Bulbasaur bulbasaur = new Bulbasaur();
        LatigoCepa latigo = new LatigoCepa();

        bulbasaur.atacar(squirtle,latigo);
        bulbasaur.atacar(squirtle,latigo);

        assertEquals(90,squirtle.getVida(),0.0001D);

        superPocion.aplicarSobre(squirtle);

        assertEquals(130,squirtle.getVida(),0.0001D);
    }
}