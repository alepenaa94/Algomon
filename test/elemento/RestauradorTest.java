package elemento;

import algomon.Bulbasaur;
import algomon.Chansey;
import algomon.Charmander;
import algomon.Squirtle;
import ataque.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 14-Nov-16.
 */
public class RestauradorTest {

    @Test
    public void restauradorSeCreaCorrectamenteCon3DeCantidad(){

        Restaurador restaurador = new Restaurador();

        assertEquals(3,restaurador.getCantidad(),0.0001D);

    }


    @Test
    public void algomonAgotaRestaurador(){

        Restaurador restaurador = new Restaurador();
        Chansey chansey = new Chansey();

        for (int i=0; i<3; i++){

            restaurador.aplicarSobre(chansey);

        }

        try {
            restaurador.aplicarSobre(chansey);
            fail("No deberia llegar aca");
        }catch (ErrorCantidadInsuficiente error){
            assert true;
        }

    }

    @Test
    public void restauradorDevuelveAEstadoNormalAlgomonDormido() {

        Restaurador restaurador = new Restaurador();
        Chansey chansey = new Chansey();
        Squirtle squirtle = new Squirtle();
        Canto ataque = new Canto();
        AtaqueRapido ataqueRapido = new AtaqueRapido();

        chansey.atacar(squirtle,ataque);

        restaurador.aplicarSobre(squirtle);

        squirtle.atacar(chansey,ataqueRapido);

        assertEquals(120,chansey.getVida(),0.0001D);

    }


    @Test
    public void restauradorDevuelveAEstadoNormalAlgomonQuemado() {

        Restaurador restaurador = new Restaurador();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Fogonazo fogonazo = new Fogonazo();
        AtaqueRapido ataqueRapido = new AtaqueRapido();

        charmander.atacar(squirtle,fogonazo);

        assertEquals(149,squirtle.getVida(),0.0001D);

        squirtle.atacar(charmander,ataqueRapido);

        assertEquals(160,charmander.getVida(),0.0001D);

        assertEquals(134,squirtle.getVida(),0.0001D);
        restaurador.aplicarSobre(squirtle);

        squirtle.atacar(charmander,ataqueRapido);

        assertEquals(150,charmander.getVida(),0.0001D);
        assertEquals(134,squirtle.getVida(),0.0001D);



    }


    @Test(expected = ErrorAplicacionImposible.class)
    public void noSePuedeAplicarRestauradorPorqueAlgomonEstaMuerto() {

        Squirtle squirtle = new Squirtle();
        Bulbasaur bulbasaur = new Bulbasaur();
        LatigoCepa latigo = new LatigoCepa();
        Restaurador restaurador = new Restaurador();

        for (int i=0; i<6; i++){

            bulbasaur.atacar(squirtle,latigo);
        }

        restaurador.aplicarSobre(squirtle);
    }
}