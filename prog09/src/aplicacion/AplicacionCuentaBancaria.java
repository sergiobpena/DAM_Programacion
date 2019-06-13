package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AplicacionCuentaBancaria {
    //Encapsulación da entrada en atributos da clase da aplición principal
    InputStreamReader isr;
    BufferedReader br;

    /**
     * Constructor que inicia os atributos abrindo o isr e un buffered reader para leer os datos
     * pedidos o usuario
     */
    public AplicacionCuentaBancaria() {
        this.isr = new InputStreamReader(System.in);
        this.br = new BufferedReader(isr);
    }
/**
 * Metodo para leer por teclado as opción que se ofrezcan, establecendo a opción para sair do programa
 * @return void
 */
    public String lee() {
        String lectura="";
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
 * Metodo con mensaxe de incio da aplicación
 */
    public void arrancaConsola() {
        System.out.print("Benvido a aplicaci�n de xesti�n de contas bancarias \n"
                + "Se desexas sair en calquera momento introduce sair");

    }
/**
 * Metodo para introducir o nome do titular da conta
 * @return nome obxecto da clase nome 
 */
    public Persoa leeNome() {
        System.out.print("\n\nIntroduce o nome e apelidos do titular da conta:");
        Persoa nome = null;
        while (nome == null) {
            try {
                nome =new Persoa(lee()) ;
            } catch (Exception e1) {
                System.out.print(e1.getMessage() + " \nIntroduce un nome cunha lonxitude máxima de: " + Persoa.nomMaxLonx + ": ");
            }
        }
        return nome;
    }
/**
 * Metodo para introducir o CCC
 * @return  CCC obxecto da mesma clase que o nome
 */
    public CCC leeCcc() {
        System.out.print("\n\nIntroduce o numero de Conta Codigo Cliente: ");
        CCC ccc = null;
        while (ccc == null) {
            try {
                ccc = new CCC(lee());
            } catch (Exception e) {
                System.out.print(e.getMessage() + "\nIntroduce de novo o CCC: ");
            }
        }
        return ccc;
    }

    public static void main(String[] args) {
        //Instanciacion da aplicacion de consola
        AplicacionCuentaBancaria ap= new AplicacionCuentaBancaria();
        //Arranque e lectura de nome e ccc
        ap.arrancaConsola();
        CCC ccc = ap.leeCcc();
        Persoa nome = ap.leeNome();
        CuentaBancariaExemploProg06 cuenta = new CuentaBancariaExemploProg06(nome, ccc);
        //variable auxiliar para toma de datos onde se podan producir excepcions
        boolean flag;
        //Bucle infinito para realizar as operacions sobre a conta bancaria, mostra por pantalla as opcions
        //e logo plantexase un bucle swich para xestionar a loxica da aplicación
        while (true) {

            System.out.print("\n\nIndique a operacion que desexe realizar, introducindo o numero correspondente: \n\n"
                    + "[1]-Consultar saldo \t [2]-Realizar un ingreso \t [3]-Retirada de fondos \n"
                    + "[4]-Nome do titular \t [5]-Entidad \t\t\t [6]-Sucursal  \n"
                    + "[7]-Dixito control \t [8]-Numero de conta \t\t [9]-CCC completo \n"
                    + "[sair]-Finaliza programa \n\n[Operacion]: ");
            String operacion = ap.lee();
            flag = true;

            switch (operacion) {
                case "1":
                    System.out.print("\nO saldo actual é: " + cuenta.getSaldo());
                    break;
                case "2":
                    System.out.print("\nIntroduce o importe a ingresar: ");
                    while (flag) {
                        try {
                            cuenta.ingresoEfectivo(ap.lee());
                            flag = false;
                        } catch (Exception e7) {
                            System.out.print("\n" + e7.getMessage() + " Introduce importe en formato correcto");
                        }
                    }
                    break;
                case "3":
                    System.out.print("\nIntroduce o importe a retirar: ");
                    while (flag) {
                        try {
                            cuenta.retiradaEfectivo(ap.lee());
                            flag = false;
                        } catch (Exception e8) {
                            System.out.print("\n" + e8.getMessage() + " Introduce importe en formato correcto:");
                        }
                    }
                    break;
                case "4":
                    System.out.print("\nO titular é :" + cuenta.getNome());
                    break;
                case "5":
                    System.out.print("\nO numero de enidade é : " + cuenta.getCcc().getEntidad());
                    break;
                case "6":
                    System.out.print("\nO n�mero de sucursal é : " + cuenta.getCcc().getSucursal());
                    break;
                case "7":
                    System.out.println("\nOs dixitos de control son : " + cuenta.getCcc().getDc());
                    break;
                case "8":
                    System.out.println("\nO número de conta é : " + cuenta.getCcc().getNumCuenta());
                    break;
                case "9":
                    System.out.println("\nO CCC completo é : " + cuenta.getCcc().getCcc());
                    break;
                default:
                    System.out.println("\nOperaci�n non válida");
                    break;
            }
        }

    }

}
