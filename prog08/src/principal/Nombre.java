/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;



/**
 *
 * @author Sergio
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Nombre {
    private String campo;
    private Pattern patronNome=Pattern.compile("[a-zA-Z]+");
    /**
     * @return the nombre
     */
    public String getNombre() {
        return campo;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.campo = nombre;
    }
    
    public Nombre(){
        
    }
    
    public boolean valida(String nom){
        Matcher m = this.patronNome.matcher(nom);
        return m.matches();
    }
    public void formatea() {
        //nom.replaceAll("\"","");
        //nom.toUpperCase(Locale.ITALY)
        this.campo=this.campo.trim().replaceAll("\"", "");
        this.campo= Character.toUpperCase(this.campo.charAt(0))+this.campo.substring(1);
    } 
}
