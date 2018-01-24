package TADs;

public class NodoCrucero{
        private String nombre;
        private String ciudad;
        private int capacidad;
        private int estrellas;
        private int ranking;
        private NodoCrucero sig;
        private ListaComentario listaComentarios;
        private ListaServicio listaServicios;
        private ListaReserva listaReservas;
        private ColaReserva colaReservas;

    //Constructores
    public NodoCrucero(){
        this.sig=null;
    }
    
    public NodoCrucero(String nombre, String ciudad, int estrellas,int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        this.ranking = 0;
        this.listaComentarios = new ListaComentario();
        this.listaServicios = new ListaServicio();
        this.sig = null;
        this.listaReservas = new ListaReserva();
        this.colaReservas = new ColaReserva();
    }

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    
    //Siguiente
    public void setSig(NodoCrucero s){
        this.sig=s;
    }
    
    public NodoCrucero getSig(){
        return this.sig;
    }
     public int getRanking() {
        return ranking;
    }

    public void ActualizarRaking() {
        this.ranking = listaComentarios.getTotalPuntuacion()/listaComentarios.getCantidadComentarios();
    }
    
    public ListaComentario getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ListaComentario listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ListaServicio getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ListaServicio listaServicios) {
        this.listaServicios = listaServicios;
    }
    
    public ListaReserva getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ListaReserva listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    public ColaReserva getColaReservas() {
        return colaReservas;
    }

    public void setColaReservas(ColaReserva colaReservas) {
        this.colaReservas = colaReservas;
    }
    //</editor-fold>   
}
