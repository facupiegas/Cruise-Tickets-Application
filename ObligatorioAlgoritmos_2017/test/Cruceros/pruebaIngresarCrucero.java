package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Sistema;
import Obligatorio.Retorno;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaIngresarCrucero {
    
    @Test
    public void pruebaAgregarVariosCrucerosAMismaCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Elisa", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Ana Maria II", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Long Beach", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Summer Season III", 1, 0).resultado);
    }
    
    @Test
    public void pruebaAgregarVariosCrucerosADistintasCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Elisa", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Salto", "Ana Maria II", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Paysandu", "Capitan Morgan", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Rio Negro", "Long Beach", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Montevideo", "Summer Season III", 1, 0).resultado);
    }
    
    @Test
    public void pruebaAgregarCruceroConMismoNombreADistintasCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Artigas", "Elisa", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Salto", "Elisa", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Paysandu", "Elisa1", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Rio Negro", "Elisa", 1, 0).resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Montevideo", "Elisa", 1, 0).resultado);
    }
    
    @Test
    public void pruebaAgregarCruceroConEstrellasMenorAUnoYMayorACinco() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCrucero("Artigas", "Elisa", 0, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCrucero("Salto", "Ana Maria II", 6, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCrucero("Paysandu", "Capitan Morgan", -20, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCrucero("Montevideo", "Long Beach", 60, 0).resultado);
    }
    
    @Test
    public void pruebaAgregarCruceroConCapacidadMenorACero() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCrucero("Artigas", "Elisa", 3, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCrucero("Salto", "Ana Maria II", 3, -10).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCrucero("Paysandu", "Capitan Morgan", 3, -100).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCrucero("Rio Negro", "Long Beach", 3, -87).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCrucero("Montevideo", "Summer Season III", 3, -55).resultado);
    }
    
    @Test
    public void pruebaAgregarCruceroRepetidoAMismaCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, S.registrarCrucero("Montevideo", "Elisa", 3, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.registrarCrucero("Montevideo", "Elisa", 3, 0).resultado);
    }    
}
