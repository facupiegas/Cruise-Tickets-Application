package Sistema;


import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaDestruirSistemaReservas {
    
    @Test
    public void testDestruirSistemaDeReservasSinLimiteCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        assertEquals(Retorno.Resultado.OK, S.destruirSistemaReservas().resultado);
    }    
    
    @Test
    public void testDestruirSistemaDeReservasConLimiteCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(20);
        assertEquals(Retorno.Resultado.OK, S.destruirSistemaReservas().resultado);
    } 
    
    @Test
    public void testDestruirSistemaDeReservasConCiudades(){
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, S.destruirSistemaReservas().resultado);
    } 
    
    @Test
    public void testDestruirSistemaDeReservasConCiudadesYCruceros() {
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
        assertEquals(Retorno.Resultado.OK, S.destruirSistemaReservas().resultado);
    }
}
