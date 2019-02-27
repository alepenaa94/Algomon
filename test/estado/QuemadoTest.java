package estado;

import algomon.Charmander;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 10-Nov-16.
 */
public class QuemadoTest {

    @Test
    public void quemadoSeCreaCorrectamentPudiendoAtacar() {

        Quemado quemado = new Quemado();

        assertTrue(quemado.puedeAtacar());

    }


    @Test
    public void actualizarEstadoMantieneElEstadoQuemado() {

        Quemado quemado = new Quemado();

        quemado.actualizarEstado();
        quemado.actualizarEstado();
        quemado.actualizarEstado();
        quemado.actualizarEstado();
        quemado.actualizarEstado();

        assertTrue(quemado.sigueVigente());

    }


    @Test
    public void algomonPierdePorcentajeVida() {

        Quemado quemado = new Quemado();
        Charmander charmander = new Charmander();

        assertEquals(17,quemado.calcularDanios(charmander),0.0001D);

    }
}