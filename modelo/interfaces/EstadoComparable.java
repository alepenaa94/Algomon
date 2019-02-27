
package interfaces;

import estado.*;

public interface EstadoComparable{
  public abstract boolean esEstado(EstadoComparable estado);
  public abstract boolean esEstado(Dormido estado);
  public abstract boolean esEstado(Muerto estado);
  public abstract boolean esEstado(Quemado estado);

}
