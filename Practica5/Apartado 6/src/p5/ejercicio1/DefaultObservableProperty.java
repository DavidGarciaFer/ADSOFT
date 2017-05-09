package p5.ejercicio1;

import java.util.*;

/**
 * Clase abstracta que implementa la propiedad observable
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 * @param <V> El tipo de valor que tiene la propiedad
 */

public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>{
	
	protected V value;
	protected List<PropertyObserver<V>> observadores = new ArrayList<PropertyObserver<V>>();
	
	/**
	 * Constructor de las propiedades observables por defecto
	 * @param val El valor con el que se inicializa la propiedad
	 */
	
	public DefaultObservableProperty(V val){
		value = val;
	}
	
	/**
	 * Metodo que devuelve el valor del ObservableProperty
	 * @return V el valor
	 */
	public V getValue(){
		return value;
	}
	
	/**
	 * Metodo que agrega un observador a la clase
	 * @param o el observador a aniadir
	 */
	public void addObserver(PropertyObserver<V> o){
		if(observadores.contains(o) == false)
			observadores.add(o);
	}
	
	/**
	 * Metodo que elimina un observador de la clase
	 * @param o el observador a eliminar
	 */
	public void removeObserver(PropertyObserver<V> o){
		if(observadores.contains(o))
			observadores.remove(o);
	}
	
	/**
	 * Metodo propio de la clase, actualiza el valor de la propiedad
	 * y ademas avisa a sus observadores
	 * @param newValue Nuevo valor de la propiedad
	 */
		
	public void setValue(V newValue){
		if(this.equals(newValue))
			return;
		V oldValue = this.value;
		this.value = newValue;
		for(PropertyObserver<V> obs : this.observadores){
			obs.propertyChanged(this, oldValue);
		}
		
	}
	
}
