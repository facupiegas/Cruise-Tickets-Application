package Interfaces;

import TADs.NodoCruceroNombre;

public interface IListaCruceroNombre {
    public boolean esVacia();
    public void agregarInicio(NodoCruceroNombre crucero);
    public void agregarFinal(NodoCruceroNombre crucero);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public String mostrar();
}
