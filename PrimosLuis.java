/**
* Esta aplicacion deduce que numeros de los argumentos
* pasados son primos.
* @author Luis Carabe (luis.carabe@estudiante.uam.es)
* @author David Garcia (david.garcia03@estudiante.uam.es)
*/


public class PrimosLuis{

 /**
    * Punto de entrada de la aplicacion.
    *
    * Este metodo dicrimina los numeros primos y los no primos.
    * @param args Los argumentos de la linea de comando. Se espera minimo un numero.
    */

	public static void main(String[] args){
		int aux = args.length;
		if (aux < 1){
			System.out.println("Error en los parámetros de entrada, inserta al menos un número.");
			return;
		}

		int numero;

		for(int i = 0; i < aux; i++){
			numero = Integer.parseInt(args[i]); 

		/** 
		   * Solo miramos si es primo si el numero es mayor de 1,
		   * ya que, consideramos el 0 y el 1 como no primos
		*/

			if (numero > 1){
				int flag = 0;
				/** 
					* Para saber si es primo o no, hacemos el modulo con todos los numeros 
					* anteriores a el.
				*/
				for(int j = (numero-1); j > 1 ; j--){
					int aux2;
					aux2 = numero % j;
					if (aux2 == 0){
						System.out.println("El número " + numero + " no es primo.");
						flag = 1; //Modificamos flag para saber que ya no es primo
						break;
					}
				}
				if (flag == 0){
					System.out.println("El número " + numero + " es primo.");
				}
			}
		} 
	}		
}
