package prog05.aplicacion;

import prog05.CCC;
import prog05.exceptions.FormatoNonValidoException;
import prog05.exceptions.SaldoInsException;

public class CuentaBancaria {
	
	private double saldo;
	private CCC ccc;
	private Nome nome;
	
	public CuentaBancaria() {}
	public CuentaBancaria (Nome nome, CCC ccc) {
		this.ccc=ccc;
		this.nome=nome;
		this.saldo=0;
	}
	public static boolean comprobaDouble(String importe) {
		try {
			Double.parseDouble(importe);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public void ingresoEfectivo (String ingreso) throws FormatoNonValidoException {
		if (comprobaDouble(ingreso)) {
			this.saldo=this.saldo+Double.parseDouble(ingreso);
		}else {
			throw new FormatoNonValidoException("Erro no formato introducido.");
		}
	}
	
	public void retiradaEfectivo (String retirada) throws SaldoInsException, FormatoNonValidoException  {
		if(!comprobaDouble(retirada)) {
			throw new FormatoNonValidoException("Erro no formato da cantidade introducido");
		}
		if (Double.parseDouble(retirada)>this.saldo) {
			throw new SaldoInsException("Non hai fondos suficientes!, saldo actual: "+this.saldo);
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
	public Nome getNome() {
		return nome;
	}
	public void setNome(Nome nome) {
		this.nome = nome;
	}
	
}
