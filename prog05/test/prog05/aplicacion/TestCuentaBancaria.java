package prog05.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import prog05.aplicacion.CuentaBancaria;

/**
 *
 * @author Sergio
 */

public class TestCuentaBancaria {
    public String nomeBo="Sergio Botana Pena";
    public String nomeMalo="abcvaosidhasodhiasodahsdoiahdoaihdsoaihdoaihdoaidhaodihoadh";
    
    @Test
    public void testNome(){
        CuentaBancaria c = new CuentaBancaria();
        c.setNome(nomeBo);
        assertEquals(c.getNome(),nomeBo);
    }
            
    
}
