/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.cuentas;

import aplicacion.CCC;
import aplicacion.Persoa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class CuentaBancaria implements Imprimible{
    
    protected Persoa titular;
    protected Double saldo;
    protected CCC ccc;
    ArrayList <CuentaBancaria> lista;
    
    public CuentaBancaria(){
        
    }
    public CuentaBancaria(Persoa p,CCC ccc){
        this.titular=p;
        this.ccc=ccc;
        this.saldo=0.;
    }
    public CuentaBancaria(Persoa p , Double saldo , CCC ccc){
        this.titular=p;
        this.saldo=saldo;
        this.ccc=ccc;
        try {
            this.lista.add((CuentaBancaria)this.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String toString(){
        return "Titular: " + this.titular +"\nSaldo actual : " + this.getSaldo() + "\nCCC : " + this.getCcc();
    }
    @Override
    public boolean equals(Object o){
        CuentaBancaria c = (CuentaBancaria) o ;
        
        if(this.getCcc().getCcc().equals(c.getCcc().getCcc())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the ccc
     */
    public CCC getCcc() {
        return ccc;
    }

    /**
     * @param ccc the ccc to set
     */
    public void setCcc(CCC ccc) {
        this.ccc = ccc;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void retirada(Double saldo) throws Exception {
        Double saldoFin =this.saldo -saldo;
        if (saldoFin<=0){
            throw new Exception("Saldo insuficiente, saldo actual: " + this.saldo);
        }else{
            this.saldo = saldo;
        }
        
    }
    public void ingreso(Double importe){
        this.saldo=this.saldo+importe;
    }
}

