# Practica 5.
Decidese estructurar o programa en 3 clases:
* `CCC` que xestionara a validez e a información asociada o CCC de cada cliente.
* `Nome` para encapsular as operacions do nome do titular xestionar a validez do nome introducido
* `Cuentabancaria` que xestionara os datos completos da conta bancaria.
* `AplicacionCuentaBancaria` que xestiona as entradas e saidas de datos 

## Clase `CuentaBancaria` 
Clase para creacion de un obxecto por cada conta bancaria que se de de alta.
Estes obxectos teran como atributos os datos que se piden almacenar de cada conta:
* `ccc` codigo conta cliente.
* `nome` obxecto da clase nome co nome do titutar.
* `saldo`
Crearanse os obxectos cun saldo inicial de 0 e sendos obxectos de nome e CCC , validados nestas clases.
No que atinxe as operación sobre o liquido da conta, mediante os getter e setters correspondentes, levantarase as excepcións correspondentes as operacions non validas tales como saldo insuficiente, cantidades negativas etc.

## Clase `CCC`
Nesta clase comprobarase que o CCC introducido por teclado é valido en formato e que o DC está correctamente introducido. Para esto escribironse metodos privados para facer tales comprobación que seran aplicadas tanto no constructor con parametros definido como no metodo setCCC , os cales levantan as excepcions correspondentes, descritas nos comentarios do codigo. publicos para obter o codigo de entidade, ofinica, dixito de control e numero de conta tal e como esixen os requerimentos do enunciado da práctica.
### Validacion do CCC
Farase tanto no constructor que se invocara dende a clase principal como no metodo set seguindo o seguinte esquema: 
- Primeiro comprobase que o formato introducido polo usuario é o correcto, co seguinte patron : EEEE-OOOO-DD-CCCCCCCCCC . Comprobarase co método `comprobaFormato` a lonxitude dos 4 numeros entre guions, e logo comprobase mediante o método que o introducido entre estes guions non conteña ningun caracter non numérico
- Unha vez validado o formato comprobarase que o DC introducido é correcto para isto procederase do seguinte xeito:
    - Primeiro calcularase o DC que lle corresponde o CCC introudcudido mediante o método `obtenDixitoControl` que separará o string en substrings coas compoñentes do CCC, logo mediante o método `separaDixitos` estas compoñentes convirteas nun array de enteiros , para logo xa, mediante os coeficientes para cada compoñente obter un array de dous enteiros co DC calculado.
    - Logo comprobase que o DC introducido correspondese co calculado mediante o método `validarDC`
## Clase `Nome`
Esta clase conta con un atributo privado de membro , que é o String co nome do titular, e un atributo publico estático de clase para establecer a lonxitude máxima permitida.

Para o constructor da clase asi como para o metodo `set` do nome , comprobarase que este non excede la lonxitude máxima fixada.

Tamén se deixan plantexados os metodos publicos estáticos `get` e `set` para consultar e establecer a lonxitude maxima do nome dos titulares

## Clase `AplicacionCuentaBancaria`
Clase principal , na que se inclue o método `main`
