/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sergio
 */
public class IdentificadorTest {
    String cadea1= "X12345678F,\"nombre\",\"apellidos\",+(82)12345678, 612345678,test@TEST.com,(91)23456789 ,prueba@prueba.com";
    String cadea2="12345678Z,\"nombre\",\"apellidos\", prueba@prueba.com,(952)333333,test@test.com ,952333333,test@TEST.com";
    Identificacion p = new Identificacion();
    String nif1="123X";
    String nif2="12345678x";
    String nif3="1234567xx";
    ProcesadorClientes pr= new ProcesadorClientes();
    
    public IdentificadorTest() {
    }
    @Before
    public void antesque(){
      
    }
    
    @Test
    public void testSeparaCadea() {
        
        
    }

    @Test
    public void testNif() {
        assertTrue(p.nif(pr.separaCadea(cadea2)[0])& p.nif(nif2));
    }
    @Test
    public void testNifMal(){
        assertFalse(p.nif(pr.separaCadea(cadea1)[0])|p.nif(nif1)| p.nif(nif3));
    }
    @Test
    public void testNieBen(){
            assertTrue(p.comproba(pr.separaCadea(cadea1)[0]));
    }
    @Test
    public void testNieMal(){
        assertFalse(p.comproba(pr.separaCadea(cadea2)[0]));
    }
}
