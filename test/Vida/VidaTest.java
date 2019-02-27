package Vida;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08-Nov-16.
 */
public class VidaTest {

    @Test
    public void vidaSeCreacorrectamente() {

        Vida vida = new Vida(100);

        assertEquals(100,vida.getVidaActual(),0.0001D);
        assertEquals(100,vida.getVidaTotal(),0.0001D);
    }


    @Test
    public void restarPuntosConVidaMayorAPuntosARestar(){

        Vida vida = new Vida(100);

        double puntos = vida.restarPuntos(30);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(70,vida.getVidaActual(),0.0001D);
        assertEquals(30,puntos,0.0001D);

    }


    @Test
    public void restarPuntosConVidaMenorAPuntosARestar(){

        Vida vida = new Vida(100);

        double puntos = vida.restarPuntos(130);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(0,vida.getVidaActual(),0.0001D);
        assertEquals(100,puntos,0.0001D);

    }


    @Test
    public void restarPuntosDosVeces(){

        Vida vida = new Vida(100);

        double puntos = vida.restarPuntos(30);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(30,puntos,0.0001D);
        assertEquals(70,vida.getVidaActual(),0.0001D);

        puntos = vida.restarPuntos(40);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(40,puntos,0.0001D);
        assertEquals(30,vida.getVidaActual(),0.0001D);

    }


    @Test
    public void restarPuntosConVidaEnCero(){

        Vida vida = new Vida(100);

        double puntos = vida.restarPuntos(100);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,puntos,0.0001D);
        assertEquals(0,vida.getVidaActual(),0.0001D);

        puntos = vida.restarPuntos(100);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(0,puntos,0.0001D);
        assertEquals(0,vida.getVidaActual(),0.0001D);

    }


    @Test
    public void restituirAlTotalCorrectamente()  {

        Vida vida = new Vida(100);

        vida.restarPuntos(30);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(70,vida.getVidaActual(),0.0001D);

        vida.restituirAlTotal();

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void restituirAlTotalTeniendoVidaAlMaximo()  {

        Vida vida = new Vida(100);


        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);

        vida.restituirAlTotal();

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void restituirAlTotalTeniendoCeroPuntos()  {

        Vida vida = new Vida(100);

        vida.restarPuntos(100);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(0,vida.getVidaActual(),0.0001D);

        vida.restituirAlTotal();

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void restituirPuntosCorrectamente() {

        Vida vida = new Vida(100);

        vida.restarPuntos(50);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(50,vida.getVidaActual(),0.0001D);

        vida.restituirPuntos(20);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(70,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void restituirPuntosTeniendoCeroPuntos() {

        Vida vida = new Vida(100);

        vida.restarPuntos(100);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(0,vida.getVidaActual(),0.0001D);

        vida.restituirPuntos(20);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(20,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void restituirPuntosConMasPuntosQueTotal() {

        Vida vida = new Vida(100);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);

        vida.restituirPuntos(20);

        assertEquals(100,vida.getVidaTotal(),0.0001D);
        assertEquals(100,vida.getVidaActual(),0.0001D);
    }


    @Test
    public void estaMuerto() {

        Vida vida = new Vida(100);

        vida.restarPuntos(100);

        assertTrue(vida.muerto());
    }


    @Test
    public void estaMuertoYReviveAlRestituirPuntos() {

        Vida vida = new Vida(100);

        vida.restarPuntos(100);

        assertTrue(vida.muerto());

        vida.restituirAlTotal();

        assertFalse(vida.muerto());
    }
}