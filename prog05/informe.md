#Practica 5
Decidese estructurar o programa en 3 clases:
* CCC que xestionara a validez e a información asociada o CCC de cada cliente
* Cuenta bancaria que xestionara os datos completos da conta bancariaa
* AplicacionCuentaBancaria que 

## Clase CuentaBancaria
Clase para creacion de un obxecto por cada conta bancaria que se de de alta.
Estes obxectos teran como atributos os datos que se piden almacenar de cada conta:
* CCC codigo conta cliente.
* Nome do titutar.
* Saldo.
Crearanse os obxectos cun saldo inicial de 0. Ademais delegase no contructor a validación da lonxitude maxima do nome do titular.No que atinxe o CCC , o contructor pasaraselle un obxecto da clase CCC , que sera esta a encargada de validar o CCC introducido na interfaz , ademais de almacenar o codigo de entidade, numero de oficina , DC e numero de conta.
No que atinxe as operación sobre o liquido da conta, mediante os getter e setters correspondentes, levantarase as excepcións correspondentes as operacions non validas tales como saldo insuficiente, cantidades negativas etc.

##Clase CCC


