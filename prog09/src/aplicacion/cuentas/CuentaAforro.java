/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.cuentas;

import aplicacion.CCC;
import aplicacion.Persoa;

/**
 *
 * @author Sergio
 */
public class CuentaAforro extends CuentaBancaria{
    
    protected double tipoInteres;
    
    public CuentaAforro(Persoa p,CCC ccc,Double saldo){
        super(p,saldo,ccc);
    }
    public CuentaAforro (Persoa p, CCC ccc){
        super(p,ccc);
    }
    
}
