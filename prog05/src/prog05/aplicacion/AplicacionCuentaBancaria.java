package prog05.aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import prog05.exceptions.FormatoNonValidoException;
import prog05.exceptions.NomeException;
import prog05.exceptions.NumeroErroneoException;
import prog05.exceptions.SaldoInsException;


public class AplicacionCuentaBancaria {
	
	InputStreamReader isr;
	BufferedReader br;
	boolean sair;
	String lectura;
	
	
	public AplicacionCuentaBancaria() {
		this.isr=new InputStreamReader(System.in);
		this.br=new BufferedReader(isr);
		this.sair=false;
	}
	
	public static String lee() {
		String lectura="";
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try {
			lectura = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lectura.equals("sair")) {
			System.exit(0);
		}
		return lectura;
	}
	
	public static void arrancaConsola() {
		System.out.print("Benvido a aplicaci�n de xesti�n de contas bancarias \n"
				+ "Se desexas sair en calquera momento introduce sair");
		
	}
	
	public static Nome leeNome() {
		System.out.print ("\n\nIntroduce o nome e apelidos do titular da conta:");
		
		Nome nome=null;
		
		while (nome==null) {
			try {
				nome=new Nome(lee());
			}catch (NomeException e1) {
				System.out.print(e1.getMessage()+ "Erro,lonxitude maxima de nome excedida, \nIntroduce un nome cunha lonxitude m�xima de: " + Nome.NOM_MAX_LENGHT + ": ");
			}
		}
		return nome;
	}
	
	public static CCC leeCcc() {
		System.out.print("\n\nIntroduce o numero de Conta Codigo Cliente: ");
		CCC ccc=null;
		while(ccc==null) {
			try {
				ccc=new CCC(lee());
			}catch (FormatoNonValidoException e) {
				System.out.print(e.getMessage()+"\nIntroduce de novo o CCC: ");
			}catch (NumeroErroneoException e1) {
				System.out.print(e1.getMessage()+"\nIntroduce de novo o CCC: ");
			}
		}
		return ccc;
	}
	

	public static void main(String[] args)  {
		
		
		arrancaConsola();
		CCC ccc=leeCcc();
		Nome nome=leeNome();
		CuentaBancaria cuenta= new CuentaBancaria(nome, ccc);
		boolean flag;
		
		while(true) {
			
			System.out.print("\n\nIndique a operacion que desexe realizar, introducindo o numero correspondente: \n\n[1]-Consultar saldo \t "
					+ "[2]-Realizar un ingreso \t [3]-Retirada de fondos \n[4]-Nome do titular \t [5]-Sucursal \t\t\t [6]-Numero de conta \n[sair]-Finaliza programa \n\n[Operacion]: " );
			String operacion=lee();
			flag=true;
			
			switch (operacion) {
			case "1":
				System.out.print("\nO saldo actual �: "+cuenta.getSaldo());
				break;
			case "2":
				System.out.print("\nIntroduce o importe a ingresar: ");
				while(flag) {
					try {
						cuenta.ingresoEfectivo(lee());
						flag=false;
					}catch (FormatoNonValidoException e7) {
						System.out.print("\n"+e7.getMessage()+"Introduce importe en formato correcto");
					}
				}
				
				break;
			case "3":
				System.out.print("\nIntroduce o importe a retirar: ");
				while (flag) {
					try {
						cuenta.retiradaEfectivo(lee());
						flag=false;
					}catch (FormatoNonValidoException e8){
						System.out.print("\n"+e8.getMessage()+"Introduce importe en formato correcto:");
					}catch (SaldoInsException e9) {
						System.out.print("\n"+e9.getMessage()+": ");
					}
				}
				break;
			case "4":
				System.out.print("\nO titular � :" + cuenta.getNome());
				break;
			case "5":
				System.out.print("\nO numero de sucursal � : "+cuenta.getCcc().getSucursal());
				break;
			case "6":
				System.out.print("\nO n�mero de conta � : "+ cuenta.getCcc().getNumCuenta());
				break;
			default:
				System.out.println("\nOperaci�n non v�lida");
				break;
			}
		}

	}
	
}
