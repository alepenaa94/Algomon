package tipo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class FuegoTest {


    @Test
    public void calcularFactorDePotenciaSobrePlantaCorrectamente() {

        Tipos fuego = Tipos.FUEGO;
        Tipos planta = Tipos.PLANTA;

        double efectividaad = fuego.calcularFactorDePotenciaSobre(planta);

        assertEquals(2,efectividaad,0.0001D);

    }


    @Test
    public void calcularFactorDePotenciaSobreAguaCorrectamente() {

        Tipos fuego = Tipos.FUEGO;
        Tipos agua = Tipos.AGUA;

        double efectividaad = fuego.calcularFactorDePotenciaSobre(agua);

        assertEquals(0.5,efectividaad,0.0001D);

    }


    @Test
    public void calcularFactorDePotenciaSobreFuegoCorrectamente() {

        Tipos fuego = Tipos.FUEGO;

        double efectividaad = fuego.calcularFactorDePotenciaSobre(fuego);

        assertEquals(0.5,efectividaad,0.0001D);

    }


    @Test
    public void calcularPotenciaDeComunCorrectamente() {

        Tipos fuego = Tipos.FUEGO;
        Tipos comun = Tipos.COMUN;

        double efectividaad = fuego.calcularFactorDePotenciaSobre(comun);

        assertEquals(1,efectividaad,0.0001D);

    }
}