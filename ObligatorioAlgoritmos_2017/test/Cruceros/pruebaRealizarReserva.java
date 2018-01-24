package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaRealizarReserva {
    @Test
    public void testRealizarReservaEnCruceroSuperandoCapacidad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(2, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(3, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(1, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(10, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(10, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.realizarReserva(15, "Paysandu", "Titanic").resultado);
    }
    
    @Test
    public void testRealizarReservaEnCruceroNoRegistradoEnCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        assertEquals(Retorno.Resultado.ERROR_1, S.realizarReserva(1, "Salto", "Pinta").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.realizarReserva(1, "Paysandu", "Niña").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.realizarReserva(2, "Rio Negro", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.realizarReserva(3, "Montevideo", "Ocenao Profundo").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.realizarReserva(1, "Paysandu", "Vacaciones del Mar").resultado);
    }
    
    @Test
    public void testRealizarReservaEnCruceroConCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        assertEquals(Retorno.Resultado.ERROR_2, S.realizarReserva(1, "Marruecos", "Pinta").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.realizarReserva(1, "Roma", "Niña").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.realizarReserva(2, "Inglaterra", "Elisa").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.realizarReserva(3, "Boston", "Ocenao Profundo").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.realizarReserva(1, "New York", "Vacaciones del Mar").resultado);
    }
}
