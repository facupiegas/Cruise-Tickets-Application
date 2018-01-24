
package Interfaces;

import TADs.NodoCruceroRanking;


public interface IListaCruceroRanking {
    public boolean esVacia();
    public void agregarInicio(NodoCruceroRanking crucero);
    public void agregarFinal(NodoCruceroRanking crucero);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public String mostrarListaGeneral();
}
