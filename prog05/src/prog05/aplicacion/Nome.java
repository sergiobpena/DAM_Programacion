package prog05.aplicacion;

import prog05.exceptions.NomeException;

public class Nome {
	
	private String nome;
	public static final int NOM_MAX_LENGHT=30;
	
	public Nome (String nome) throws NomeException {
		
		if (nome.length()>NOM_MAX_LENGHT){
			throw new NomeException("Nome con lonxitude maior da permitida");
		} else {
			this.nome=nome;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeException {
		if (nome.length()>NOM_MAX_LENGHT) {
			throw new NomeException("Nome con lonxitude maior da permitida");
		}else {
			this.nome = nome;
		}
	}
	
	public String toString () {
		return this.nome;
	}
}
