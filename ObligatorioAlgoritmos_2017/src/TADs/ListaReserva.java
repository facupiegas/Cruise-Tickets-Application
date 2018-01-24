
package TADs;

import Interfaces.IListaReserva;


public class ListaReserva implements IListaReserva {

    private NodoReserva inicio;
    private NodoReserva fin;
    private int cantidadReservas;
    
    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    public NodoReserva getInicio() {
        return inicio;
    }

    public void setInicio(NodoReserva inicio) {
        this.inicio = inicio;
    }

    public NodoReserva getFin() {
        return fin;
    }

    public void setFin(NodoReserva fin) {
        this.fin = fin;
    }
    
    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }
    //</editor-fold>
   
    //CONSTRUCTOR
    public ListaReserva(){
        this.inicio=null;
        this.fin=null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Interfaz">
    @Override
    public boolean esVacia() {
        if (this.inicio==null)
            return true;
        else
            return false;
    }

    @Override
    public void agregarInicio(NodoReserva reserva) {
        reserva.setSig(inicio);
        this.inicio=reserva;
        if(this.fin==null){//estoy insertando el primer nodo
            this.fin=reserva;
        }
        this.cantidadReservas++;
    }

    @Override
    public boolean borrar(int cliente) {
        boolean borrado = false;
        NodoReserva aux= this.inicio;
        if(!esVacia()){
            if(aux.getCliente() == cliente)
            {
                inicio = inicio.getSig();
                borrado=true;
                this.cantidadReservas--;
            }
            while (aux.getSig()!=null && !borrado){
                if (aux.getSig().getCliente() == cliente){
                    aux.setSig(aux.getSig().getSig());
                    borrado=true;
                    this.cantidadReservas--;
                }
                else{
                    aux = aux.getSig();
                }
    
            }
        }
        return borrado;
    }
    
    @Override
    public void vaciar() {
            while (inicio!=null)
            borrarInicio();   
    }

    @Override
    public void mostrar() {
        NodoReserva aux = this.inicio;
        int contador = 0;
        while (aux!=null){
            contador++;
            System.out.println(contador +" - Cliente: "+aux.getCliente()+" | "+aux.getCrucero()+" "+aux.getCiudad());
            aux=aux.getSig();
        }
    }
    //</editor-fold>

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }   
    }
    
    public NodoReserva obtenerElemento(int cliente){
        NodoReserva aux=this.inicio;
        while (aux!=null && aux.getCliente() != cliente)
            aux=aux.getSig();
        return aux;
    }
    
    
}
