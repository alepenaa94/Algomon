package Vida;

public class Vida {
	
	private double vidaTotal;
	private double vidaActual;


	public Vida(double puntosDeVida) {
		this.vidaTotal = puntosDeVida;
		this.vidaActual = puntosDeVida;
	}


	/*
	Devuelve la cantidad de puntos que logra quitar
	 */
	public double restarPuntos(double puntosARestar) {
		if( this.vidaActual > puntosARestar ) {
			this.vidaActual -= puntosARestar;
			return puntosARestar;
		}
		else {
			double puntosRestantes = this.vidaActual;
			this.vidaActual = 0;
			return puntosRestantes;
		}
	}


	public double restituirAlTotal() {
		return ( this.vidaActual = this.vidaTotal );
	}


	public void restituirPuntos(double puntosARestituir) {
		this.vidaActual += puntosARestituir;
		if ( this.vidaActual > this.vidaTotal )
			this.vidaActual = this.vidaTotal;
	}


	public double getVidaActual() {
		return this.vidaActual;
	}


	public double getVidaTotal() {
		return this.vidaTotal;
	}


	public boolean muerto() {
		return (this.vidaActual==0);
	}
}
