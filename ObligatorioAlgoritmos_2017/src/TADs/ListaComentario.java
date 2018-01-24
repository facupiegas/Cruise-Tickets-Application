
package TADs;

import Interfaces.IListaComentario;

public class ListaComentario implements IListaComentario {

    private NodoComentario inicio;
    private NodoComentario fin;
    private int cantidadComentarios;
    private int totalPuntuacion;

     public ListaComentario() 
    {
        this.inicio = null;
        this.cantidadComentarios=0;
        this.totalPuntuacion=0;
    }
    
    public NodoComentario getInicio() {
        return inicio;
    }

    public void setInicio(NodoComentario inicio) {
        this.inicio = inicio;
    }

    public int getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(int cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }

    public int getTotalPuntuacion() {
        return totalPuntuacion;
    }
    
    public NodoComentario getFin() {
        return fin;
    }

    public void setFin(NodoComentario fin) {
        this.fin = fin;
    }
    
    @Override
    public boolean esVacia() {
        if (this.inicio==null)
            return true;
        else
            return false;
    }

    @Override
    public void agregarInicio(String comentario, int ranking) {
        NodoComentario tmp = new NodoComentario(comentario, ranking);
        tmp.setSiguiente(this.inicio);
        this.inicio=tmp;
        if(this.fin==null){//estoy insertando el primer nodo
            this.fin=tmp;
        }
        this.cantidadComentarios++;
        this.totalPuntuacion += ranking;
    }

    @Override
    public String mostrar() {
        NodoComentario aux = this.inicio;
        int contador = 0;
        String valorString="";
        String aMostrar="";
        while (aux!=null){
            contador++;
            aMostrar=contador +" - "+aux.getComentario()+" - "+aux.getPuntaje();
            System.out.println(aMostrar);
            valorString+=aMostrar;
            aux=aux.getSiguiente();
        } 
        return valorString;
    }

    public int indexOf(NodoComentario nodo) {
        int index = 0;
        NodoComentario current = this.inicio;

        while (current != null) {
            if (current.equals(nodo)) {
                return index;
            }
            index++;
            current = current.getSiguiente();
        }
        return -1;
    }
}
