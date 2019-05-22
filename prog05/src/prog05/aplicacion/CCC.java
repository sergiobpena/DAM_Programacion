package prog05.aplicacion;


/**
 * Clase que xestiona os CCC
 * @author Sergio
 */

public class CCC {

	private String ccc;
	private String entidad;
	private String sucursal;
	private String dc;
	private String numCuenta;
/**
 * Constructor da clase CCC 
 * @param ccc String co numero de conta cliente , debera ir co formato EEEE-OOOO-DD-CCCCCCCCCC
 * @throws Exception Comproba que o CCC introducido é correcto en formato e co patron antes exposto
 */
	public CCC (String ccc) throws Exception {
		if (!comprobaFormato(ccc)) {
			throw new Exception ("O numero de conta introducido non está no formato axeitado, EX: 0035-0242-84-3832312921");	
		}else if (!validarDC(ccc)){
			throw new Exception("O numero de conta " + ccc + " introducido non é válido");
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
 * Metodo para encapsular as NumberFormatExceptions
 * @param numero
 * @return true se temos numeros false se temos outros caracteres
 */
	private boolean comprobaFormatoNumero(String numero) {
		try {
			Double.parseDouble(numero);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
/**
 * Metodo para comprobar que se insertou o CCC no formato EEEE-OOOO-DD-CCCCCCCCCC
 * @param numero String que se lee.
 * @return true ou false segundo este ben insertado o CCC 
 */
	private  boolean comprobaFormato(String numero) {
		String [] cadea = numero.split("-");
                //Array booleana auxiliar para comprobar que os catro numeros introducidos 
                //por teclado estan en formato numerico, inicialmente suponse que están mal
		boolean [] numeros = {false,false,false,false};
		//Comprobacion que a lonxitude dos numeros introducidos é a esperada
		if (cadea.length==4 && cadea[0].length()==4 && cadea[1].length()==4 && cadea[2].length()==2 && cadea[3].length()==10 ) {
                    //Bucle para comprobar que as cadeas introducidas estan en formato
                    //numerico enchendo o array booleano 
                    for (int i= 0 ; i<cadea.length ;i++) {
				numeros[i]=comprobaFormatoNumero(cadea[i]);
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
 * Método que sepata o string en array de int para facilitar o calculo do DC
 * @param numero String introducido co CCC en formato 
 * @return numeroSplit [] array co CCC en integer
 */
	public static int [] separaDixitos (String numero) {
            //Primeiro paso de String a array de char
		char [] numeroString = numero.toCharArray();
                //Instanciación do array de int a encher
		int [] numeroSplit = new int [numeroString.length];
		//Bucle para o recheo do array de int, onde se pasa o valor en char
                //a int 
		for (int i = 0 ; i< numeroString.length;i++) {
			numeroSplit[i]=Character.getNumericValue(numeroString[i]);
		}
		return numeroSplit;
	}
/**
 * Metodo que calcula o DC correspondente os codigos de entidade,oficina e numero
 * de conta introducidos
 * @param cccFormateada String co CCC
 * @return codCont array cos dous dixitos de control
 */
	private int[] obtenDixitoControl(String cccFormateada) {
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
 * Metodo que comproba que o DC introducido coincide co esperado correspondente os 
 * datos introducidos
 * @param cccFormateada String procedente da lectura do CCC
 * @return true se o DC é valido , false en caso contrario
 */
	private boolean validarDC (String cccFormateada) {
		//Declaracion de variables
		String[] cccFormateadaArray= cccFormateada.split("-");
		int[] dcIntroducido=separaDixitos(cccFormateadaArray[2]);
		int [] dcCalculado= obtenDixitoControl(cccFormateada);
		
		//presuncion de inocencia da CCC introducida e comprobaci�n de que o DC introducido esta ben
		boolean validado=true;
		//Comrpoba se algundos dixitos de control introducidos difire dos calculados
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

	public void setCcc(String ccc) throws Exception{
		if (!comprobaFormato(ccc)) {
			throw new Exception("O numero de conta introducido non esté no formato axeitado, EX EEEE-SSSS-DD-CCCCC");	
		}else if (!validarDC(ccc)){
			throw new Exception("O numero de conta " + ccc + "introducido é erroneo");
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