package TADs;

import Interfaces.IListaServicio;

public class ListaServicio implements IListaServicio {
    private NodoServicio inicio;
    private NodoServicio fin;
    private int cantServicios;
    

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    public NodoServicio getInicio() {
        return inicio;
    }

    public void setInicio(NodoServicio inicio) {
        this.inicio = inicio;
    }
    public int getCantServicios() {
        return cantServicios;
    }

    public void setCantServicios(int cantServicios) {
        this.cantServicios = cantServicios;
    }
     public NodoServicio getFin() {
        return fin;
    }

    public void setFin(NodoServicio fin) {
        this.fin = fin;
    }

    //</editor-fold>
    
    //Constructor
    public ListaServicio() {
        this.inicio = null;
        this.fin = null;
        this.cantServicios = 0;
    }
    
    @Override
    public void agregarInicio(String servicio) {
        NodoServicio nuevo = new NodoServicio(servicio);
        nuevo.setSig(this.inicio);
        this.inicio=nuevo;
        if(this.fin==null){
            this.fin=nuevo;
        }
        this.cantServicios++;
    }
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(String Servicio){
        if (this.esVacia())
            this.agregarInicio(Servicio);
        else
        {
            NodoServicio unServicio = new NodoServicio(Servicio);
            fin.setSig(unServicio);
            this.fin=unServicio;
        }       
    }

    @Override
    public boolean borrarServicio(String servicio){
        boolean borrado = false;
        NodoServicio aux= this.inicio;
        if(!esVacia()){
            if(aux.getServicio()==servicio)
            {
                inicio = inicio.getSig();
                borrado=true;
                this.cantServicios--;
            }
            while (aux.getSig()!=null && !borrado){
                if (aux.getSig().getServicio() == servicio){
                    aux.setSig(aux.getSig().getSig());
                    borrado=true;
                    this.cantServicios--;
                }
                else{
                    aux = aux.getSig();
                }
            }
        }
        return borrado;
    }

    @Override
    public boolean esVacia() {
        if (this.inicio==null)
            return true;
        else
            return false;
    }

    @Override
    public String mostrar() {
        NodoServicio aux = this.inicio;
        int contador = 0;
        String valorString = "";
        while (aux!=null){
            contador++;
            String aMostrar = contador +" - "+aux.getServicio();
            System.out.println(aMostrar);
            valorString += aMostrar;
            aux=aux.getSig();
        }
        return valorString;
    }
    
}
