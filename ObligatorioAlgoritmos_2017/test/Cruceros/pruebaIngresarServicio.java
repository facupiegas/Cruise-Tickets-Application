package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Sistema;
import Obligatorio.Retorno;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaIngresarServicio {
    
   @Test
    public void testIngresarServiciosEnMismoCrucero() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);     
        
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Wifi").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Piscina").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Guarderia").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Buceo").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Cama Solar").resultado);
    }
    
    @Test
    public void testIngresarMismoServiciosEnDistintosCruceros() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Salto", "Santa Maria", 1, 0);
        S.registrarCrucero("Paysandu", "Santa Elena", 1, 0);
        S.registrarCrucero("Rio Negro", "Brisas del Mar", 1, 0);
        S.registrarCrucero("Montevideo", "Titanic", 1, 0);
        
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Artigas", "Elisa", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Salto", "Santa Maria", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Paysandu", "Santa Elena", "Wifi").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Rio Negro", "Brisas del Mar", "Piscina").resultado);
        assertEquals(Retorno.Resultado.OK, S.ingresarServicio("Montevideo", "Titanic", "Guarderia").resultado);
    }
    
    @Test
    public void testIngresarServiciosEnCruceroNoExistente() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);     
        
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarServicio("Artigas", "Santa Maria", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarServicio("Artigas", "Santa Elena", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarServicio("Artigas", "Brisas del Mar", "Wifi").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarServicio("Artigas", "Titanic", "Piscina").resultado);
    }
    
    @Test
    public void testIngresarServiciosEnCruceroDeCiudadQueNoExistente() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);     
        
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarServicio("Artigas", "Santa Maria", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarServicio("Artigas", "Santa Elena", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarServicio("Artigas", "Brisas del Mar", "Wifi").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarServicio("Artigas", "Titanic", "Piscina").resultado);
    }
}
