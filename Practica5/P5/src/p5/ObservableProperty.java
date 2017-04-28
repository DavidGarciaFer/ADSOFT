package p5;

/**
 * Interfaz 
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 * 
 * @param <V> parametro generico de la interfaz
 */

public interface ObservableProperty<V> {
	/**
	 * Metodo que devuelve el valor del ObservableProperty
	 * @return V el valor
	 */
	V getValue();
	
	/**
	 * Metodo que agrega un observador a la clase
	 * @param o el observador a aniadir
	 */
	void addObserver(PropertyObserver<V> o);
	
	/**
	 * Metodo que elimina un observador de la clase
	 * @param o el observador a eliminar
	 */
	void removeObserver(PropertyObserver<V> o);
}