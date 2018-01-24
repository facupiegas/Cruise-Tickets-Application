package Listados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;;


public class pruebaListadoDeCrucerosPorCiudad {
    
    @Test
    public void pruebaListadoDeCrucerosDeCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Montevideo");

        
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0);        
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);        
        S.registrarCrucero("Artigas", "Ana Maria II", 1, 0);
        
        S.registrarCrucero("Salto", "Elisa", 1, 0);
        S.registrarCrucero("Salto", "Ana Maria II", 1, 0);
        S.registrarCrucero("Salto", "Capitan Morgan", 1, 0);        
        S.registrarCrucero("Salto", "Long Beach", 1, 0);        
        S.registrarCrucero("Salto", "Summer Season III", 1, 0);
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Montevideo").resultado);

    }
    
    @Test
    public void pruebaListadoDeCrucerosDeCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Montevideo").resultado);

    }
}
