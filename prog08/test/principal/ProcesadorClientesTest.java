
package principal;

import org.junit.Test;
import static org.junit.Assert.*;


public class ProcesadorClientesTest {
    String cadea1= "X123A5678F,\"nombre\",\"apellidos\",+(82)12345678, 612345678,test@TEST.com,(91)23456789 ,prueba@prueba.com";
    ProcesadorClientes pr= new ProcesadorClientes();
    public ProcesadorClientesTest() {
    }

    @Test
    public void testSeparaCadea() {
    }

    @Test
    public void testProcesaEntrada() {
        pr.procesaEntrada(cadea1);
        assertEquals("apellidos",pr.getApel().getNombreCampo() );
    }
}
