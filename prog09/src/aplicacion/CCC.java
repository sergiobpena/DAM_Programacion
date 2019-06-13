package aplicacion;


/**
 * Clase que xestiona os CCC
 * @author Sergio
 */

public class CCC {
        //Atributo para almacenar o CCC completo
	private String ccc;
        //Atributo para almacenar os dixitotos da entidade
	private String entidad;
        //Atributo para almacenar os dixitos da sucursal
	private String sucursal;
        //Atributo para almacenar o DC
	private String dc;
        //Atributo para almacenr o numero de conta
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
 * Metodo para comprobar que se introduciron numeros no patron esixido o 
 * usuario
 * @param entradaUsuario
 * @return true se temos numeros false se temos outros caracteres
 */
	private boolean comprobaFormatoNumero(String entradaUsuario) {
		try {
			Double.parseDouble(entradaUsuario);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
/**
 * Metodo para comprobar que se insertou o CCC no formato EEEE-OOOO-DD-CCCCCCCCCC
 * @param entradaUsuario String que se lee.
 * @return true ou false segundo este ben insertado o CCC 
 */
	private  boolean comprobaFormato(String entradaUsuario) {
		String [] cadea = entradaUsuario.split("-");
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
 * @param entradaComponente String introducido coa compoñente do cc 
 * @return numeroSplit [] array compoñente en enteiros
 */
	public static int [] separaDixitos (String entradaComponente) {
            //Primeiro paso de String a array de char
		char [] numeroString = entradaComponente.toCharArray();
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
 * @param cccIntroducida String co CCC
 * @return codCont array cos dous dixitos de control
 */
	private int[] obtenDixitoControl(String cccIntroducida) {
		//Declaracion de variables
                //Separa o CCC nun String[4] onde a primeira compoñente e o codigo de 
                //entidade , a ssegunda o codigo de oficina , a terceira o DC e a cuarta o numero de conta
		String [] cadea = cccIntroducida.split("-");
		int [] codEntidad=separaDixitos(cadea[0]);
                //Variable correspondentes os coeficientes de calculo do DC asociados
                //o codigo de entidad
		int [] coefEntidad = {4,8,5,10};
		int [] codOficina = separaDixitos(cadea[1]);
                //Variable correspondentes os coeficientes de calculo do DC asociados
                //o codigo de oficina
		int [] coefOficina= {9,7,3,6};
		int[] numConta= separaDixitos(cadea[3]);
                //Variable correspondentes os coeficientes de calculo do DC asociados
                //o numero de conta
		int[] coefConta = {1,2,4,8,5,10,9,7,3,6};
                //Variable array de 2 int para obter o DC , inicializase a 0
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
 * @param cccIntroducida String procedente da lectura do CCC
 * @return true se o DC é valido , false en caso contrario
 */
	private boolean validarDC (String cccIntroducida) {
		//Declaracion de variables
                //Separacion do string introducido
		String[] cccFormateadaArray= cccIntroducida.split("-");
                //Almacenamento do DC introducido
		int[] dcIntroducido=separaDixitos(cccFormateadaArray[2]);
                //Almacenamento do dc calculado
		int [] dcCalculado= obtenDixitoControl(cccIntroducida);
		
		//presuncion de inocencia da CCC introducida e comprobaci�n de que o DC introducido esta ben
		boolean validado=true;
		//Comrpoba se algundos dixitos de control introducidos difire dos calculados
		if(dcCalculado[0]!=dcIntroducido[0]||dcCalculado[1]!=dcIntroducido[1]) {
			validado=false;
		}
		return validado;
	}
	/**
         * Metodo para controlar o paso a string dos obxectos da clase
         * @return String co CCC introducido en formato EEEE-OOOO-DD-CCCCCCCCCC
         */
	public String toString () {
		return this.ccc;
	}
        /**
         * Metodo para obter o CCC completo 
         * @return String co CCC en formato EEEE-OOOO-DD-CCCCCCCCCC
         */
	public String getCcc() {
		return ccc;
	}
        /**
         * Metodo para cambiar o CCC de cada obxecto. Valida o DC introducido e o 
         * formato.
         * @param ccc String introducido polo usuario
         * @throws Exception para formato erroneo e DC non valido
         */
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
        /**
         * Metodo para retornar os dixitos correspondentes a entidade
         * @return String cos dixitos de entidade
         */
	public String getEntidad() {
		return entidad;
	}
        /**
         * Metodo para obter os dixitos correspondentes a sucursal
         * @return String co dixitos da sucursal
         */
	public String getSucursal() {
		return sucursal;
	}
        /**
         * Metodo para obter o DC
         * @return String co DC
         */
	public String getDc() {
		return dc;
	}
        /**
         * Metodo para obter o numero de conta
         * @return String co numero de conta
         */
	public String getNumCuenta() {
		return numCuenta;
	}
	
}