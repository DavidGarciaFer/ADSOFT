package p4.exceptions;

import p4.punit.IPhysicalUnit;

/**
 * Clase que implementa la excepcion cuando dos unidades a transformar no corresponden 
 * con las del conversor invocado, hereda de UnkownUnitException
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class NotMatchingException extends UnknownUnitException{

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la excepcion (llamando al constructor de UnknowUnitException)
	 * @param q1 la primera unidad implicada
	 * @param q2 la segunda unidad implicada
	 */
	
	public NotMatchingException(IPhysicalUnit q1, IPhysicalUnit q2) {
		super(q1, q2);		
	}

	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la excepcion
	 */
	public String toString(){
		return "Las unidades "+q1+" y "+q2+" a transformar no corresponden con las del conversor invocado.";
	}


}
