
package Interfaces;

import TADs.NodoCrucero;


public interface IListaCrucero {

    public boolean esVacia();
    public void agregarInicio(NodoCrucero crucero);
    public void agregarFinal(NodoCrucero crucero);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrarCrucerosDeCiudad();
    public void mostrarListaGeneral();
    public String mostrarRecursivoDesc(NodoCrucero aux);
    public String mostrarRecursivoAsc(NodoCrucero aux);
    
}
