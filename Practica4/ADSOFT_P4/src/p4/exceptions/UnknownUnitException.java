package p4.exceptions;

import p4.punit.IPhysicalUnit;
import p4.punit.PhysicalUnit;

/**
 * Clase que implementa la excepcion cuando se desconoce la unidad, hereda de QuantityException
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class UnknownUnitException extends QuantityException {
	private static final long serialVersionUID = -6623063048010430089L;
	protected PhysicalUnit q1;
	
	/**
	 * Constructor de la excepcion (llama al constructor de QuantityException)
	 * @param q la primera unidad involucrada
	 * @param p este argumento es recibido por cuestion de disenio, no tiene utilidad en esta clase
	 */
	public UnknownUnitException(IPhysicalUnit q, IPhysicalUnit p){
		super(q,null);
	}
	
	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la excepcion
	 */
	
	@Override
	public String toString(){
		return "Unknown unit " + q1;
	}
}
