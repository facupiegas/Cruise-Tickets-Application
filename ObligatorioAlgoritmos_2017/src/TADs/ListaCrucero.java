package TADs;

import Interfaces.IListaCrucero;

public class ListaCrucero implements IListaCrucero {
    
    private NodoCrucero inicio;
    private NodoCrucero fin;
    private String cadena;

    

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public ListaCrucero(){
        this.inicio=null;
        this.fin=null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    //Inicio
    public void setInicio(NodoCrucero i){
        inicio=i;
    }
    public NodoCrucero getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoCrucero f){
        fin=f;
    }
    public NodoCrucero getFin(){
        return fin;
    }
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
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
    public void agregarInicio(NodoCrucero unCrucero){
        unCrucero.setSig(inicio);
        this.inicio=unCrucero;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=unCrucero;
        }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(NodoCrucero unCrucero){
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
                NodoCrucero aux = this.inicio;
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

    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrarCrucerosDeCiudad(){
        NodoCrucero aux = this.inicio;
        while (aux != null){
            System.out.println(aux.getNombre() +" "+aux.getEstrellas()+" "+aux.getRanking());
            aux=aux.getSig();
        }   
    } //1.11
    
    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrarCrucerosDeCiudadRanking(){
        NodoCrucero aux = this.inicio;
        while (aux != null){
            System.out.println(aux.getNombre() +" - "+aux.getRanking());
            aux=aux.getSig();
        }   
    } //1.11
    
    @Override
    public void mostrarListaGeneral(){
        NodoCrucero aux = this.inicio;
        while (aux != null){
            System.out.println(aux.getCiudad()+" - "+aux.getNombre() +" - "+aux.getRanking());
            aux=aux.getSig();
        }   
    } //1.13
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Otros Métodos (iterativos)">

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(NodoCrucero c){
        if (this.esVacia() || this.inicio.getRanking() <= c.getRanking()){//Agrego el nuevo crucero al inicio si el ranking del mismo es menor a la del primer nodo de la lista
            this.agregarInicio(c);
            return;
        }
        if (this.fin.getRanking() >= c.getRanking()){ //Agrego el nuevo crucero al final si el ranking del mismo es mayor a la del ultimo nodo de la lista
            this.agregarFinal(c);
            return;
        }
        NodoCrucero aux=this.inicio;
        while (aux.getSig() != null && aux.getSig().getRanking() > c.getRanking()) //Si no lo agregue ni en la primer ni la ultima posicion, lo agrego en el lugar correcto
           aux=aux.getSig();
        c.setSig(aux.getSig());
        aux.setSig(c);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(String nombreCrucero, String nombreCiudad){
        boolean borrado = false;
        NodoCrucero aux= this.inicio;
        NodoCrucero auxFin= this.fin;
        if(!esVacia()){
            
            if(auxFin.getNombre() == nombreCrucero && auxFin.getCiudad() == nombreCiudad)
            {
                borrarFin();
                borrado=true;
            }
            
            if(aux.getNombre() == nombreCrucero && aux.getCiudad() == nombreCiudad)
            {
                borrarInicio();
                borrado=true;
            }
            
            if(aux.getSig() != null){
                while(aux.getSig().getSig() != null && borrado == false){
                    if(aux.getSig().getNombre() == nombreCrucero && aux.getSig().getCiudad() == nombreCiudad){
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
    public NodoCrucero obtenerElemento(String nombreCrucero, String nombreCiudad){
        NodoCrucero aux=this.inicio;
        boolean encontre=false;
        while (aux != null && !encontre){            
            if((aux.getNombre() == nombreCrucero && aux.getCiudad() == nombreCiudad))
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
    
    //<editor-fold defaultstate="collapsed" desc="Métodos RECURSIVOS">
    
    /*****  para resolver en forma recursiva Métodos RECURSIVOS  *****/

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    @Override
    public String mostrarRecursivoDesc(NodoCrucero aux){
        if(aux!=null){
            System.out.println(aux.getNombre() +" - "+aux.getRanking());
            cadena += aux.getNombre() +" - "+aux.getRanking();
            mostrarRecursivoDesc(aux.getSig());
        } 
        return cadena;
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    @Override
    public String mostrarRecursivoAsc(NodoCrucero aux){
         if(aux!=null){
            mostrarRecursivoAsc(aux.getSig());
            System.out.println(aux.getNombre() +" - "+aux.getRanking());
            cadena += aux.getNombre() +" - "+aux.getRanking();
        }
        return cadena;
        
    }
    //</editor-fold>
}