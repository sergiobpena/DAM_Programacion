package prog05;

import prog05.exceptions.NomeException;

public class Nome {
	
	private String nome;
	public static int nomMaxLonx=30;
	
	public Nome (String nome) throws NomeException {
		
		if (nome.length()>nomMaxLonx){
			throw new NomeException("Nome con lonxitude maior da permitida");
		} else {
			this.nome=nome;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome.length()>nomMaxLonx) {
			throw new Exception("Nome con lonxitude maior da permitida");
		}else {
			this.nome = nome;
		}
	}
	
	public String toString () {
		return this.nome;
	}
}
