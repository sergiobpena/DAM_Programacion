/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class CorreoTest {
    
    String correomal="Sergio.sergio.com";
    String correoben="Se@se.es";
    String correomal2="@es.es";
    String correomal3="es@.com";
    String correomal4="es@as.s";
    Correo c = new Correo();
    
    public CorreoTest() {
    }

    @Test
    public void testComproba() {
        assertFalse(c.comproba(correomal)|c.comproba(correomal2)|c.comproba(correomal3)|c.comproba(correomal4));
    }
    @Test
    public void testComprobaBen(){
        assertTrue(c.comproba(correoben));
    }
    @Test
    public void comprobaFormato(){
        assertEquals("se@se.es", c.formatea(correoben));
    }
}
