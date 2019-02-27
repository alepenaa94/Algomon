package estado;

import algomon.Bulbasaur;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 10-Nov-16.
 */
public class DormidoTest {

    @Test
    public void dormidoSeCreaCorrectamenteSinPoderAtacar() {

        Dormido dormido = new Dormido();

        assertFalse(dormido.puedeAtacar());

    }


    @Test
    public void algomonNoRecibeDanioPorEstarDormido() {

        Dormido dormido = new Dormido();
        Bulbasaur bulbasaur = new Bulbasaur();

        assertEquals(0,dormido.calcularDanios(bulbasaur),0.0001D);

    }


    @Test
    public void dormidoSeMantieneConUnaActualizacionDeEstado() {

        Dormido dormido = new Dormido();

        assertTrue(dormido.sigueVigente());

    }


    @Test
    public void dormidoSeMantieneConDosActualizacionesDeEstado() {

        Dormido dormido = new Dormido();

        dormido.actualizarEstado();

        assertTrue(dormido.sigueVigente());

    }


    @Test
    public void dormidoNoSeMantieneConTresActualizacionesDeEstado() {

        Dormido dormido = new Dormido();

        dormido.actualizarEstado();
        dormido.actualizarEstado();
        dormido.actualizarEstado();

        assertFalse(dormido.sigueVigente());

    }


}