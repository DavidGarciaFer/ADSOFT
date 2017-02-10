/**
* Esta aplicación calcula el logaritmo Neperiano de su primer parámetro
*
* @author Luis Carabe (luis.carabe@estudiante.uam.es)
* @author David Garcia (david.garcia03@estudiante.uam.es)
*/

public class Logaritmo{
    /**
    * Punto de entrada de la aplicación.
    *
    * Este metodo imprime el logaritmo Neperiano del número que se le pasa como entrada
    *
    * @param args Los argumentos de la línea de comando. Se espera un numero como primer parametro
    */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Se espera un número como parámetro.");
            return;
        }

        String arg = args[0]; // Obtenemos el primer parámetro
        double x = Double.parseDouble(arg); // Convertimos el arg en un double

        System.out.println("El logaritmo de "+arg+" es: "+ Math.log(x));
    }
}
