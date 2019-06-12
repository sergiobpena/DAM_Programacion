/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Comparator;

/**
 *
 * @author Sergio
 */
public class ComparadorTelefonos implements Comparator <String>{
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
    
}
