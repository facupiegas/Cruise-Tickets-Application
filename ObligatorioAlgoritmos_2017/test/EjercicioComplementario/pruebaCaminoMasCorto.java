package EjercicioComplementario;

import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaCaminoMasCorto {
    
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
}
