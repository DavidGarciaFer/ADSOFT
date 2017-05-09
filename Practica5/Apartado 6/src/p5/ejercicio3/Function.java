package p5.ejercicio3;

/**
 * Interfaz con el método necesario para ejecutar un comando 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

@FunctionalInterface
public interface Function {
	
	/**
	 * Ejecuta un comando pasado por la terminal. No implementado,
	 * es llamado por expresiones lambda
	 * @param args Argumentos del comando
	 * @throws IllegalArgumentException En caso de que no se pueda 
	 * realizar la operacion o los argumentos sean erroneos
	 */
	
	void execute(String ...args) throws IllegalArgumentException;
	
}
