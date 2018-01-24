package Cruceros;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaIngresarComentario { 
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
    
}
