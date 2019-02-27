package tests;

import ataque.*;
import pantallaSeleccionAlgomon.*;

import org.junit.*;

import algomon.Bulbasaur;
import algomon.Chansey;
import algomon.Charmander;
import algomon.ErrorAtaqueImposible;
import algomon.Jigglypuff;
import algomon.Rattata;
import algomon.Squirtle;

public class AlgomonPrimerEntregaTests {

	@Test
	public void test01SquirtleAtacaCharmanderConBurbujaYcanionDeAgua(){
		
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		CanionDeAgua canionDeAgua = new CanionDeAgua();
		
		squirtle.atacar(charmander, burbuja);
		
		Assert.assertEquals(150, charmander.getVida(), 0.0001D);

		squirtle.atacar(charmander, canionDeAgua);
		
		Assert.assertEquals(110, charmander.getVida(), 0.0001D);
	}


	@Test
	public void test02SquirtleAtacaBulbasaurConBurbujaYcanionDeAgua(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		CanionDeAgua canionDeAgua = new CanionDeAgua();
		
		squirtle.atacar(bulbasaur, burbuja);
		
		Assert.assertEquals(135, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar(bulbasaur, canionDeAgua);
		
		Assert.assertEquals(125, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test03SquirtleAtacaRattataConBurbujaYcanionDeAgua(){
		
		Rattata rattata = new Rattata();
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		CanionDeAgua canionDeAgua = new CanionDeAgua();
		
		squirtle.atacar(rattata, burbuja);
		
		Assert.assertEquals(160, rattata.getVida(), 0.0001D);

		squirtle.atacar(rattata, canionDeAgua);
		
		Assert.assertEquals(140, rattata.getVida(), 0.0001D);
	}


	@Test
	public void test04SquirtleAtacaChanseyConBurbujaYcanionDeAgua(){
		
		Chansey chansey = new Chansey();
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		CanionDeAgua canionDeAgua = new CanionDeAgua();
		
		squirtle.atacar(chansey, burbuja);
		
		Assert.assertEquals(120, chansey.getVida(), 0.0001D);

		squirtle.atacar(chansey, canionDeAgua);
		
		Assert.assertEquals(100, chansey.getVida(), 0.0001D);
	}


	@Test
	public void test05SquirtleAtacaJigglypuffConBurbujaYcanionDeAgua(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Squirtle squirtle = new Squirtle();
		
		Burbuja burbuja = new Burbuja();
		CanionDeAgua canionDeAgua = new CanionDeAgua();
		
		squirtle.atacar(jigglypuff, burbuja);
		
		Assert.assertEquals(120, jigglypuff.getVida(), 0.0001D);

		squirtle.atacar(jigglypuff, canionDeAgua);
		
		Assert.assertEquals(100, jigglypuff.getVida(), 0.0001D);
	}

	@Test
	public void test06BulbasaurYChanseyAtacanSquirtleConLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Chansey chansey = new Chansey();
		
		Squirtle squirtle = new Squirtle();
		
		LatigoCepa latigoCepa = new LatigoCepa();
		
		bulbasaur.atacar(squirtle, latigoCepa);
		chansey.atacar(squirtle, latigoCepa);
		
		Assert.assertEquals(90, squirtle.getVida(), 0.0001D);
	}

	
	@Test
	public void test07BulbasaurYChanseyAtacanCharmanderConLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Chansey chansey = new Chansey();
		
		Charmander charmander = new Charmander();
		
		LatigoCepa latigoCepa = new LatigoCepa();
		
		bulbasaur.atacar(charmander, latigoCepa);
		chansey.atacar(charmander, latigoCepa);
		
		Assert.assertEquals(155, charmander.getVida(), 0.0001D);
	}


	@Test
	public void test08BulbasaurYChanseyAtacanRattataConLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Chansey chansey = new Chansey();
		
		Rattata rattata = new Rattata();
		
		LatigoCepa latigoCepa = new LatigoCepa();
		
		bulbasaur.atacar(rattata, latigoCepa);
		chansey.atacar(rattata, latigoCepa);
		
		Assert.assertEquals(140, rattata.getVida(), 0.0001D);
	}


	@Test
	public void test09BulbasaurYChanseyAtacanJigglypuffConLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Chansey chansey = new Chansey();
		
		Jigglypuff jigglypuff = new Jigglypuff();
		
		LatigoCepa latigoCepa = new LatigoCepa();
		
		bulbasaur.atacar(jigglypuff, latigoCepa);
		chansey.atacar(jigglypuff, latigoCepa);
		
		Assert.assertEquals(100, jigglypuff.getVida(), 0.0001D);
	}


	@Test
	public void test10CharmanderAtacaBulbasaurConBrasas(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		
		charmander.atacar(bulbasaur, brasas);
		
		Assert.assertEquals(108, bulbasaur.getVida(), 0.0001D);
	}


	@Test
	public void test11CharmanderAtacaSquirtleConBrasas(){
		
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		
		charmander.atacar(squirtle, brasas);
		
		Assert.assertEquals(142, squirtle.getVida(), 0.0001D);
	}


	@Test
	public void test12CharmanderAtacaChanseyConBrasas(){
		
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		
		charmander.atacar(chansey, brasas);
		
		Assert.assertEquals(114, chansey.getVida(), 0.0001D);
	}


	@Test
	public void test13CharmanderAtacaJigglypuffConBrasas(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		
		charmander.atacar(jigglypuff, brasas);
		
		Assert.assertEquals(114, jigglypuff.getVida(), 0.0001D);
	}


	@Test
	public void test14CharmanderAtacaRattataConBrasas(){
		
		Rattata rattata = new Rattata();
		Charmander charmander = new Charmander();
		
		Brasas brasas = new Brasas();
		
		charmander.atacar(rattata, brasas);
		
		Assert.assertEquals(154, rattata.getVida(), 0.0001D);
	}


	@Test
	public void test15RattataAtacaConAtaqueRapido(){
		
		Rattata rattata = new Rattata();
		
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		Chansey chansey = new Chansey();
		Jigglypuff jigglypuff = new Jigglypuff();
		
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		
		rattata.atacar(charmander, ataqueRapido);
		rattata.atacar(squirtle, ataqueRapido);
		rattata.atacar(bulbasaur, ataqueRapido);
		rattata.atacar(chansey, ataqueRapido);
		rattata.atacar(jigglypuff, ataqueRapido);
		
		Assert.assertEquals(160, charmander.getVida(), 0.0001D);
		Assert.assertEquals(140, squirtle.getVida(), 0.0001D);
		Assert.assertEquals(130, bulbasaur.getVida(), 0.0001D);
		Assert.assertEquals(120, chansey.getVida(), 0.0001D);
		Assert.assertEquals(120, jigglypuff.getVida(), 0.0001D);
	}
	
	@Test(expected = ErrorCantidadAtaque.class)
	public void test16ChanseyAgotaAtaqueCanto(){
		
		Rattata rattata = new Rattata();

		Chansey chansey = new Chansey();
		
		Canto canto = new Canto();
		for (int x = 0;x<6; x++){
			chansey.atacar(rattata, canto);
		}

		chansey.atacar(rattata, canto);
	}
	
}
