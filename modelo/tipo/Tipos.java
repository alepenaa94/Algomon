package tipo;

public enum Tipos {

	COMUN {
        @Override
        protected double calcularFactorDePotenciaAnteComun() {
            return 1;
        }

        @Override
        protected double calcularFactorDePotenciaAnteFuego() {
            return 1;
        }

        @Override
        protected double calcularFactorDePotenciaAntePlanta() {
            return 1;
        }

        @Override
		public double calcularFactorDePotenciaSobre(Tipos tipo) {
			return tipo.calcularFactorDePotenciaAnteComun();
		}

        @Override
        protected double calcularFactorDePotenciaAnteAgua() {
            return 1;
        }
    },
	
	AGUA {
        @Override
        protected double calcularFactorDePotenciaAnteComun() {
            return 1;
        }

        @Override
        protected double calcularFactorDePotenciaAnteFuego() {
            return 0.5;
        }

        @Override
        protected double calcularFactorDePotenciaAntePlanta() {
            return 2;
        }

        @Override
		public double calcularFactorDePotenciaSobre(Tipos tipo) {
			return tipo.calcularFactorDePotenciaAnteAgua();
		}

        @Override
        protected double calcularFactorDePotenciaAnteAgua() {
            return 0.5;
        }

    },


	FUEGO {
        @Override
        protected double calcularFactorDePotenciaAnteComun() {
            return 1;
        }

        @Override
        protected double calcularFactorDePotenciaAnteFuego() {
            return 0.5;
        }

        @Override
        protected double calcularFactorDePotenciaAntePlanta() {
            return 0.5;
        }

        @Override
		public double calcularFactorDePotenciaSobre(Tipos tipo) {
			return tipo.calcularFactorDePotenciaAnteFuego();
		}

        @Override
        protected double calcularFactorDePotenciaAnteAgua() {
            return 2;
        }

    },
	
	PLANTA {
        @Override
        protected double calcularFactorDePotenciaAnteComun() {
            return 1;
        }

        @Override
        protected double calcularFactorDePotenciaAnteFuego() {
            return 2;
        }

        @Override
        protected double calcularFactorDePotenciaAntePlanta() {
            return 0.5;
        }

        @Override
		public double calcularFactorDePotenciaSobre(Tipos tipo) {
			return tipo.calcularFactorDePotenciaAntePlanta();
		}

        @Override
        protected double calcularFactorDePotenciaAnteAgua() {
            return 0.5;
        }

    };

    protected abstract double calcularFactorDePotenciaAnteComun();
    protected abstract double calcularFactorDePotenciaAnteFuego();
    protected abstract double calcularFactorDePotenciaAntePlanta();
    public abstract double calcularFactorDePotenciaSobre(Tipos tipo);
    protected abstract double calcularFactorDePotenciaAnteAgua();
}
