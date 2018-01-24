package Listados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import TADs.ListaComentario;
import TADs.NodoComentario;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaListadoComentarios {
    
    @Test
    public void testListadoDeComentarios() {
        Sistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Artigas", "Ana Maria II", 1, 0);
        S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0);
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);
        S.registrarCrucero("Paysandu", "Long Beach", 1, 0);
        
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Ana Maria II", 1, 0);
        S.registrarCrucero("Montevideo", "Capitan Morgan", 1, 0);
                
        S.ingresarComentario("Artigas", "Elisa", "Excelente Crucero", 5);
        S.ingresarComentario("Artigas", "Elisa", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Artigas", "Elisa", "Muy instatifecho", 1);  
        S.ingresarComentario("Artigas", "Elisa", "Volveria a viajar en el", 5);
        
        S.ingresarComentario("Artigas", "Ana Maria II", "Volveria a viajar en el", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Fantastico", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "La mejor experiencia vivida", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Inolvidable", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Bueno", 3);        
                   
        assertEquals(Retorno.Resultado.OK, S.listarComentarios("Artigas", "Elisa").resultado);
        assertEquals(Retorno.Resultado.OK, S.listarComentarios("Artigas", "Ana Maria II").resultado);
        assertEquals(Retorno.Resultado.OK, S.listarComentarios("Paysandu", "Long Beach").resultado);
    }
    
    @Test
    public void testListadoDeComentariosDeCruceroNoRegistrado() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");      
                   
        assertEquals(Retorno.Resultado.ERROR_1, S.listarComentarios("Artigas", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarComentarios("Artigas", "Ana Maria II").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarComentarios("Paysandu", "Long Beach").resultado);
    }
    
    @Test
    public void testListadoDeComentariosDeCruceroEnCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);     
                   
        assertEquals(Retorno.Resultado.ERROR_2, S.listarComentarios("Artigas", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarComentarios("Artigas", "Ana Maria II").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarComentarios("Paysandu", "Long Beach").resultado);
    }
    
}
