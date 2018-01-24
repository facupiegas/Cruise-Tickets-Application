package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaCancelarReserva {
    @Test
    public void testCancelarReservaEnCrucero() {
        Sistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 5);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(2, "Salto", "Santa Maria");
        S.realizarReserva(3, "Salto", "Santa Maria");
        S.realizarReserva(4, "Salto", "Santa Maria");
        S.realizarReserva(5, "Salto", "Santa Maria");
        
        S.realizarReserva(1, "Paysandu", "Titanic");
        S.realizarReserva(10, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");        
        S.realizarReserva(15, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");
                
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(2, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(3, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(10, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
        S.listarReservasYCola("Salto", "Santa Maria");
    
    }
    
    @Test
    public void testCancelarReservaEnCruceroNoResgistradoEnCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(2, "Salto", "Santa Maria");
        S.realizarReserva(3, "Salto", "Santa Maria");
        S.realizarReserva(1, "Paysandu", "Titanic");
        S.realizarReserva(10, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");        
        S.realizarReserva(15, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");
                
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(1, "Salto", "Brisas del Mar").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(1, "Salto", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(2, "Salto", "Oceano FM").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(3, "Salto", "Tsunami INC").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(1, "Paysandu", "Barquito Pequeño").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(10, "Paysandu", "Pinta").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(15, "Paysandu", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(15, "Paysandu", "Alta Mar SRL").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.cancelarReserva(15, "Paysandu", "Pinta").resultado);
    }
    
    @Test
    public void testCancelarReservaDeClienteSinReservas() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(2, "Salto", "Santa Maria");
        S.realizarReserva(3, "Salto", "Santa Maria");
        S.realizarReserva(1, "Paysandu", "Titanic");
        S.realizarReserva(10, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");        
        S.realizarReserva(15, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");
                
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(50, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(23, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(27, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(300, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(158, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(107, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(111, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(1555, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.cancelarReserva(1533, "Paysandu", "Titanic").resultado);
    }
    
    @Test
    public void testCancelarReservaEnCruceroDeCiudadNoCreada() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Salto", "Santa Maria", 1, 2);
        S.registrarCrucero("Paysandu", "Titanic", 1, 2);
        
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(1, "Salto", "Santa Maria");
        S.realizarReserva(2, "Salto", "Santa Maria");
        S.realizarReserva(3, "Salto", "Santa Maria");
        S.realizarReserva(1, "Paysandu", "Titanic");
        S.realizarReserva(10, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");        
        S.realizarReserva(15, "Paysandu", "Titanic");
        S.realizarReserva(15, "Paysandu", "Titanic");
                
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(1, "Marruecos", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(1, "Roma", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(2, "Inglaterra", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(3, "Boston", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(1, "New York", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(10, "Rocha", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(15, "Punta del Este", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(15, "Buenos Aires", "Titanic").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.cancelarReserva(15, "Ciudad que no existe", "Titanic").resultado);
    }
}
