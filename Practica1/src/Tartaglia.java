/**
* Esta aplicacion dibuja la piramide de Tartaglia con un numero de filas
* pasado por argumento
* @author Luis Carabe (luis.carabe@estudiante.uam.es)
* @author David Garcia (david.garcia03@estudiante.uam.es)
*/

public class Tartaglia{
    /**
    * Punto de entrada de la aplicacion.
    *
    * Este metodo imprime la piramide de Tartaglia de las filas que indique el
    * numero pasado por argumento
    *
    * @param args Los argumentos de la linea de comando. Se espera un numero como primer parametro
    */

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Se espera un número pasado por parámetro.");
            return;
        }
        String arg = args[0];
        int n = Integer.parseInt(arg);

        int[] fila1 = new int[n]; // Aqui guardaremos la fila anterior
        //int[] fila2 = new int[n]; // Sobre esta fila trabajamos

        /*
        * Iteramos sobre el numero de filas que tendra la piramide
        */

        for(int i = 0 ; i < n ; i++){
            for(int j = i; j >= 0 ; j--){
                if(j == i || j == 0){
                    fila1[j] = 1;
                }
                else{
                    int padre1 = fila1[j];
                    int padre2 = fila1[j-1];
                    fila1[j] = padre1 + padre2;
                }
            }
            /*
            * Recorremos el vector y solo imprimimos los elementos que sean
            * distintos de cero.
            */
            for(int m : fila1){
                if(m != 0){
                    System.out.print(+m +" ");
                }
            }
            System.out.println();
        }
    }

}
