/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Sergio
 */
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
        
public class Correo {
    
    private static Pattern p = Pattern.compile("[^@]+@[^@]+\\.[a-zA-Z]{2,}");
    protected TreeSet <String> lista= new TreeSet<String>();
    protected String nombreCampo="emails";
    protected String nombreElemento="email";
    public Correo(){
        
    }

    
    public boolean comproba(String cadea){
        Matcher m = p.matcher(cadea);
        return m.matches();
    }
    public String formatea(String correo){
        return correo.toLowerCase();
    }
    public boolean gardaElemento(String c){
        return this.lista.add(c);
    }
    public boolean procesa(String cads){
            String cadea=cads.trim();
            if (this.comproba(cadea)){
                this.lista.add(this.formatea(cadea));
                return true;
            }else{
                return false;
            }
    }
    
    public Document procesa(Document doc) {
        Element e = doc.createElement(this.nombreCampo);
        e.setAttribute("total", "" + this.lista.size());
        Iterator<String> itt = this.lista.iterator();
        if (itt.hasNext()) {
            while (itt.hasNext()) {
                Element e1 = doc.createElement(this.nombreElemento);
                e1.setTextContent(itt.next());
            }
        } else {
            Comment com = doc.createComment("O cliente non ten ningun correo de contacto");
            doc.appendChild(com);
        }
        return doc;
    }
    public Document procesa(Document doc, String[] cad) {
        
        for (String cadea : cad) {
            if (this.comproba(cadea)) {
                Element e = doc.createElement(this.nombreCampo);
                if (lista.contains(cadea)) {
                    Comment com = doc.createComment("Numero de telefono repetido : " + cadea);
                    doc.getDocumentElement().appendChild(com);
                } else {
                    String formateada = this.formatea(cadea);
                    lista.add(formateada);
                }
                Iterator <String> itt=this.lista.iterator();
                while (itt.hasNext()) {
                    Element e1 = doc.createElement(this.nombreElemento);
                    e1.setTextContent(itt.next());
                }
            }
        }
        return doc;
    }
}
