package Interfaces;

public interface IListaServicio {
    public void agregarInicio(String Servicio);
    public void agregarFinal(String Servicio);
    public boolean borrarServicio(String servicio);
    public boolean esVacia();
    public String mostrar();
}
