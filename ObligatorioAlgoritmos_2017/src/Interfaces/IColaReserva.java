
package Interfaces;

import TADs.NodoReserva;

public interface IColaReserva {
    public void encolar(NodoReserva reserva);
    public NodoReserva desencolar();
    public boolean esVacia();
    
}
