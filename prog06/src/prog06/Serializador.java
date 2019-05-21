
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {
	
	private File ficheiro;
	
	public Serializador(File archivo) {
		this.ficheiro= ficheiro;
	}
	
	public void serializaObxeto(Cliente o) {
	
		if (!this.ficheiro.exists()) {		
			this.ficheiro.createNewFile();
		}
		try {
			
			
			ObjectOutputStream oex= new ObjectOutputStream(new FileOutputStream(this.ficheiro));
			oex.writeObject(o);
			oex.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro non atopado cando intentas gardar cliente");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de lectua escritura cando intentas gardar cliente");
			e.printStackTrace();
		}
	}
	
	
	public Cliente[] recuperaClientes() throws SinClientesGardadosException {
	
		Cliente[] c =null;
		
		if (!this.ficheiro.exists()) {
			throw new SinClientesGardadosException("Non existen rexistros gardados ");
		} else {
			
			try {
				ObjectInputStream recupera = new ObjectInputStream(new FileInputStream(this.ficheiro));
				if (recupera.readObject() == null) {
					throw new SinClientesGardadosException("Non existen rexistros gardados ");
				} else {
					c = (Cliente[]) recupera.readObject();
				}
				recupera.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public boolean existeCliente(String nif) throws SinClientesGardadosException {
		Cliente [] listado= recuperaClientes();
		boolean existe=false;
		
		for(Cliente c:listado) {
			if(c.getNIF().equals(nif)) {
				existe=true;
			}
		}
		return existe;
	}

	public void borraCliente(String nif) throws ClienteNonAtopadoException, SinClientesGardadosException {

		Cliente[] listadoActual = recuperaClientes();
		try {

			ObjectOutputStream oex = new ObjectOutputStream(new FileOutputStream(this.ficheiro));
			if (!existeCliente(nif)) {
				throw new ClienteNonAtopadoException("Non existe ningun cliente con DNI: " + nif);
			} else if (listadoActual.length == 1) {
				oex.writeObject(null);
				oex.close();
			} else {
				Cliente[] listadoActualizado = new Cliente[listadoActual.length - 1];
				int i = 0;
				for (Cliente c : listadoActual) {
					if (!c.getNIF().equals(nif)) {
						listadoActualizado[i] = c;
						i++;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFicheiro() {
		return ficheiro;
	}
	
}
