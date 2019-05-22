package prog05.aplicacion;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Sergio
 */
public class CuentaBancariaTest {
    public String nombreBo="Sergio Botana Pena";
    public String nombreMalo="asasasdadljahdkjhas dkjashd ahdk ajdh kashd kasjdh akjhd";
    
    @Rule 
    public ExpectedException thrown = ExpectedException.none();
    
    
    public CuentaBancariaTest() {
    }
    
    /**
     * Comproba que por defecto a lonxitude permitida de nome é 30
     */
    @Test
    public void testGetMaxLonxNome() {
        assertEquals(30, CuentaBancaria.getMaxLonxNome());
    }
    /**
     * Comproba o cambio de lonxitude maxima
     */
    @Test 
    public void testSetMaxLonxNome() {
        try{
            CuentaBancaria.setMaxLonxNome(50);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(50, CuentaBancaria.getMaxLonxNome());
    }
    
    
    /**
     * Comproba que non se poden ingresar negativos
     */

    @Test (expected = Exception.class)
//    @Test
    public void testSetMaxLonxNomeExcp() {

        
//        thrown.expectMessage("Introduciuse unha lonxitude de nome negativa");
//        thrown.expect(Exception.class);       
        CuentaBancaria.setMaxLonxNome(5);
    }



}
