package aplicacion;
/**
 * Clase para xestionar o nome do titular da conta bancaria
 * @author Sergio
 */
public class Persoa {
	//Variable para o almacenamento do nome
	private String nome;
        //Variable estática que establece o lonxitude máxima dos nomes das contas
	public static int nomMaxLonx=30;
        private String apelidos;
	private String fechaNac;
        /**
         * Constructor, no que se valida a lonxitude do nome de titular introducido
         * @param nome String introducido polo usuario
         * @throws Exception Se excede a lonxitude máxima fixada
         */
	public Persoa (String nome, String apellidos,String fecha) throws Exception {
		
		if (nome.length()>nomMaxLonx){
			throw new Exception("Nome con lonxitude maior da permitida");
		} else {
			this.nome=nome;
		}
                this.apelidos=apellidos;
                this.fechaNac=fecha;
	}
        /**
         * Metodo para obter o nome completo do titular 
         * @return nome String co nome e apelidos do titular
         */
	public String getNome() {
		return nome;
	}
        /**
         * Metodo para modificar o nome do titular da conta bancaria.Valida se cumple 
         * cos requerimentos de lonxitude especificados
         * @param nome String co nome a asignar 
         * @throws Exception por exceder da lonxitude maxima permitida
         */
	public void setNome(String nome) throws Exception {
		if (nome.length()>nomMaxLonx) {
			throw new Exception("Nome con lonxitude maior da permitida");
		}else {
			this.nome = nome;
		}
	}
	/**
         * Metodo para controla o paso a String dos obxectos de esta clase
         * @return String co nome e apelidos do titular
         */
	public String toString () {
		return this.nome;
	}
        /**
         * Metodo estatico para coñecer a maxima lonxitude permitida de nome
         * @return  int co numero de maximos caracteres (incluidos espazos) permitidos
         * para o almacenamento do nome
         */
        public static int getMaxLonxNome (){
            return nomMaxLonx;
        }
        /**
         * Metodo estático publico para establecer dende fora da clase a maxima lonxitude permitida
         * @param lonx numero enteiro positivo da lonxitude maxima permitida
         * @throws Exception se se introduce unha cantidade menor ou igual a 0 caracteres
         */
        public static void setMaxLonxNome(int lonx) throws Exception{
            if (lonx <= 0){
                throw new Exception ("Introduciuse unha lonxitude de nome negativa");
            } else {
                nomMaxLonx=lonx;
            }
        }
}
