
package TADs;

import Interfaces.IColaReserva;

public class ColaReserva implements IColaReserva{
    
    private NodoReserva inicio;
    private NodoReserva fin;

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
    //</editor-fold>  
    
    @Override
    public void encolar(NodoReserva reserva) {
        NodoReserva nuevo = reserva;
		if(fin != null){  
			fin.setSig(nuevo);
			fin = fin.getSig(); 
		}else
			inicio = fin = nuevo;
    }

    @Override
    public NodoReserva desencolar() {
        NodoReserva aux = null;
        if(!esVacia()){
            if(this.inicio == this.fin){
                aux = this.inicio;
                this.inicio = this.fin = null;
            }    
            else{
            aux = this.inicio;
            inicio = inicio.getSig();
            }
        }
	return aux;	
    }

    @Override
    public boolean esVacia() {
        return (this.inicio == null && this.fin == null);
    }
    
    public void mostrar() {
        NodoReserva aux = this.inicio;
        int contador = 0;
        while (aux!=null){
            contador++;
            System.out.println(contador +" - Cliente: "+aux.getCliente()+" | "+aux.getCrucero()+" "+aux.getCiudad());
            aux=aux.getSig();
        } 
    }
    
}
