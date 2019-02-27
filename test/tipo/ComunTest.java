package tipo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class ComunTest {

    @Test
    public void calcularFactorDePotenciaSobrePlantaCorrectamente() {

        Tipos comun = Tipos.COMUN;
        Tipos planta = Tipos.PLANTA;

        double efectividad = comun.calcularFactorDePotenciaSobre(planta);

        assertEquals(1,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreFuegoCorrectamente() {

        Tipos comun = Tipos.COMUN;
        Tipos fuego = Tipos.FUEGO;

        double efectividad = comun.calcularFactorDePotenciaSobre(fuego);

        assertEquals(1,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreAguaCorrectamente() {

        Tipos comun = Tipos.COMUN;
        Tipos agua = Tipos.AGUA;

        double efectividad = comun.calcularFactorDePotenciaSobre(agua);

        assertEquals(1,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreComunCorrectamente() {

        Tipos comun = Tipos.COMUN;

        double efectividad = comun.calcularFactorDePotenciaSobre(comun);

        assertEquals(1,efectividad,0.0001D);
    }
}