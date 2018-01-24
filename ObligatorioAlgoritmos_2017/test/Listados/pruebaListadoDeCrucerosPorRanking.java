package Listados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaListadoDeCrucerosPorRanking {
    
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
}
