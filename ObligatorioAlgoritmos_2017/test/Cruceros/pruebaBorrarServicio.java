package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaBorrarServicio {
    @Test
    public void testBorrarServiciosDeCrucero() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 0);     
        
        S.ingresarServicio("Salto", "Santa Maria", "Limpieza");
        S.ingresarServicio("Salto", "Santa Maria", "Cena Show");
        S.ingresarServicio("Salto", "Santa Maria", "Wifi");
        S.ingresarServicio("Salto", "Santa Maria", "Piscina");
                
        assertEquals(Retorno.Resultado.OK, S.borrarServicio("Salto", "Santa Maria", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.OK, S.borrarServicio("Salto", "Santa Maria", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.OK, S.borrarServicio("Salto", "Santa Maria", "Wifi").resultado);
        assertEquals(Retorno.Resultado.OK, S.borrarServicio("Salto", "Santa Maria", "Piscina").resultado);
    }
    
    @Test
    public void testBorrarServiciosDeCruceroQueNoExisteEnCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 0);     
        
        S.ingresarServicio("Salto", "Santa Maria", "Limpieza");
        S.ingresarServicio("Salto", "Santa Maria", "Cena Show");
        S.ingresarServicio("Salto", "Santa Maria", "Wifi");
        S.ingresarServicio("Salto", "Santa Maria", "Piscina");
                
        assertEquals(Retorno.Resultado.ERROR_1, S.borrarServicio("Paysandu", "Santa Maria", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.borrarServicio("Rio Negro", "Santa Maria", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.borrarServicio("Montevideo", "Santa Maria", "Wifi").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.borrarServicio("Artigas", "Santa Maria", "Piscina").resultado);
    }
    
    @Test
    public void testBorrarServicioQueNoExisteEnCrucero() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Pinta", 1, 0);
        S.registrarCrucero("Paysandu", "Santa Maria", 1, 0);
        S.registrarCrucero("Rio Negro", "Santa Elena", 1, 0);
        S.registrarCrucero("Montevideo", "Titanic", 1, 0);
        
        S.ingresarServicio("Salto", "Pinta", "Limpieza");
        S.ingresarServicio("Paysandu", "Santa Maria", "Cena Show");
        S.ingresarServicio("Rio Negro", "Santa Elena", "Wifi");
        S.ingresarServicio("Montevideo", "Titanic", "Piscina");
                
        assertEquals(Retorno.Resultado.ERROR_2, S.borrarServicio("Salto", "Pinta", "Carreras de Autos").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.borrarServicio("Paysandu", "Santa Maria", "Liquidacion de Impuestos").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.borrarServicio("Rio Negro", "Santa Elena", "Tiro al blanco").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.borrarServicio("Montevideo", "Titanic", "Maraton").resultado);
    }
    
    @Test
    public void testBorrarServicioConCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 0);     
        
        S.ingresarServicio("Salto", "Santa Maria", "Limpieza");
        S.ingresarServicio("Salto", "Santa Maria", "Cena Show");
        S.ingresarServicio("Salto", "Santa Maria", "Wifi");
        S.ingresarServicio("Salto", "Santa Maria", "Piscina");
                
        assertEquals(Retorno.Resultado.ERROR_3, S.borrarServicio("Marruecos", "Santa Maria", "Limpieza").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.borrarServicio("Roma", "Santa Maria", "Cena Show").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.borrarServicio("Inglaterra", "Santa Maria", "Wifi").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.borrarServicio("Boston", "Santa Maria", "Piscina").resultado);
    }
    
}
