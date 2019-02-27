package ataque;

import algomon.Algomon;

import tipo.Tipos;

public abstract class Ataque {

	private double potencia;
	private int cantidad;
	private Tipos tipo;
	
	protected void aplicarEfectosSobreVictima(Algomon victima) {}
	protected void aplicarEfectosSobreAtacante(Algomon atacante, double danioCausado) {}


	public boolean puedeAtacar() {
		return (this.cantidad > 0);
	}

	public int getCantidad(){
		return this.cantidad;
	}

	public void atacar(Algomon victima, Algomon atacante) {
		this.cantidad -= 1;
		
		Tipos tipoAtaque = this.getTipo();
		Tipos tipoVictima = victima.getTipo();
		double potenciaAtaque = this.getPotencia();
		
		double potenciaEfectiva = (tipoAtaque.calcularFactorDePotenciaSobre(tipoVictima))*potenciaAtaque;
		
		double danioCausado = victima.recibirDanio(potenciaEfectiva);
		
		this.aplicarEfectosSobreVictima(victima);
		this.aplicarEfectosSobreAtacante(atacante, danioCausado);
	}
	
	
	public boolean esAtaque(Ataque ataque) {
		return ataque.getClass().equals(this.getClass());
	}


	protected void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	protected double getPotencia() {
		return this.potencia;
	}


	protected void setPotencia(int potencia) {
		this.potencia = potencia;
	}


	protected void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}


	protected Tipos getTipo() {
		return this.tipo;
	}


	public void aumentarCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}
	
	public abstract String toString();
	public abstract void ejecutarSonido();
	
}
