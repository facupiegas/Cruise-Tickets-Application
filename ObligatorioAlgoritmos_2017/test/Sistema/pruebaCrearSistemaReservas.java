package Sistema;

import Interfaces.ISistema;
import Obligatorio.Sistema;
import Obligatorio.Retorno;
import org.junit.Test;
import static org.junit.Assert.*;


public class pruebaCrearSistemaReservas {
    
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
}
