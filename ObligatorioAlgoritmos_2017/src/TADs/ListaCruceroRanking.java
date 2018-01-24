
package TADs;

import Interfaces.IListaCruceroRanking;


public class ListaCruceroRanking implements IListaCruceroRanking{
    
    private NodoCruceroRanking inicio;
    private NodoCruceroRanking fin;

     public NodoCruceroRanking getInicio() {
        return inicio;
    }

    public void setInicio(NodoCruceroRanking inicio) {
        this.inicio = inicio;
    }

    public NodoCruceroRanking getFin() {
        return fin;
    }

    public void setFin(NodoCruceroRanking fin) {
        this.fin = fin;
    }
    
    public ListaCruceroRanking(){
        this.inicio=null;
        this.fin=null;
    }
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
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void agregarInicio(NodoCruceroRanking unCrucero){
        unCrucero.setSig(inicio);
        this.inicio=unCrucero;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=unCrucero;
        }

   

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(NodoCruceroRanking unCrucero){
        if (this.esVacia())
            this.agregarInicio(unCrucero);
        else
        {
            fin.setSig(unCrucero);
            this.fin=unCrucero;
        }       
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public void borrarInicio(){
       if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }             
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public void borrarFin(){
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();
            else{
                NodoCruceroRanking aux = this.inicio;
                while (aux.getSig().getSig() != null)
                    aux=aux.getSig();
                this.fin=aux;
                this.fin.setSig(null);
            }
        }    
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar(){
        while (inicio!=null)
            borrarInicio();
    }
    
    @Override
    public String mostrarListaGeneral(){
        NodoCruceroRanking aux = this.inicio;
        String valorString="";
        String aMostrar = "";
        while (aux != null){
            aMostrar = aux.getCrucero().getCiudad()+" - "+aux.getCrucero().getNombre() +" - "+aux.getCrucero().getRanking();
            System.out.println(aMostrar);
            valorString += aMostrar;
            aux=aux.getSig();
        }   
        return valorString;
    } //1.13
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Otros Métodos (iterativos)">

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(NodoCruceroRanking c){
        if (this.esVacia() || this.inicio.getCrucero().getRanking() <= c.getCrucero().getRanking()){//Agrego el nuevo crucero al inicio si el ranking del mismo es menor a la del primer nodo de la lista
            this.agregarInicio(c);
            return;
        }
        if (this.fin.getCrucero().getRanking() >= c.getCrucero().getRanking()){ //Agrego el nuevo crucero al final si el ranking del mismo es mayor a la del ultimo nodo de la lista
            this.agregarFinal(c);
            return;
        }
        NodoCruceroRanking aux=this.inicio;
        while (aux.getSig() != null && aux.getSig().getCrucero().getRanking() > c.getCrucero().getRanking()) //Si no lo agregue ni en la primer ni la ultima posicion, lo agrego en el lugar correcto
           aux=aux.getSig();
        c.setSig(aux.getSig());
        aux.setSig(c);
    }

    //PRE: 
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(String nombreCrucero, String nombreCiudad){
        boolean borrado = false;
        NodoCruceroRanking aux= this.inicio;
        NodoCruceroRanking auxFin= this.fin;
        if(!esVacia()){
            
            if(auxFin.getCrucero().getNombre() == nombreCrucero && auxFin.getCrucero().getCiudad() == nombreCiudad)
            {
                borrarFin();
                borrado=true;
            }
            
            if(aux.getCrucero().getNombre() == nombreCrucero && aux.getCrucero().getCiudad() == nombreCiudad)
            {
                borrarInicio();
                borrado=true;
            }
            
            if(aux.getSig() != null && !borrado){
                while(aux.getSig().getSig() != null && borrado == false){
                    if(aux.getSig().getCrucero().getNombre() == nombreCrucero && aux.getSig().getCrucero().getCiudad() == nombreCiudad){
                        aux.setSig(aux.getSig().getSig());
                        borrado = true;
                    }
                    else{
                        aux = aux.getSig();
                    }
                }
            }
            
        }
        return borrado;
    }
   

    //PRE: 
    //POS:
    public NodoCruceroRanking obtenerElemento(String nombreCrucero, String nombreCiudad){
        NodoCruceroRanking aux=this.inicio;
        boolean encontre=false;
        while (aux != null && !encontre){            
            if((aux.getCrucero().getNombre() == nombreCrucero && aux.getCrucero().getCiudad() == nombreCiudad))
            {
                encontre = true;
            }
            else{
                aux=aux.getSig();
            }
        }
        //encontre dato o llegue al final
        return aux;
    }
    //</editor-fold>
    
    
    
}
