package TADs;

public class NodoCruceroNombre {
    
    private NodoCruceroNombre sig;
    private NodoCrucero crucero;

    public NodoCruceroNombre(NodoCrucero crucero){
        
        this.crucero = crucero;
        this.sig=null;
    }
    
    public NodoCruceroNombre getSig() {
        return sig;
    }

    public void setSig(NodoCruceroNombre sig) {
        this.sig = sig;
    }

    public NodoCrucero getCrucero() {
        return crucero;
    }

    public void setCrucero(NodoCrucero crucero) {
        this.crucero = crucero;
    }
}
