/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Sergio
 */
public class ProcesadorClientes {
    
    private Pattern patronDNI=Pattern.compile("^([0-9]{8})([a-zA-Z])$");
    private Pattern patronNIE=Pattern.compile("^([a-zA-Z])([0-9]{8})([a-zA-Z])$");
    private Pattern patronTelefono;
    private Pattern patronCorreo;
    private static String separador=",";
    
    public ProcesadorClientes(){
        
    }
    
    public static String [] separaCadea (String entrada){
        return entrada.split(separador);
    }
    public boolean nif (String cadea){
        Matcher m = this.patronDNI.matcher(cadea);
        return m.matches();
    }
    public boolean nie(String cadea){
        Matcher m = this.patronNIE.matcher(cadea);
        return m.matches();
    }
}
