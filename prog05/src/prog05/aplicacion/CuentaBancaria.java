package prog05.aplicacion;
/**
 * Clase CuentaBancaria, para creación de obxectos de cada conta bancaria que se 
 * faga alta. Xestionara as operacions sobre o saldo e almacenara o CCC e o Nome do 
 * titular
 * @author Sergio
 */
public class CuentaBancaria {
	
	private double saldo;
	private CCC ccc;
	private Nome nome;
	
	public CuentaBancaria() {}
        /**
         * Constructor. As validacións deleganse nas clases CCC e Nome
         * @param nome obxecto cos datos do titutal da conta
         * @param ccc  obxecto co codigo conta cliente validado
         */
	public CuentaBancaria (Nome nome, CCC ccc){
   
            this.ccc=ccc;
            this.nome=nome;
            this.saldo=0;
 
	}
        /**
         * Metodo para validar a entrada do usuario, descartando valores non numericos
         * inveriores ou iguales a 0
         * @param importe String introducido polo usuario co importe
         * @return true se é correcto false en caso contrario
         */
	private boolean comprobaImporte(String importe) {
		try {
			Double imp=Double.parseDouble(importe);
                        if( imp <= 0.0){
                            return false;
                        } else{
                            return true;
                        }
		} catch (NumberFormatException e) {
			return false;
		}
	}
        /**
         * Metodo para xestionar os ingresos na conta.
         * @param ingreso importe introducido polo usuario
         * @throws Exception se non se introduci
         */
	public void ingresoEfectivo (String ingreso) throws Exception {
		if (comprobaImporte(ingreso)) {
			this.saldo=this.saldo+Double.parseDouble(ingreso);
		}else {
			throw new Exception("Erro no importe introducido");
		}
	}
	
	public void retiradaEfectivo (String retirada) throws Exception  {
		if(!comprobaImporte(retirada)) {
			throw new Exception("Erro no importe introducido");
		}
		if (Double.parseDouble(retirada)>this.saldo) {
			throw new Exception("Non hai fondos suficientes!, saldo actual: "+this.saldo);
		}else {
			this.saldo=this.saldo-Double.parseDouble(retirada);
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public CCC getCcc() {
		return this.ccc;
	}
	public void setCcc(CCC ccc) {
		this.ccc = ccc;
	}
	public Nome getNome() {
		return this.nome;
	}
}