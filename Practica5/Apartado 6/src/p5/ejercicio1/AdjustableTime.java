package p5.ejercicio1;

/**
 * Interfaz que realiza una extension de ObservablePorperty para poder
 * trabajas con datos de tipo entero, anyadiendo cierta funcionalidad extra
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 * 
 */

public interface AdjustableTime extends ObservableProperty<Integer>{
	
	/**
	 * Metodo para incrementar el tiempo que tiene la clase como atributo
	 * @param inc el incremento que deseamos realizar
	 */
	
	void incrementTime(int inc);
}
