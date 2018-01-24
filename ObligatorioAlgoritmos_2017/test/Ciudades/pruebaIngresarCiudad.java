package Ciudades;

import Interfaces.ISistema;
import Obligatorio.Sistema;
import Obligatorio.Retorno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Facundo
 */
public class pruebaIngresarCiudad {
    
    @Test
    public void pruebaAgregarUnicaCiudadSinLimiteDeCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
    }
    
    @Test
    public void pruebaAgregarUnicaCiudadConLimiteDeCiudades() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
    }
    
    @Test
    public void pruebaAgregarVariasCiudadesSinLimite() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Paysandu").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Rio Negro").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Colonia").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Rocha").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("San Jose").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Canelones").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Minas").resultado);
    }
    
    @Test
    public void pruebaAgregarMismoNumeroDeCiudadesQueLimite() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Paysandu").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Rio Negro").resultado);
    }
    
    @Test
    public void pruebaAgregarUnaCiudadMasQueLimite() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Paysandu").resultado);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Rio Negro").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCiudad("San Jose").resultado);
    }
    
    @Test
    public void pruebaAgregarUnaCiudadQueYaExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        assertEquals(Retorno.Resultado.OK, S.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCiudad("Montevideo").resultado);
    }
}

