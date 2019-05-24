package prog06;

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
        this.ficheiro = archivo;
    }

    public void serializaObxeto(Object o) throws FileNotFoundException, IOException {
        //De non existir crea
        if (!this.ficheiro.exists()) {
            this.ficheiro.createNewFile();
        }
        ObjectOutputStream oex = new ObjectOutputStream(new FileOutputStream(this.ficheiro));
        oex.writeObject(o);
        oex.close();
    }

    public void gardaCliente(Cliente c) throws FileNotFoundException, IOException, Exception {

        Cliente[] listadoAntes = null;

        listadoAntes = recuperaClientes();

        if (listadoAntes == null) {
            serializaObxeto(c);
        } else {
            Cliente[] listadoActualizado = new Cliente[listadoAntes.length + 1];
            int i = 0;
            for (Cliente cc : listadoAntes) {
                listadoActualizado[i] = cc;
                i++;
            }
            listadoActualizado[listadoAntes.length + 1] = c;
            serializaObxeto(listadoActualizado);
        }

    }
    //Devolve listado cos clientes existentes

    public Cliente[] recuperaClientes() throws FileNotFoundException, IOException, Exception {

        Cliente[] c = null;

        if (!this.ficheiro.exists()) {
            throw new Exception("Non existen rexistros gardados ");
        } else {
            ObjectInputStream recupera = new ObjectInputStream(new FileInputStream(this.ficheiro));
            //Se o ficheiro existe pero borraronse todolos rexistros
            if (recupera.readObject() == null) {
                throw new Exception("Non existen rexistros gardados ");
            } else {
                c = (Cliente[]) recupera.readObject();
            }
            recupera.close();
        }
        return c;
    }

    //Comproba que existe o cliente co nif
    public boolean existeCliente(String nif) {
        Cliente[] listado = null;
        try {
            listado = recuperaClientes();
        } catch (Exception ex) {
            ex.getMessage();
        }
        boolean existe = false;
        for (Cliente c : listado) {
            if (c.getNIF().equals(nif)) {
                existe = true;
            }
        }
        return existe;
    }

    public Cliente recuperaCliente(String nif) throws Exception {
        Cliente c = null;
        if (existeCliente(nif)) {
            Cliente[] listado = null;

            listado = recuperaClientes();
            for (Cliente cc : listado) {
                if (cc.getNIF().equals(nif)) {
                    c = cc;
                }
            }
        }
        return c;
    }

    public void borraCliente(String nif) throws FileNotFoundException, IOException, Exception {

        Cliente[] listadoActual = recuperaClientes();

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

    }
    public void borraArchivo() throws Exception{
        if (this.ficheiro.exists()){
            this.ficheiro.delete();
            System.out.println("Ficheiro borrado con éxito");
        }else{
            throw new Exception ("O arquivo non existe!");
        }
    }

}
