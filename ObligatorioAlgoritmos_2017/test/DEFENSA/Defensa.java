package DEFENSA;


import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class Defensa {
    @Test
    public void testCrearSistemaDeCrucerosConValorCero() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.OK, S.crearSistemaReservas(0).resultado);
    }
    @Test
    public void testCrearSistemaDeCrucerosConValorNegativo() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, S.crearSistemaReservas(-50).resultado);
    }
    @Test
    public void testCrearSistemaDeCrucerosConValorMayorACero() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.OK, S.crearSistemaReservas(5).resultado);
    }

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

    @Test
    public void testCancelarReservaEnCrucero() {
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
                
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(2, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(3, "Salto", "Santa Maria").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(1, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(10, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
        assertEquals(Retorno.Resultado.OK, S.cancelarReserva(15, "Paysandu", "Titanic").resultado);
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

    @Test
    public void testIngresarComentariosEnCruceros() {
        ISistema S = new Sistema();
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
        
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Ana Maria II", 1, 0);
        S.registrarCrucero("Montevideo", "Capitan Morgan", 1, 0);
                
        S.ingresarComentario("Artigas", "Elisa", "Excelente Crucero", 5);
        S.ingresarComentario("Artigas", "Capitan Morgan", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Artigas", "Elisa", "Muy instatifecho", 1);  
        S.ingresarComentario("Artigas", "Ana Maria II", "No volveria a viajar en el", 1);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Volveria a viajar en el", 5);        
        S.ingresarComentario("Artigas", "Elisa", "Puede mejorar", 3);        
        S.ingresarComentario("Artigas", "Ana Maria II", "La mejor experiencia vivida", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Inolvidable", 5);        
        S.ingresarComentario("Artigas", "Ana Maria II", "Bueno", 3);
        
        
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Artigas").resultado);
    }
    
    @Test
    public void testIngresarComentariosConRankingInvalidoEnCruceros() {
        ISistema S = new Sistema();
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
        
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Ana Maria II", 1, 0);
        S.registrarCrucero("Montevideo", "Capitan Morgan", 1, 0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Elisa", "Excelente Crucero", 10).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Elisa", "Deben mejorar el servicio de WIFI", 6).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Elisa", "Muy instatifecho", -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Elisa", "Volveria a viajar en el", 58).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Ana Maria II", "Volveria a viajar en el", 200).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Ana Maria II", "Fantastico", 58).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Ana Maria II", "La mejor experiencia vivida", 30).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Ana Maria II", "Inolvidable", -50).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.ingresarComentario("Artigas", "Ana Maria II", "Bueno", 34).resultado);
    }
    
    @Test
    public void testIngresarComentariosEnCrucerosQNoRegistradosEnCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Rio Negro");
        S.registrarCiudad("Montevideo");
        S.registrarCiudad("Rocha");
        
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Artigas", "Ana Maria II", 1, 0);
        S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0);
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);
        
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Ana Maria II", 1, 0);
        S.registrarCrucero("Montevideo", "Capitan Morgan", 1, 0);
                
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Paysandu", "Elisa", "Excelente Crucero", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Salto", "Elisa", "Deben mejorar el servicio de WIFI", 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Rio Negro", "Elisa", "Muy instatifecho", 1).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Rocha", "Elisa", "Volveria a viajar en el", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Paysandu", "Ana Maria II", "Volveria a viajar en el", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Salto", "Ana Maria II", "Fantastico", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Rio Negro", "Ana Maria II", "La mejor experiencia vivida", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, S.ingresarComentario("Rocha", "Ana Maria II", "Inolvidable", 5).resultado);
    }
    
    @Test
    public void testIngresarComentariosEnCrucerosConCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Artigas", "Ana Maria II", 1, 0);
        S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0);
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);
        
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Ana Maria II", 1, 0);
        S.registrarCrucero("Montevideo", "Capitan Morgan", 1, 0);
                
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Paysandu", "Elisa", "Excelente Crucero", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Salto", "Elisa", "Deben mejorar el servicio de WIFI", 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Rio Negro", "Elisa", "Muy instatifecho", 1).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Rocha", "Elisa", "Volveria a viajar en el", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Paysandu", "Ana Maria II", "Volveria a viajar en el", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Salto", "Ana Maria II", "Fantastico", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Rio Negro", "Ana Maria II", "La mejor experiencia vivida", 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, S.ingresarComentario("Rocha", "Ana Maria II", "Inolvidable", 5).resultado);
    }
    
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
    
    @Test
    public void pruebaListadoDeCrucerosDeCiudad() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Montevideo");

        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Artigas", "Ana Maria II", 1, 0);
        S.registrarCrucero("Artigas", "Capitan Morgan", 1, 0);        
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);        
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        
        S.registrarCrucero("Salto", "Elisa", 1, 0);
        S.registrarCrucero("Salto", "Ana Maria II", 1, 0);
        S.registrarCrucero("Salto", "Capitan Morgan", 1, 0);        
        S.registrarCrucero("Salto", "Long Beach", 1, 0);        
        S.registrarCrucero("Salto", "Summer Season III", 1, 0);
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.OK,  
        S.listarCrucerosCiudad("Montevideo").resultado);

    }
    
    @Test
    public void pruebaListadoDeCrucerosDeCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Artigas").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Salto").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosCiudad("Montevideo").resultado);

    }
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudad() {
        ISistema S = new Sistema();
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
        S.ingresarComentario("Artigas", "Long Beach", "Bueno", 2);   
        S.ingresarComentario("Artigas", "Capitan Morgan", "Bueno", 1);   
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRanking("Artigas").resultado); 
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRanking("Salto").resultado); 
    }
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudadQueNoExiste() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRanking("Artigas").resultado); 
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRanking("Salto").resultado); 
    }
    
    @Test
    public void testListadoDeCrucerosPorRankingSinCrucerosRegistrados() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Montevideo");
       
        
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRanking().resultado);
    }
    
    @Test
    public void testListadoDeCrucerosPorRanking() {
        Sistema S = new Sistema();
        S.crearSistemaReservas(0);
        
        S.registrarCiudad("Artigas");
        S.registrarCiudad("Salto");
        S.registrarCiudad("Paysandu");
        S.registrarCiudad("Montevideo");
        
        S.registrarCrucero("Artigas", "Long Beach", 1, 0);
        S.registrarCrucero("Artigas", "Summer Season III", 1, 0);
        S.registrarCrucero("Artigas", "Elisa", 1, 0);
        S.registrarCrucero("Montevideo", "Long Beach", 1, 0);
        S.registrarCrucero("Montevideo", "Summer Season III", 1, 0);
        S.registrarCrucero("Montevideo", "Elisa", 1, 0);
        S.registrarCrucero("Paysandu", "Long Beach", 1, 0);
        S.registrarCrucero("Paysandu", "Summer Season III", 1, 0);
        S.registrarCrucero("Paysandu", "Elisa", 1, 0);
        S.registrarCrucero("Salto", "Long Beach", 1, 0);
        S.registrarCrucero("Salto", "Summer Season III", 1, 0);
        S.registrarCrucero("Salto", "Elisa", 1, 0);
                
        S.ingresarComentario("Artigas", "Long Beach", "Excelente Crucero", 5);
        S.ingresarComentario("Artigas", "Summer Season III", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Artigas", "Elisa", "Muy instatifecho", 1);
        S.ingresarComentario("Montevideo", "Long Beach", "Excelente Crucero", 5);
        S.ingresarComentario("Montevideo", "Summer Season III", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Montevideo", "Elisa", "Muy instatifecho", 1);
        S.ingresarComentario("Paysandu", "Long Beach", "Excelente Crucero", 5);
        S.ingresarComentario("Paysandu", "Summer Season III", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Paysandu", "Elisa", "Muy instatifecho", 1); 
        S.ingresarComentario("Salto", "Long Beach", "Excelente Crucero", 5);
        S.ingresarComentario("Salto", "Summer Season III", "Deben mejorar el servicio de WIFI", 3);
        S.ingresarComentario("Salto", "Elisa", "Muy instatifecho", 1);
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRanking().resultado);
    }		
    
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
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudadRecursivoAsc() {
        ISistema S = new Sistema();
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
        S.ingresarComentario("Artigas", "Long Beach", "Bueno", 2);   
        S.ingresarComentario("Artigas", "Capitan Morgan", "Bueno", 1);   
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRankingAsc("Artigas").resultado); 
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRankingAsc("Salto").resultado); 
    }
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudadRecursivoDsc() {
        ISistema S = new Sistema();
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
        S.ingresarComentario("Artigas", "Long Beach", "Bueno", 2);   
        S.ingresarComentario("Artigas", "Capitan Morgan", "Bueno", 1);   
                
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRankingDesc("Artigas").resultado); 
        assertEquals(Retorno.Resultado.OK, S.listarCrucerosRankingDesc("Salto").resultado); 
    }
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudadQueNoExisteRecursivoAsc() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRankingAsc("Artigas").resultado); 
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRankingAsc("Salto").resultado); 
    }
    
    @Test
    public void testListadoDeCrucerosPorRankingParaUnaCiudadQueNoExisteRecursivoDsc() {
        ISistema S = new Sistema();
        S.crearSistemaReservas(0);
                
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRankingDesc("Artigas").resultado); 
        assertEquals(Retorno.Resultado.ERROR_1, S.listarCrucerosRankingDesc("Salto").resultado); 
    }
    
    @Test
    public void pruebaBuscarCaminoMasCortoOk() {
        Sistema sis = new Sistema();
        
        sis.crearSistemaReservas(6);
        
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        int[][] mat = new int[][] {};
    
        Retorno ret2 =  sis.cargarDistancias(new int[][] {
                        {0,10,25,15,30,0},
                        {10,0,20,0,0,0},
                        {25,20,0,0,0,40},
                        {15,0,0,0,0,45},
                        {30,0,0,0,0,25},
                        {0,0,40,45,25,0}
                        });
        
        Retorno r = sis.buscarCamino(mat,"Montevideo","New York");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        String strR = r.valorString;
        System.out.println(strR);
        assertTrue(strR.indexOf("Montevideo") < strR.indexOf("New York"));
        assertTrue(strR.indexOf("Panamá") < strR.indexOf("New York")); 
    }
    
    @Test
    public void pruebaBuscarCaminoMasCortoCiudadNoCreada() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(6);
        
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        int[][] mat = new int[][] {};
    
        Retorno ret2 =  sis.cargarDistancias(new int[][] {
                        {0,10,25,15,30,0},
                        {10,0,20,0,0,0},
                        {25,20,0,0,0,40},
                        {15,0,0,0,0,45},
                        {30,0,0,0,0,25},
                        {0,0,40,45,25,0}
                        });
        
        Retorno r = sis.buscarCamino(mat,"Salto","New York");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        
        String strR = r.valorString;
        System.out.println(strR);
    }
    
    @Test
    public void pruebaCargarDistanciasOk() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        Retorno ret =  sis.cargarDistancias(new int[][] {
                        {0,10,25,15,30,0},
                        {10,0,20,0,0,0},
                        {25,20,0,0,0,40},
                        {15,0,0,0,0,45},
                        {30,0,0,0,0,25},
                        {0,0,40,45,25,0}
                        });
        
        assertEquals(Retorno.Resultado.OK,ret.resultado);
    }
    
        @Test
    public void pruebaCargarDistanciasConMatrizQueNoEsCuadrada() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        assertEquals(Retorno.Resultado.ERROR_1,sis.cargarDistancias(new int[][] {
                {0,10,25,15,30,0},
                {10,0,20,0,0},
                {25,20,0,0,0,40},
                {15,0,0,0,0,45},
                {30,0,0,0,0,25},
                {0,0,40,45,25,0}
        }).resultado);
    }
    
    @Test
    public void pruebaCargarDistanciasConValorDistintoDeCeroEnDiagonalPrincipal() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        Retorno ret =  sis.cargarDistancias(new int[][] {
                        {0,10,25,15,30,0},
                        {10,0,20,0,0,0},
                        {25,20,0,0,0,40},
                        {15,0,0,0,0,45},
                        {30,0,0,0,3,25},
                        {0,0,40,45,25,0}
                        });
        
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    @Test
    public void pruebaCargarDistanciasConUnValorNegativo() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        Retorno ret =  sis.cargarDistancias(new int[][] {
                        {0,10,25,15,30,0},
                        {10,0,20,0,0,0},
                        {25,20,0,0,0,40},
                        {-15,0,0,0,0,45},
                        {30,0,0,0,0,25},
                        {0,0,40,45,25,0}
                        });
        
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }
    
        @Test
    public void pruebaCargarDistanciasConDistintoNumeroDeCiudades() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(5);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        assertEquals(Retorno.Resultado.ERROR_4,sis.cargarDistancias(new int[][] {
                {0,10,25,15,30,0},
                {10,0,20,0,0,0},
                {25,20,0,0,0,40},
                {15,0,0,0,0,45},
                {30,0,0,0,0,25},
                {0,0,40,45,25,0}
        }).resultado);
    }
}