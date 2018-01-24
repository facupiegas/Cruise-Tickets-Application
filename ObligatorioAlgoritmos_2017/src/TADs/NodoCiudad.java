package TADs;

public class NodoCiudad{
        private String nombre;
	private NodoCiudad sig;
        private ListaCrucero LC;
        private ListaCruceroNombre LCNombre;

        
    //Constructor
    public NodoCiudad(){
        this.sig=null;
        this.LC = new ListaCrucero();
    }
    
    public NodoCiudad(String nombre) {
        this.nombre = nombre;
        this.LC = new ListaCrucero();
        this.LCNombre = new ListaCruceroNombre();
        this.sig = null;
    }
    
    public ListaCruceroNombre getLCNombre() {
        return LCNombre;
    }

    public void setLCNombre(ListaCruceroNombre LCNombre) {
        this.LCNombre = LCNombre;
    }

    public ListaCrucero getLC() {
        return LC;
    }

    public void setLC(ListaCrucero LC) {
        this.LC = LC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Siguiente
    public void setSig(NodoCiudad s){
        this.sig=s;
    }
    
    public NodoCiudad getSig(){
        return this.sig;
    }
}
