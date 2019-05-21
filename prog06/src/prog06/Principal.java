
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	
	InputStreamReader isr;
	BufferedReader br;
	String lectura;
	File archivoRespaldo= new File("clientes.dat");
	
	public Principal() {
		this.isr=new InputStreamReader(System.in);
		this.br=new BufferedReader(isr);
		this.lectura="";
	}
	
	public  String lee() {
		
		try {
			this.lectura =this.br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lectura.equals("sair")) {
			System.exit(0);
		}
		return lectura;
	}
	
	public void arrancaConsola() {
		System.out.print("Benvido a aplicaci�n de xesti�n de clientes \n"
				+ "Se desexas sair en calquera momento introduce sair");	
	}
	
	public void creaCliente() {
		
		System.out.print("Introduce o nome do cliente \n"
				+ "[Nome do Cliente]: ");
		String nome=lee();
		
		System.out.print("Introduce o nif do cliente \n"
				+ "[NIF: 99999999X]: ");
		String nif=lee();
		
		System.out.print("Introduce o direccion do cliente \n"
				+ "[Direccion]: ");
		String dir=lee();
		
		System.out.print("Introduce o telefono do cliente \n"
				+ "[Telefono]: ");
		String telefono=lee();
		
		System.out.print("Introduce deuda do cliente \n"
				+ "[Deuda]: ");
		Double deuda=Double.parseDouble(lee());
		
		Cliente c=new Cliente(nome, nif, dir, deuda, telefono);
		
		
	}
	
	public Cliente [] creaClientesProvas () {
		Cliente [] c= new Cliente [4];
		//(String nome, String nif, String direecion, Double deuda,String telefono) 
		c [0] = new Cliente("Sergio Botana Pena","44845758J","Rua San Pedro Bendito",124.5,"696041498");
		c[1]= new Cliente("Perico Palotes","6060660404X","Rua da Amarjura",1524.55,"600444555");
		c[2]= new Cliente("Matirio Noruega","6664442323Z","Pazo raxoi",456789123.1,"611611611");
		c[3]=new Cliente ("Frijol Frio","6552582581V","Monte pio",7777777777777.2,"43561125");
		return c;
	}
	

	public static Cliente [] engadeCliente (Cliente [] actual,Cliente novo) {
		
		Cliente [] novalista = new Cliente [actual.length + 1 ];
		for (int i = 0 ; i<actual.length;i++) {
			novalista[i]=actual[i];
		}
		novalista[actual.length]=novo;
		return novalista;
	}
	
	public void consolame(Principal aplicacion) {
		
		while(true) {
			
			System.out.print("\n\nIndique a operacion que desexe realizar, introducindo o numero correspondente: \n\n[1]-Engadir cliente \t "
					+ "[2]-Listar clientes \t [3]-Buscar clientes \n[4]-Borrar clientes \t [5]-Eliminar ficheiro \t\t\t [sair]-Sair da aplicacion \n\n[Operacion]: " );
			String operacion=aplicacion.lee();
			switch (operacion) {
			case "1":
				//Cliente c =aplicacion.creaCliente();
				break;
			case "2":
				//listar
				break;
			case "3":
				//buscar
				break;
			case "4":
				//Borrar cliente
			case "6":
				//Borrar ficheiro
				break;
			default:
				break;
			}
		}
	}
	
	public static Cliente [] borraCliente (String nif,Cliente[] lista) throws ArrayIndexOutOfBoundsException {
		Cliente [] novaLista = new Cliente [lista.length-1];
		int i =0;
		for (Cliente c:lista) {
			
				if (!c.getNIF().equals(nif)) {
					novaLista[i]=c;
					i++;
				}
		}
		return novaLista;
	}	
	 


	public static void main(String[] args)  {
		
		File archivoRespaldo= new File("clientes.dat");
		Principal aplicacion=new Principal();
		Serializador serial = new Serializador(archivoRespaldo);
		serial.getFicheiro().delete();
		
		Cliente c1= new Cliente("Frijol Frio","6552582581V","Monte pio",7777777777777.2,"43561125");
		


				
	}
}
