import java.io.Serializable;

public class Cliente implements Serializable {
	
	private String nome;
	private String nif;
	private String direccion;
	private Double deuda;
	private String telefono;
	
	public Cliente (String nome, String nif, String direecion, Double deuda,String telefono) {
		this.deuda=deuda;
		this.telefono=telefono;
		this.direccion=direecion;
		this.nif=nif;
		this.nome=nome;
	}
	
	public Cliente() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNIF() {
		return nif;
	}

	public void setNIF(String nIF) {
		nif = nIF;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getDeuda() {
		return deuda;
	}

	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String toString () {
		return "Nome: " + this.nome + " Dni: " + this.nif + " Direcci�n " + this.direccion + " Telefono: " + this.telefono  + " Deuda: " + this.deuda;
	}
	
	public static void listarClientes(Cliente[] c) {
		for(Cliente cc : c) {
			System.out.println(cc);
		}
	}

}
