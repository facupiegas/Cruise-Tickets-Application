
package Interfaces;

import TADs.NodoCiudad;

public interface IListaCiudad {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(NodoCiudad unaCiudad);
    public void agregarFinal(NodoCiudad crucero);
    public void borrarInicio();  
    public void mostrar();
    
    
}
