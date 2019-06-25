package principal;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Nombre {

    protected String campo=null;
    protected Pattern patronNome = Pattern.compile("[a-zA-Z]+");
    protected String nombreCampo="nombre";

    public Nombre() {

    }

    public boolean valida(String nom) {
        Matcher m = this.patronNome.matcher(nom);
        return m.matches();
    }

    public void formatea() {
        //nom.replaceAll("\"","");
        //nom.toUpperCase(Locale.ITALY)
        this.campo = this.campo.trim().replaceAll("\"", "");
        this.campo = Character.toUpperCase(this.campo.charAt(0)) + this.campo.substring(1);
    }
    public Document procesa (String c , Document doc){

        if(this.valida(c)){
            this.formatea();
            Element e=doc.createElement(this.getNombreCampo());
            e.setTextContent(c);
        }else{
            Comment com = doc.createComment("Erro no procesado: " + c);
            doc.getDocumentElement().appendChild(com);
        }
        return doc;
    }
    public String getCampo() {
        return campo;
    }

    public void setCampo(String nombre) {
        this.campo=nombre;
    }

    /**
     * @return the nombreCampo
     */
    public String getNombreCampo() {
        return nombreCampo;
    }

    /**
     * @param nombreCampo the nombreCampo to set
     */
    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

}
