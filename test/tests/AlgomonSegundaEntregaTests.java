package tests;

import ataque.*;
import jugador.Jugador;
import pantallaSeleccionAlgomon.*;

import org.junit.*;

import algomon.Bulbasaur;
import algomon.Chansey;
import algomon.Charmander;
import algomon.ErrorAtaqueImposible;
import algomon.Jigglypuff;
import algomon.Rattata;
import algomon.Squirtle;

import static org.junit.Assert.fail;

public class AlgomonSegundaEntregaTests {

	@Test
	public void test01JigglypuffYChanseyAtacanRattataConCantoYNoPuedeAtacar(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chansey = new Chansey();
		
		Rattata rattata = new Rattata();
		
		Canto canto = new Canto();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		
		jigglypuff.atacar(rattata, canto);
		chansey.atacar(rattata, canto);
		
		for(int i = 0 ; i <3  ; i++) {
			try {
				rattata.atacar(jigglypuff, ataqueRapido);
				assert false;//No deberia llegar aca
			}
			catch(ErrorAtaqueImposible error) {
				assert true;
			}
			
			rattata.actualizarEstado();
		}
		
		try {
			rattata.atacar(jigglypuff, ataqueRapido);
		}
		catch(ErrorAtaqueImposible error) {
			fail("Rattata deberia poder atacar");
		}
	}


	@Test
	public void test02BulbasaurAtacaConChupavidasACharmanderYGanaVida(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		charmander.atacar(bulbasaur, brasas);
		//Vida bulbasaur 108

		Chupavidas chupavidas = new Chupavidas();
		
		bulbasaur.atacar(charmander, chupavidas);
		bulbasaur.atacar(charmander, chupavidas);
		bulbasaur.atacar(charmander, chupavidas);
		bulbasaur.atacar(charmander, chupavidas);
		//Vida bulbasaur 117
		
		Assert.assertEquals(117, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtleYGanaVida(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		squirtle.atacar(bulbasaur, burbuja);
		squirtle.atacar(bulbasaur, burbuja);
		
		//Vida bulbasaur 130
		Assert.assertEquals(130, bulbasaur.getVida(), 0.0001D);
		
		Chupavidas chupavidas = new Chupavidas();
		bulbasaur.atacar(squirtle, chupavidas);
		//Vida bulbasaur 139
		
		Assert.assertEquals(139, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test04BulbasaurAtacaConChupavidasAChanseyYGanaVida(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Chansey chansey = new Chansey();
		
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		chansey.atacar(bulbasaur, ataqueRapido);
		
		//Vida bulbasaur 130
		Assert.assertEquals(130, bulbasaur.getVida(), 0.0001D);
		
		Chupavidas chupavidas = new Chupavidas();
		bulbasaur.atacar(chansey, chupavidas);
		//Vida bulbasaur 134.5
		
		Assert.assertEquals(134.5, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test05BulbasaurAtacaConChupavidasAJigglypuffYGanaVida(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Jigglypuff jigglypuff = new Jigglypuff();
		
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		jigglypuff.atacar(bulbasaur, ataqueRapido);
		
		//Vida bulbasaur 130
		Assert.assertEquals(130, bulbasaur.getVida(), 0.0001D);
		
		Chupavidas chupavidas = new Chupavidas();
		bulbasaur.atacar(jigglypuff, chupavidas);
		//Vida bulbasaur 134.5
		
		Assert.assertEquals(134.5, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test06BulbasaurAtacaConChupavidasARattataYGanaVida(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Rattata rattata = new Rattata();
		
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		rattata.atacar(bulbasaur, ataqueRapido);
		
		//Vida bulbasaur 130
		Assert.assertEquals(130, bulbasaur.getVida(), 0.0001D);
		
		Chupavidas chupavidas = new Chupavidas();
		bulbasaur.atacar(rattata, chupavidas);
		//Vida bulbasaur 134.5
		
		Assert.assertEquals(134.5, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test07CharmanderYRattataAtacanConFogonazoYSeAplicaEfectosDeEstadoAlEnemigo(){
		
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		//Vida bulbasaur 140
		Fogonazo fogonazo = new Fogonazo();
		//Danio fogonazo = 2
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Jugador jugador = new Jugador("jugador 1");
		jugador.agregarAlgomon(bulbasaur);

		rattata.atacar(bulbasaur, fogonazo);
		jugador.avanzarTurno();
		Assert.assertEquals(136, bulbasaur.getVida(), 0.0001D);
		charmander.atacar(bulbasaur, fogonazo);
		Assert.assertEquals(132, bulbasaur.getVida(), 0.0001D);
		
		jugador.avanzarTurno();
		bulbasaur.atacar(charmander,ataqueRapido);
		Assert.assertEquals(118, bulbasaur.getVida(), 0.0001D);
		jugador.avanzarTurno();
		bulbasaur.atacar(charmander,ataqueRapido);
		Assert.assertEquals(104, bulbasaur.getVida(), 0.0001D);
		jugador.avanzarTurno();
		bulbasaur.atacar(charmander,ataqueRapido);
		Assert.assertEquals(90, bulbasaur.getVida(), 0.0001D);
	}
	
}
