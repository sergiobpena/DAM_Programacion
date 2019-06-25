
package principal;

import java.util.HashMap;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Sergio
 */
public class ProcesadorClientes {

    private Nombre nom = new Nombre();
    private Apellidos apel = new Apellidos();
    private Identificacion ident = new Identificacion();
    private Correo corr = new Correo();
    private Telefono tel = new Telefono();
    private HashMap<Integer, String> listaErros = new HashMap<Integer, String>();

    private String separador = ",";

    public String[] separaCadea(String entrada) {

        return entrada.split(separador);
    }

    public void procesaEntrada(String c) {
        Document doc = DOMUtil.crearDOMVacio("cliente");
        String[] a = this.separaCadea(c);
        ident.procesa(a[0], doc);
        nom.procesa(a[1], doc);
        apel.procesa(a[2], doc);
        Element e = doc.createElement("Datos de contacto");
        if (a.length > 3) {
            for (int i = 3; i < a.length; i++) {
                if (tel.procesa(a[i])) {
                } else if (corr.procesa(c)) {
                } else {
                    this.listaErros.put(i, c);
                }
            }
            tel.procesa(doc);
            corr.procesa(doc);
            if (this.listaErros.size() > 0) {
                doc.createElement("Erros");
                this.listaErros.forEach((k, v) -> doc.appendChild(doc.createComment("Erro na lectura, entrada :" + k + "con valor: " + v)));
            }
        } else {
            Comment com = doc.createComment("Non se proporcionaron datos de contacto");
        }
    }

    public void creaDom() {

        this.procesaEntrada(separador);

        //DOMUtil.DOM2XML(doc, salida);
    }

    /*
        GETTER E SETTERS
     */
    public Identificacion getIdent() {
        return ident;
    }

    public void setIdent(Identificacion ident) {
        this.ident = ident;
    }

    public Apellidos getApel() {
        return apel;
    }

    public void setApel(Apellidos apel) {
        this.apel = apel;
    }

}
