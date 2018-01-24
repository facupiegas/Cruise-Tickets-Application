
package Listados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaListadoDeServicios {
    
    @Test
    public void testListadodeServiciosDeCrucero() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        
        S.ingresarServicio("Artigas", "Elisa", "Limpieza");
        S.ingresarServicio("Artigas", "Elisa", "Cena Show");
        S.ingresarServicio("Artigas", "Elisa", "Wifi");        
        S.ingresarServicio("Artigas", "Elisa", "Piscina");        
        S.ingresarServicio("Artigas", "Elisa", "Guarderia");        
        S.ingresarServicio("Artigas", "Elisa", "Buceo");        
        S.ingresarServicio("Artigas", "Elisa", "Cama Solar");        
                
        
        assertEquals(Retorno.Resultado.OK, S.listarServicios("Artigas", "Elisa").resultado); 
        assertEquals(Retorno.Resultado.OK, S.listarServicios("Montevideo", "Elisa").resultado);
    }
    
    @Test
    public void testListadodeServiciosDeCruceroNoRegistradoEnCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        assertEquals(Retorno.Resultado.ERROR_1, S.listarServicios("Artigas", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarServicios("Salto", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarServicios("Paysandu", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarServicios("Rio Negro", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarServicios("Montevideo", "Elisa").resultado);
    }
    
    @Test
    public void testListadodeServiciosDeCruceroConCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        assertEquals(Retorno.Resultado.ERROR_2, S.listarServicios("Artigas", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarServicios("Salto", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarServicios("Paysandu", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarServicios("Rio Negro", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.listarServicios("Montevideo", "Elisa").resultado);
    }   
}
