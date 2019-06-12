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
public class TelefonoTest {
    String tel1="696041498";
    String tel2="(55)";
    String tel3="+";
    
    Telefono t= new Telefono();
    
    public TelefonoTest() {
    }

    @Test
    public void testLeeTelefono() {
        assertTrue(t.leeTelefono(tel1)&&t.leeTelefono(tel2+tel1)&&t.leeTelefono(tel3+tel2+tel1));
    }
    @Test
    public void testGrupos(){
        System.out.println(t.tipoNumero(tel1+"a"));
    }
    @Test
    public void testFormato(){
        String num=this.tel2+this.tel1;
        assertEquals("55696041498", t.formatea(num));
    }
    @Test
    public void testCompare(){
        assertTrue(t.compare("+35", "34")>0);
    }
    
    @Test
    public void testEngade(){
        t.gardaElemento("666");
        assertFalse(t.gardaElemento("666"));
    }
    @Test
    public void testOrdena(){
        t.gardaElemento("333");
        t.gardaElemento("222");
        t.gardaElemento("+111");
        assertEquals(t.getLista().first(), "222");
    }
}
