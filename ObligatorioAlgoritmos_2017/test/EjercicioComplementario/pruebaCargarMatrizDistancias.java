package EjercicioComplementario;

import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaCargarMatrizDistancias {
    
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
