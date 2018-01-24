package TADs;

import Interfaces.IListaCruceroNombre;

public class ListaCruceroNombre implements IListaCruceroNombre{
    
    private NodoCruceroNombre inicio;
    private NodoCruceroNombre fin;

    public ListaCruceroNombre(){
        this.inicio=null;
        this.fin=null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public NodoCruceroNombre getInicio() {
        return inicio;
    }

    public void setInicio(NodoCruceroNombre inicio) {
        this.inicio = inicio;
    }

    public NodoCruceroNombre getFin() {
        return fin;
    }

    public void setFin(NodoCruceroNombre fin) {
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
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void agregarInicio(NodoCruceroNombre unCrucero){
        unCrucero.setSig(inicio);
        this.inicio=unCrucero;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=unCrucero;
        }
    
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(NodoCruceroNombre unCrucero){
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
                NodoCruceroNombre aux = this.inicio;
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
    public String mostrar(){
        NodoCruceroNombre aux = this.inicio;
        String valorString = "Cruceros en "+aux.getCrucero().getCiudad()+"\n";
        while (aux != null){
            String aMostrar = aux.getCrucero().getNombre() + " - " +aux.getCrucero().getEstrellas() + " - " + aux.getCrucero().getRanking();
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
    public void agregarOrd(NodoCruceroNombre c){
        if (this.esVacia() || c.getCrucero().getNombre().compareTo(this.inicio.getCrucero().getNombre()) < 0){//Agrego el nuevo crucero al inicio si el ranking del mismo es menor a la del primer nodo de la lista
            this.agregarInicio(c);
            return;
        }
        if (c.getCrucero().getCiudad().compareTo(this.fin.getCrucero().getNombre()) > 0){ //Agrego el nuevo crucero al final si el ranking del mismo es mayor a la del ultimo nodo de la lista
            this.agregarFinal(c);
            return;
        }
        NodoCruceroNombre aux=this.inicio;
        while (aux.getSig() != null && c.getCrucero().getNombre().compareTo(aux.getCrucero().getNombre()) > 0) //Si no lo agregue ni en la primer ni la ultima posicion, lo agrego en el lugar correcto
           aux=aux.getSig();
        c.setSig(aux.getSig());
        aux.setSig(c);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(String nombreCrucero, String nombreCiudad){
        boolean borrado = false;
        NodoCruceroNombre aux= this.inicio;
        NodoCruceroNombre auxFin= this.fin;
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
    public NodoCruceroNombre obtenerElemento(String nombreCrucero, String nombreCiudad){
        NodoCruceroNombre aux=this.inicio;
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
