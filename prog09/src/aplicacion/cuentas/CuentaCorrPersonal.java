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
public class CuentaCorrPersonal extends CuentaCorrentes{
    private Double comision=0.015;
    
    public CuentaCorrPersonal(Persoa p , CCC ccc , Double saldo , Double comision){
        super(p,ccc,saldo);
        this.comision=comision;
    }
    public CuentaCorrPersonal(Persoa p, CCC ccc){
        super(p,ccc);
    }

    /**
     * @return the comision
     */
    public Double getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(Double comision) {
        this.comision = comision;
    }
}
