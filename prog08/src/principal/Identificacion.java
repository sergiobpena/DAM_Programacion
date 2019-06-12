/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author Sergio
 */
public class Identificacion {
    
    
    private Pattern patron;

    private String nombreCampo;

    
    
    public Identificacion(){
        this.patron=Pattern.compile("^([a-zA-Z])?([0-9]{8})([a-zA-Z])$");
        this.nombreCampo="identificacion";
    }
    
    public Document procesa(String c, Document doc){
        Element e=doc.createElement(this.nombreCampo);
        Matcher m = this.patron.matcher(c);
        if (m.matches()){
            e.setTextContent(c);
            if(m.group(1)!=null){
                e.setAttribute("tipo", "nie");
            }else{
                e.setAttribute("tipo", "nif");
            }
        }else{
            Comment com = doc.createComment("Erro no formato da cadea : " + c);
            doc.getDocumentElement().appendChild(com);
        }
        return doc;
    }    
}
