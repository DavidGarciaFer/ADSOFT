/**
* Esta aplicacion recibe un numero arbitrario de parametros y muestra cual de
* ellos es primo
* @author Luis Carabe (luis.carabe@estudiante.uam.es)
* @author David Garcia (david.garcia03@estudiante.uam.es)
*/

public class PrimosDavid{
	/**
	* Punto de entrada de la aplicacion.
	*
	* Este metodo imprime los numeros primos de los que hayan sido pasados por
	* argumento.
	*
	* @param args Los argumentos de la linea de comando. Se espera al menos un
    * numero como primer parametro
	*/

    public static void main(String[] args) {

        int flag = 0, noprimo = 0;

        if (args.length < 1){
            System.out.println("Se espera al menos un número (postivo) pasado por parámetro.");
            return;
        }

        for (String arg : args){
            int n = Integer.parseInt(arg);
            if(n != 1 && n != 0){ //En caso contrario no los comprobamos ya que no son primos
                /**
                * Para hacer la comprobación solo comprobaremos los divisores
                * hasta la raiz cuadrada del numero que queremos comprobar (en * parte entera)
                */
                noprimo = 0;
                for(int i = 2; i <= Math.sqrt(n) && noprimo != 1; i++){
                    if(n % i == 0){
                        noprimo = 1;
                    }
                }
                // En este caso el numero es primo
                if(noprimo == 0){
                    /*Si hemos encontrado uno imprimimos el siguiente mensaje solo la primera vez*/
                    if(flag == 0){
                        System.out.print("Los siguientes números son primos:");
                        flag = 1;
                    }
                    System.out.print(" "+n);
                }
            }
        }
        // Caso en el que ninguno de los números era primo
        if(flag == 0){
            System.out.println("Ninguno de los números recibidos es primo.");
        }
        System.out.println();
    }
}
