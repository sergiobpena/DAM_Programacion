/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.cuentas;

import aplicacion.CCC;
import aplicacion.Persoa;
import java.util.Hashtable;

/**
 *
 * @author Sergio
 */
public abstract class CuentaCorrentes extends CuentaBancaria{
    
    protected Hashtable<String, Double> entAutorizadas;
    public CuentaCorrentes(Persoa p , CCC ccc){
        super( p, ccc);
    }
    public CuentaCorrentes (Persoa p , CCC ccc , Double saldo){
        super(p,saldo,ccc);
    }
    
    
    public Hashtable<String,Double> getListaEntidades (){
        return this.entAutorizadas;
    }
    public void setListaEntidades (String codigo,Double maximo){
        this.entAutorizadas.put(codigo, maximo);
    }
    
}
