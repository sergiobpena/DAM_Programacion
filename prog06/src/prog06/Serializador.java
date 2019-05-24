package prog06;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serializador {
	
	private static  File ficheiro;
        
        public static File getSerializador (File archivo){
            if (ficheiro==null){
                ficheiro=archivo;
            }
            return ficheiro;
        }
	
	private Serializador(File archivo) {
		
	}
	
	public void serializaObxeto(Object o) {
            //De non existir crea
		if (!this.ficheiro.exists()) {		
                    try {
                        this.ficheiro.createNewFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
		}
		try {
			ObjectOutputStream oex= new ObjectOutputStream(new FileOutputStream(this.ficheiro));
			oex.writeObject(o);
			oex.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro non atopado cando intentas gardar cliente");
		} catch (IOException e) {
			System.out.println("Erro de lectua escritura cando intentas gardar cliente");
		}
	}
	
	//Devolve listado cos clientes existentes
	public Cliente[] recuperaClientes() throws Exception {
	
		Cliente[] c =null;
		
		if (!this.ficheiro.exists()) {
			throw new Exception("Non existen rexistros gardados ");
		} else {
			try {
				ObjectInputStream recupera = new ObjectInputStream(new FileInputStream(this.ficheiro));
                                //Se o ficheiro existe pero borraronse todolos rexistros
				if (recupera.readObject() == null) {
					throw new Exception("Non existen rexistros gardados ");
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
        
	//Comproba que existe o cliente co nif
	public boolean existeCliente(String nif) {
		Cliente [] listado=null;
            try {
                listado = recuperaClientes();
            } catch (Exception ex) {
                ex.getMessage();
            }
		boolean existe=false;
		for(Cliente c:listado) {
			if(c.getNIF().equals(nif)) {
				existe=true;
			}
		}
		return existe;
	}
        
        public Cliente recuperaCliente(String nif){
            Cliente c = null;
            if(existeCliente(nif)){
                Cliente [] listado=null;
                try {
                    listado = recuperaClientes();
                } catch (Exception ex) {
                    ex.getMessage();
                }
                for (Cliente cc:listado){
                    if(cc.getNIF().equals(nif)){
                         c=cc;
                    }
                }
            }
            return c;
        }

	public void borraCliente(String nif) throws Exception {

		Cliente[] listadoActual = recuperaClientes();
		try {

			ObjectOutputStream oex = new ObjectOutputStream(new FileOutputStream(this.ficheiro));
			if (!existeCliente(nif)) {
				throw new Exception("Non existe ningun cliente con DNI: " + nif);
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
                                serializaObxeto(listadoActualizado);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
