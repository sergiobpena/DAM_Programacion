/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.cuentas.CuentaAforro;
import aplicacion.cuentas.CuentaBancaria;
import aplicacion.cuentas.CuentaCorrEmpresa;
import aplicacion.cuentas.CuentaCorrPersonal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sergio
 */
public class AplicacionConsola {

    InputStreamReader isr;
    BufferedReader br;
    
    public AplicacionConsola(){
        this.isr= new InputStreamReader(System.in);
        this.br= new BufferedReader(isr);
    }
    
    /*Engade opcion sair*/
    public String lee() {
        String lectura = "";
        try {
            lectura = this.br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lectura.equals("sair")) {
            System.exit(0);
        }
        return lectura;
    }
    /**
     * 
    Abrir una nueva cuenta.
    Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).
    Obtener los datos de una cuenta concreta.
    Realizar un ingreso en una cuenta.
    Retirar efectivo de una cuenta.
    Consultar el saldo actual de una cuenta.
    Salir de la aplicación.

     * @param operacion
     */
    public void selectorOperacion(String operacion) {
        System.out.print("\n\nIndique a operacion que desexe realizar, introducindo o numero correspondente: \n\n"
                + "[1]-Abrir nova conta \t [2]-Listar contas existente \t [3]-Obter datos conta \n"
                + "[4]-Realizar un ingreso \t [5]-Retirar efectivo \t\t\t [6]-Consultar saldo  \n"
                + "[sair]-Finaliza programa \n\n[Operacion]: ");
        switch (operacion) {
            case "1":
                boolean aux=true;
                while(aux){
                    
                }
                this.abrirConta();
                break;
            case "2":
                this.listarContas();
                break;
            case "3":
                this.obterDatosConta();
                break;
            case "4":
                this.realizarIngreso();
                break;
            case "5":
                this.retirarEfectivo();
                break;
            case "6" :
                this.consultarSaldo();
                break;
            default:
                System.out.println("Operacion non válida\n");
        }
    }

    private void abrirConta() throws Exception {
        System.out.println("Introduce nome titular \nNome : ");
        Persoa p = new Persoa();
        p.setNome(this.lee());
        System.out.println("Introduce os apelidos do titular \nApelidos :");
        p.setApelidos(this.lee());
        System.out.println("Introduce a data de nacemento \nData nacemento DD/MM/AAAA:");
        p.setFechaNac(this.lee());

        System.out.println("Introduce CCC");
        CCC ccc = new CCC(this.lee());
        System.out.println("Indica o tipo de conta a crear\n [1]-Conta de aforro \t [2]-Conta corrente persoal \t [3]-Conta corrente empresa \n"
                + "[opcion]: ");
        String opcion = this.lee();
        CuentaBancaria conta;
        boolean aux = false;
        while (!aux) {
            switch (opcion) {
                case "1":
                    conta = new CuentaAforro(p, ccc);
                    aux=true;
                    break;
                case "2":
                    conta = new CuentaCorrPersonal(p, ccc);
                    aux=true;
                case "3":
                    conta= new CuentaCorrEmpresa(p, ccc);
                    aux=true;
                default:
                    System.out.println("Escolle opcion axeitada");
            }
        }
    }

}
