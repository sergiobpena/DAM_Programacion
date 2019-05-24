package prog06;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import prog06.Serializador;
import prog06.Cliente;

public class Principal {
	
	InputStreamReader isr;
	BufferedReader br;
        Serializador sr;
	
	public Principal(String ruta) {
            
		this.isr=new InputStreamReader(System.in);
		this.br=new BufferedReader(isr);
                this.sr= new Serializador(new File (ruta));
	}
	
	public  String lee() {
		String lectura="";
		try {
			lectura =this.br.readLine();
		} catch (IOException e) {
                        System.out.println("Erro de L/E na entrada por teclado");
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
	
	public Cliente creaCliente() {
		
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
                return c;
                
		
		
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
	
	
	public void consola() {
		
		while(true) {
			
			System.out.print("\n\nIndique a operacion que desexe realizar, introducindo o numero correspondente: \n\n[1]-Engadir cliente \t "
					+ "[2]-Listar clientes \t [3]-Buscar clientes \n[4]-Borrar clientes \t [5]-Eliminar ficheiro \n[sair]-Sair da aplicacion \n\n[Operacion]: " );
			String operacion=lee();
			switch (operacion) {
			case "1":
				Cliente c =creaCliente();
                                try{
                                    this.sr.gardaCliente(c);
                                
                                } catch (Exception e2){
                                    System.out.println(e2.getMessage()); 
                                }
				break;
			case "2":
                            try{
				Cliente.listarClientes(this.sr.recuperaClientes());
                            }catch (Exception e2){
                                    System.out.println(e2.getMessage());
                                }
				break;
			case "3":
                            System.out.println("\n\nIntroduce nif do cliente a recuperar : ");
				String nif=lee();
                                try{
                                  System.out.println(this.sr.recuperaCliente(nif));  
                                } catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
				break;
			case "4":
                            System.out.println("\n\nIntroduce nif do cliente a borrar : ");
                            nif = lee();
                            try{
                                this.sr.borraCliente(nif);
                            }catch (Exception e ){
                                System.out.println(e.getMessage());
                            }
			case "5":
                            try{
                               this.sr.borraArchivo(); 
                            }catch(Exception e ){
                                System.out.println(e.getMessage());
                            }
				break;
			default:
                            System.out.println("\n\nOperación non valida!");
				break;
			}
		}
	}
	
	


	public static void main(String[] args)  {
		
            Principal ap = new Principal("clientes.dat");
            ap.consola();
		
	
		


				
	}
}
