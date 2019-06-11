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
public class NombreTest {
    String s1= " \"manoel";
    String s2= "cri1sto";
    Nombre n = new Nombre();
    public NombreTest() {
    }

    @Test
    public void testGetNombre() {
    }

    @Test
    public void testSetNombre() {
    }

    @Test
    public void testFormatea() {
        n.setNombre(s1);
        System.out.println(n.getNombre());
        n.formatea();
        System.out.println(n.getNombre());
        assertTrue("Manoel".equals(n.getNombre()));
    }
    @Test
    public void testFormoTrue(){
        n.setNombre(s1);
        n.formatea();
        assertTrue(n.valida(n.getNombre()));
    }
    @Test
    public void testFormoFalse(){
        n.setNombre(s2);
        assertFalse(n.valida(n.getNombre()));
    }
    
}
