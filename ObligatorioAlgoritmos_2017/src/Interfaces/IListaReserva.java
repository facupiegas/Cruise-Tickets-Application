
package Interfaces;

import TADs.NodoReserva;


public interface IListaReserva {
    public boolean esVacia();
    public void agregarInicio(NodoReserva reserva);
    public boolean borrar(int cliente);
    public void borrarInicio();
    public void vaciar();
    public void mostrar(); 
}
