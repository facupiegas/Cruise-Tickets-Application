
package TADs;

public class NodoComentario {
    
    private NodoComentario siguiente;
    private String comentario;
    private int puntaje;

    public NodoComentario(String comentario,int puntaje)
    {
        this.siguiente=null;
        this.comentario = comentario;
        this.puntaje = puntaje;
    }
    
    public NodoComentario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoComentario siguiente) {
        this.siguiente = siguiente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
    
    
}
