package prog05.aplicacion;

public class CuentaBancaria {
	
	private double saldo;
	private CCC ccc;
	private String nome;
        private static int maxLonxNome=30;
	
	public CuentaBancaria() {}
        
	public CuentaBancaria (String nome, CCC ccc) throws Exception{
            if (comprobaNome(nome)){
                this.ccc=ccc;
		this.nome=nome;
		this.saldo=0;
            } else{
                throw new Exception("O nome introducido excede a lonxitude maxima");
            }
	}
        /**
         * 
         * @param nome String co nome do titular da conta.
         * @return true se cumple cos requerimentos false en caso contrario.
         */
        private boolean comprobaNome(String nome){
            if (nome.length()>CuentaBancaria.getMaxLonxNome()){
                return false;
            } else {
                return true;
            }
        }
        
	private boolean comprobaImporte(String importe) {
		try {
			Double imp=Double.parseDouble(importe);
                        if( imp <= 0.0){
                            return true;
                        } else{
                            return false;
                        }
		} catch (NumberFormatException e) {
			return false;
		}
	}
        
	public void ingresoEfectivo (String ingreso) throws Exception {
		if (comprobaImporte(ingreso)) {
			this.saldo=this.saldo+Double.parseDouble(ingreso);
		}else {
			throw new Exception("Erro no importe introducido");
		}
	}
	
	public void retiradaEfectivo (String retirada) throws Exception  {
		if(!comprobaImporte(retirada)) {
			throw new Exception("Erro no formato da cantidade introducido");
		}
		if (Double.parseDouble(retirada)>this.saldo) {
			throw new Exception("Non hai fondos suficientes!, saldo actual: "+this.saldo);
		}else {
			this.saldo=this.saldo-Double.parseDouble(retirada);
		}
	}
	
	public double getSaldo() {
		return saldo;
	}

	public CCC getCcc() {
		return ccc;
	}
	public void setCcc(CCC ccc) {
		this.ccc = ccc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
            if (comprobaNome(nome)){
                this.nome = nome;
            } else {
                throw new Exception ("O nome introducido excede a lonxitude maxima");
            }
		
	}
        
        public static int getMaxLonxNome (){
            return maxLonxNome;
        }
        public static void setMaxLonxNome(int lonx) throws Exception{
            if (lonx <= 0){
                throw new Exception ("Introduciuse unha lonxitude de nome negativa");
            } else {
                maxLonxNome=lonx;
            }
        }
}