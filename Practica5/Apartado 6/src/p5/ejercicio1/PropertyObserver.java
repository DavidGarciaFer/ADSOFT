package p5.ejercicio1;

/**
 * Interfaz necesaria para la gestion de observadores de propiedades
 * con tipos genericos.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 * 
 * @param <V> El tipo de valor que tiene la propiedad
 */

public interface PropertyObserver<V> {
	
	/**
	 * Metodo con el cual se avisa a un observador de que una
	 * de sus propiedades vigiladas ha cambiado y se ejecuta la 
	 * rutina de manejo correspondiente
	 * @param property La propiedad que ha cambiado
	 * @param oldValue El valor antiguo de la propiedad
	 */
	
	void propertyChanged(ObservableProperty<V> property, V oldValue);
	
}