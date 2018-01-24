package TADs;

public class NodoServicio {
    private String servicio;
    private NodoServicio sig;

    public NodoServicio getSig() {
        return sig;
    }

    public void setSig(NodoServicio sig) {
        this.sig = sig;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
       public NodoServicio(String unServicio){
        this.servicio = unServicio;
    }
}
