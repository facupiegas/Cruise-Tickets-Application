package TADs;

import Interfaces.IListaCiudad;


public class ListaCiudad implements IListaCiudad {
    private NodoCiudad inicio;
    private NodoCiudad fin;
    private int cantelementos;
    private int capacidad;

    public ListaCiudad() {
        this.inicio = null;
        this.cantelementos=0;
        this.capacidad = 0; //atributo que me permite controlar si se ha alcanzado le numero maximo de ciudades permitidas al ingresar una nueva
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">   
    //Inicio
    public void setInicio(NodoCiudad i){
        inicio=i;
    }
    public NodoCiudad getInicio(){
        return inicio;
    }
    
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
        public NodoCiudad getFin() {
        return fin;
    }

    public void setFin(NodoCiudad fin) {
        this.fin = fin;
    }
    
    
    //</editor-fold>

     
    //<editor-fold defaultstate="collapsed" desc="Métodos Básicos">

    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
    }
    
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar(){
        while (inicio!=null)
            borrarInicio();
    }
    
    public NodoCiudad buscarciudad(String unaCiudad){
       NodoCiudad aux = this.inicio;
       NodoCiudad retorno = null;
       boolean encontre = false;
       while (aux != null && !encontre){
            if (aux.getNombre() == unaCiudad){
                retorno = aux;
                encontre=true;
            }
            aux=aux.getSig();
         }
        return retorno;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void agregarInicio(NodoCiudad unaCiudad){
       unaCiudad.setSig(inicio);
       this.inicio=unaCiudad;
       if(this.fin == null)
       {
           this.fin = unaCiudad;
       }
       this.cantelementos++;
    }   
    
    @Override
    public void agregarFinal(NodoCiudad ciudad) {
        if (this.esVacia())
            this.agregarInicio(ciudad);
        else
        {
            fin.setSig(ciudad);
            this.fin=ciudad;
            this.cantelementos++;
        }
    }
    
    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar(){
    NodoCiudad aux = this.inicio;
    while (aux!=null){
        System.out.println(" Ciudad: "+aux.getNombre());
        aux=aux.getSig();
    }     
}

    @Override
    public void borrarInicio() {
        if (!this.esVacia())
        this.inicio=this.inicio.getSig();
    }
    //</editor-fold>

}