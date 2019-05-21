import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BancoDeProbas {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		File archivoRespaldo= new File("clientexx.dat");
		//archivoRespaldo.createNewFile();
		//Cliente c=new Cliente ("o","6552582581V","Monte pio",7777777777777.2,"43561125");
		try {
			//FileInputStream f = new FileInputStream(archivoRespaldo);
			//System.out.println(f.available());
			//f.close();
			//ObjectOutputStream oex= new ObjectOutputStream(new FileOutputStream(archivoRespaldo));
			//oex.writeObject(null);
			//oex.close();
			//FileInputStream f = new FileInputStream(archivoRespaldo);
			//System.out.println(f.available());
			//f.close();
			ObjectInputStream oi= new ObjectInputStream(new FileInputStream(archivoRespaldo));
			if (oi.readObject() == null) {
				System.out.println("non hai rexistros");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
