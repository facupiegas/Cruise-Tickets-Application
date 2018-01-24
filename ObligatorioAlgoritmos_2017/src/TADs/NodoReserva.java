
package TADs;

public class NodoReserva {
    private int cliente;
    private String ciudad;
    private String crucero;
    private NodoReserva sig;
    
    public NodoReserva(){
        this.sig=null;
    }
    
    public NodoReserva(int cliente, String ciudad, String crucero) {
        this.cliente = cliente;
        this.ciudad = ciudad;
        this.crucero = crucero;
        this.sig = null;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCrucero() {
        return crucero;
    }

    public void setCrucero(String crucero) {
        this.crucero = crucero;
    }

    public NodoReserva getSig() {
        return sig;
    }

    public void setSig(NodoReserva sig) {
        this.sig = sig;
    }
    
    
    
    
    
}
