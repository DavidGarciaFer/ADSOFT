package p5.ejercicio1;

import java.util.*;

/**
 * Clase que implementa una propiedad observable que a su vez es un
 * observador, ademas maneja datos enteros (AdjustableTime) 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */


public class ObservableObserver extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer>{
	
	Collection<DefaultObservableProperty<Integer>> propiedades = new ArrayList<DefaultObservableProperty<Integer>>();
	
	/**
	 * Constructor de la clase 
	 * @param val El valor al que se inicializa la propiedad de la clase
	 */
	
	public ObservableObserver(Integer val) {
		super(val);
	}

	/**
	 * Metodo con el cual se avisa a un observador de que una
	 * de sus propiedades vigiladas ha cambiado y se ejecuta la 
	 * rutina de manejo correspondiente.
	 * @param property La propiedad que ha cambiado
	 * @param oldValue El valor antiguo de la propiedad
	 */
	
	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		if(this.propiedades.contains(property) == false)
			return;
		/*
		 * Ya que el valor no puede ser negativo nuestro procedimiento
		 * es el siguiente: Eliminamos el valor antiguo del valor de la 
		 * instancia, despues anyadimos el nuevo valor al valor actual
		 */
		this.incrementTime(-oldValue);
		this.incrementTime(property.getValue());
	}
	
	/**
	 * Incrementa (o decrementa) el valor que posee la propiedad
	 * de la instancia, si el valor resultante es negativo lanza
	 * la RuntimeException IllegalArgumentException
	 */
	
	@Override
	public void incrementTime(int inc) {
		if(this.value+inc < 0)
			throw new IllegalArgumentException();
		this.setValue(this.value+inc);		
	}
	
	/**
	 * Agrega una propiedad y actualiza el valor de la propiedad
	 * de la instancia
	 * @param p Propiedad a anyadir
	 */
	
	public void add(DefaultObservableProperty<Integer> p){
		this.propiedades.add(p);
		p.addObserver(this);
		this.incrementTime(p.getValue());
		
	}

	/**
	 * Elimina una propiedad y actualiza el valor de la propiedad
	 * de la instancia 	
	 * @param p La propiedad a eliminar de la lista de observados
	 */
	
	public void remove(DefaultObservableProperty<Integer> p){
		if(this.propiedades.contains(p) == false)
			return;
		this.propiedades.remove(p);
		p.removeObserver(this);
		this.incrementTime(p.getValue()*(-1));
	}
	
}
