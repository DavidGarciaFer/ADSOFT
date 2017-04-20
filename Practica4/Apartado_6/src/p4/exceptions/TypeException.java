package p4.exceptions;

import p4.punit.IPhysicalUnit;

/**
 * Clase que implementa la excepcion cuando no se puede transformar de una unidad a otra
 * debido al tipo, hereda de QuantityException
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class TypeException extends QuantityException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de la excepcion (llamando al constructor de QuantityException)
	 * @param q1 la primera unidad involucrada
	 * @param q2 la segunda unidad involucrada
	 */
	
	public TypeException(IPhysicalUnit q1, IPhysicalUnit q2) {
		super(q1, q2);
	}
	
	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la excepcion
	 */

	@Override
	public String toString(){
		return "Cannot transform "+q1+" to "+q2;
	}
	
}
