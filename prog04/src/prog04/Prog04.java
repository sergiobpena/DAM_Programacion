
package prog04;

/**
 *
 * @author Sergio
 */
public class Prog04 {
    //Apartado 1
    public static String par (double par){
        if (par%2==0){
            return "É par";
        } else {
            return "É impar";
        }
    }
    public static boolean bisiesto (int ano){
        if (ano%400 == 0 ){
            return true;
        } else if (ano%100 == 0 ){
            return false;
        }else if (ano%4 == 0 ){
            return true;
        }else{
            return false;
        }
    }
    //Apartado 2
    public static int numeroDias(String mes_ano){
        int mes= Integer.parseInt(mes_ano.split("-")[0]);
        int ano=Integer.parseInt(mes_ano.split("-")[1]);

        int dias=0;
        switch (mes) {
            case 2 :
                if (bisiesto(ano)){
                    dias=29;
                }else{
                    dias=28;
                }
                break;
            case 4 : 
                dias=30;
                break;
            case 6 :
                dias=30;
                break;
            case 9:
                dias = 30;
                break;
            case 11:
                dias= 30 ;
                break;
            default:
                dias=31;
                break;
        }
        return dias;
    }
    //Apartado 3
    
    public static void factoresPrimos(int numero){
        if (numero > 2 ){
            for (int i = 2 ; i < numero ; i++){
                while (numero % i == 0){
                    numero=numero/i;
                    System.out.println(i+"");
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String mes_ano="02-2000";
        //System.out.println(numeroDias(mes_ano));
        
        factoresPrimos(2550);
    }
    
}
