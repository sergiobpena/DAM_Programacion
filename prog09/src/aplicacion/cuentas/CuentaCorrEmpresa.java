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
public class CuentaCorrEmpresa extends CuentaCorrentes{
    private Double tipoIntDesc;
    private Double maxDesc;
    
    public CuentaCorrEmpresa(Persoa p , CCC ccc , Double saldo , Double tipoInteres , Double maximo){
        super(p,ccc,saldo);
        this.maxDesc=maximo;
        this.tipoIntDesc=tipoInteres;
    }

    /**
     * @return the tipoIntDesc
     */
    public Double getTipoIntDesc() {
        return tipoIntDesc;
    }

    /**
     * @param tipoIntDesc the tipoIntDesc to set
     */
    public void setTipoIntDesc(Double tipoIntDesc) {
        this.tipoIntDesc = tipoIntDesc;
    }

    /**
     * @return the maxDesc
     */
    public Double getMaxDesc() {
        return maxDesc;
    }

    /**
     * @param maxDesc the maxDesc to set
     */
    public void setMaxDesc(Double maxDesc) {
        this.maxDesc = maxDesc;
    }
}
