package tipo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class PlantaTest {

    @Test
    public void calcularFactorDePotenciaSobreAgua() {

        Tipos planta = Tipos.PLANTA;
        Tipos agua = Tipos.AGUA;

        double efectividad = planta.calcularFactorDePotenciaSobre(agua);

        assertEquals(2,efectividad,0.0001D);

    }


    @Test
    public void calcularFactorDePotenciaSobreFuego() {

        Tipos planta = Tipos.PLANTA;
        Tipos fuego = Tipos.FUEGO;

        double efectividad = planta.calcularFactorDePotenciaSobre(fuego);

        assertEquals(0.5,efectividad,0.0001D);

    }


    @Test
    public void calcularFactorDePotenciaSobrePlanta() {

        Tipos planta = Tipos.PLANTA;

        double efectividad = planta.calcularFactorDePotenciaSobre(planta);

        assertEquals(0.5,efectividad,0.0001D);

    }


    @Test
    public void calcularFactorDePotenciaSobreComun() {

        Tipos planta = Tipos.PLANTA;
        Tipos comun = Tipos.COMUN;

        double efectividad = planta.calcularFactorDePotenciaSobre(comun);

        assertEquals(1,efectividad,0.0001D);

    }
}