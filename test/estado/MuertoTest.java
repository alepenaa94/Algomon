package estado;

import algomon.Squirtle;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 09-Nov-16.
 */
public class MuertoTest {

    @Test
    public void muertoSeCreCorrectamenteSinPoderAtacar() {

        Muerto muerto = new Muerto();

        assertFalse(muerto.puedeAtacar());

    }


    @Test
    public void actualizarEstadoDevuelveVerdader() {

        Muerto muerto = new Muerto();

        assertTrue(muerto.sigueVigente());

    }


    @Test
    public void calcularDaniosDevuelveDaniosNulos() {

        Muerto muerto = new Muerto();
        Squirtle squirtle = new Squirtle();

        assertEquals(0,muerto.calcularDanios(squirtle),0.0001D);

    }
}