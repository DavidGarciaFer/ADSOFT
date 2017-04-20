/**
 * 
 */
package p4.exceptions;

import p4.punit.IPhysicalUnit;

/**
 * Clase que implementa la excepcion cuando dos unidades no son compatibles
 *   
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */
public class QuantityException extends Exception{

	private static final long serialVersionUID = -5835302066041999790L;
	protected IPhysicalUnit q1, q2;	
	
	/**
	 * Constructor de la excepcion
	 * @param q1 la primera unidad involucrada
	 * @param q2 la segunda unidad involucrada
	 */
	
	public QuantityException(IPhysicalUnit q1, IPhysicalUnit q2){
		this.q1 = q1;
		this.q2 = q2;
	}
	
	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la excepcion
	 */
	
	@Override 
	public String toString(){
		return "Quantities "+q2.getQuantity()+" and "+q1.getQuantity()+" are not compatible.";
	}
}
