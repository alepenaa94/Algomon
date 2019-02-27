package tipo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class AguaTest {

    @Test
    public void calcularFactorDePotenciaSobrePlantaCorrectamente() {

        Tipos agua = Tipos.AGUA;
        Tipos planta = Tipos.PLANTA;

        double efectividad = agua.calcularFactorDePotenciaSobre(planta);

        assertEquals(0.5,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreFuegoCorrectamente() {

        Tipos agua = Tipos.AGUA;
        Tipos fuego = Tipos.FUEGO;

        double efectividad = agua.calcularFactorDePotenciaSobre(fuego);

        assertEquals(2,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreAguaCorrectamente() {

        Tipos agua = Tipos.AGUA;

        double efectividad = agua.calcularFactorDePotenciaSobre(agua);

        assertEquals(0.5,efectividad,0.0001D);
    }


    @Test
    public void calcularFactorDePotenciaSobreComunCorrectamente() {

        Tipos agua = Tipos.AGUA;
        Tipos comun = Tipos.COMUN;

        double efectividad = agua.calcularFactorDePotenciaSobre(comun);

        assertEquals(1,efectividad,0.0001D);
    }
}