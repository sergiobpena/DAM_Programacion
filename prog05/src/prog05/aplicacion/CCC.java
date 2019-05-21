package prog05.aplicacion;

import prog05.exceptions.FormatoNonValidoException;
import prog05.exceptions.NumeroErroneoException;

/**
 * Clase que xestiona os Codigos de Conta Cliente CCC4
 * 
 * @author Sergio Botana Pena
 * 
 *
 */
public class CCC {
	
	private String ccc;
	private String entidad;
	private String sucursal;
	private String dc;
	private String numCuenta;
/**
 * 
 * @param ccc
 * @throws NumeroErroneoException
 * @throws FormatoNonValidoException
 */
	public CCC (String ccc) throws NumeroErroneoException, FormatoNonValidoException {
		if (!comprobaFormato(ccc)) {
			throw new FormatoNonValidoException("O numero de conta introducido non est� no formato axeitado, EX: 035-0242-84-3832312921");	
		}else if (!validarDC(ccc)){
			throw new NumeroErroneoException("O numero de conta " + ccc + " introducido non � v�lido");
		}else {
			this.ccc=ccc;
			String [] cadea = ccc.split("-");
			this.entidad= cadea[0];
			this.sucursal=cadea[1];
			this.dc=cadea[2];
			this.numCuenta=cadea[3];
		}
	}
/**
 * 
 * @param numero
 * @return
 */
	public static boolean comprobaEnteiros(String numero) {
		try {
			Double.parseDouble(numero);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
/**
 * 	
 * @param numero
 * @return
 */
	public static boolean comprobaFormato(String numero) {
		String [] cadea = numero.split("-");
		boolean [] numeros = {false,false,false,false};
		
		if (cadea.length==4 && cadea[0].length()==4 && cadea[1].length()==4 && cadea[2].length()==2 && cadea[3].length()==10 ) {
			for (int i= 0 ; i<cadea.length ;i++) {
				numeros[i]=comprobaEnteiros(cadea[i]);
			}
			if(numeros[0] && numeros [1] && numeros [2] && numeros [3]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
/**
 * 	
 * @param numero
 * @return
 */
	public static int [] separaDixitos (String numero) {
		char [] numeroString = numero.toCharArray();
		int [] numeroSplit = new int [numeroString.length];
		
		for (int i = 0 ; i< numeroString.length;i++) {
			numeroSplit[i]=Character.getNumericValue(numeroString[i]);
		}
		return numeroSplit;
	}
	
/**
 * 	
 * @param cccFormateada
 * @return
 */
	public static int[] obtenDixitoControl(String cccFormateada) {
		//Declaracion de variables
		String [] cadea = cccFormateada.split("-");
		int [] codEntidad=separaDixitos(cadea[0]);
		int [] coefEntidad = {4,8,5,10};
		int [] codOficina = separaDixitos(cadea[1]);
		int [] coefOficina= {9,7,3,6};
		int[] numConta= separaDixitos(cadea[3]);
		int[] coefConta = {1,2,4,8,5,10,9,7,3,6};
		int [] codCont = {0,0};
		
		//Bucle for para a suma da multiplicacion dos dixitos da entidade e oficina polos seus respectivos coeficientes
		for (int i=0;i< codEntidad.length ; i++ ) {
			codCont[0]=codCont[0] + codEntidad[i]*coefEntidad[i]+codOficina[i]*coefOficina[i];
		}
		//Bucle for para a suma da multiplicacion dos dixitos do numero de conta polos seus respectivos coeficientes
		for (int i = 0;i<numConta.length;i++) {
			codCont[1]=codCont[1] +numConta[i]*coefConta[i];
		}
		//modulo 11 dos dous dixitos e obtencion do seu correspondente dixito definitivo
		for (int i = 0 ; i <codCont.length ; i++) {
			codCont[i]=11-(codCont[i]%11);
			if (codCont[i]==11) {
				codCont[i]=0;
			}else if (codCont[i]==10) {
				codCont[i]=1;
			}
		}
		return codCont;
	}
/**
 * 	
 * @param cccFormateada
 * @return
 */
	public static boolean validarDC (String cccFormateada) {
		//Declaracion de variables
		String[] cccFormateadaArray= cccFormateada.split("-");
		int[] dcIntroducido=separaDixitos(cccFormateadaArray[2]);
		int [] dcCalculado= obtenDixitoControl(cccFormateada);
		
		//presuncion de inocencia da CCC introducida e comprobaci�n de que o DC introducido esta ben
		boolean validado=true;
		
		if(dcCalculado[0]!=dcIntroducido[0]||dcCalculado[1]!=dcIntroducido[1]) {
			validado=false;
		}
		return validado;
	}
	
	public String toString () {
		return this.ccc;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) throws NumeroErroneoException, FormatoNonValidoException {
		if (!CCC.comprobaFormato(ccc)) {
			throw new FormatoNonValidoException("O numero de conta introducido non est� no formato axeitado, EX EEEE-SSSS-DD-CCCCC");	
		}else if (!CCC.validarDC(ccc)){
			throw new NumeroErroneoException("O numero de conta " + ccc + "introducido � erroneo");
		}else {
			this.ccc=ccc;
			String [] cadea = ccc.split("-");
			this.entidad= cadea[0];
			this.sucursal=cadea[1];
			this.dc=cadea[2];
			this.numCuenta=cadea[3];
		}
	}	

	public String getEntidad() {
		return entidad;
	}

	public String getSucursal() {
		return sucursal;
	}

	public String getDc() {
		return dc;
	}

	public String getNumCuenta() {
		return numCuenta;
	}
	
}