/*
 */
package principal;

/**
 *
 * @author Sergio
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class Telefono implements Comparator<String>{
    
    private TreeSet<String> lista = new TreeSet<String>(new ComparadorTelefonos());
    private Pattern p = Pattern.compile("^([//+])?([//(]\\d{1,}[//)])?([0-9])+$");
    protected String nombreCampo = "emails";
    protected String nombreElemento = "email";

    public Telefono(){
        
    }
    public boolean leeTelefono(String tel){
       // Matcher m = this.p.matcher(tel);
       Matcher m = this.p.matcher(tel);
       return m.matches();
    }
    public String formatea(String c){
        Pattern parentesis= Pattern.compile("[\\(\\)]");
        Matcher ma = parentesis.matcher(c);
        if(ma.find()){
            return ma.replaceAll("");
        }
        return c;
    }
    /**
     * @return 0 se non formato
     * @return 1 se normal
     * @return 2 se prefijoc2
     * @return 3 se internacional
     */
    public int tipoNumero(String numero){
        int tipo=0;
        Matcher m = this.p.matcher(numero);
        if (m.matches()){
            if(m.group(1)!=null){
               tipo=3;
            }else if (m.group(2)!=null){
                tipo=2;
            }else{
                tipo= 1;
            }
        }
        return tipo;
    }
    public boolean gardaElemento(String c){
        return this.lista.add(c);

    }
    @Override
    public int compare(String s,String s1){
        if(s.startsWith("+")){
            if(s1.startsWith("+")){
                return s.compareTo(s1);
            }else{
                return +1;
            }
        }else{
            if(s1.startsWith("+")){
                return -1;
            }else{
                return s.compareTo(s1);
            }
        }
    }
    public Document procesa(Document doc, String[] cad) {
        for (String cadea : cad) {
            if (this.leeTelefono(cadea)) {
                if (!this.lista.add(cadea)) {
                    Comment c = doc.createComment("Direccion de correo repetida :" + cad);
                    doc.appendChild(c);
                }
            }
        }
        Iterator<String> itt = this.lista.iterator();
        while(itt.hasNext()){
        }
        return doc;
    }
    public Document procesa (Document doc){
        Element e = doc.createElement(this.nombreCampo);
        e.setAttribute("total",""+ this.lista.size());
        Iterator <String> itt = this.lista.iterator();
        if (itt.hasNext()){
            while(itt.hasNext()){
                Element e1 = doc.createElement(this.nombreElemento);
                e1.setTextContent(itt.next());
            }
        }else{
            Comment com = doc.createComment("O cliente non ten ningun telefono de contacto");
            doc.appendChild(com);
        }
        return doc;
    }
    public boolean procesa (String cads){
            String cadea=cads.trim();
            if (this.leeTelefono(cadea)){
                this.lista.add(this.formatea(cadea));
                return true;
            }else{
                return false;
            }
    }
    /**
     * @return the lista
     */
    public TreeSet <String> getLista() {
        return lista;
    }
    /**
     * @param lista the lista to set
     */
    public void setLista(TreeSet <String> lista) {
        this.lista = lista;
    }
}

