
package TADs;


public class NodoCruceroRanking {
    
    private NodoCruceroRanking sig;
    private NodoCrucero crucero;

    public NodoCruceroRanking(NodoCrucero crucero){
        this.crucero = crucero;
        this.sig=null;
    }
    
    public NodoCruceroRanking getSig() {
        return sig;
    }

    public void setSig(NodoCruceroRanking sig) {
        this.sig = sig;
    }

    public NodoCrucero getCrucero() {
        return crucero;
    }

    public void setCrucero(NodoCrucero crucero) {
        this.crucero = crucero;
    }
}
