package p4.punit.composite;

import p4.punit.IPhysicalUnit;

/**
 * Interfaz con los metodos necesarios para implementar las 
 * unidades compuestas.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public interface ICompositeUnit extends IPhysicalUnit{
	
	/**
	 * Devuelve la operacion que se realiza 
	 * @return Un tipo Operator (division o multiplicacion)
	 */
	
	Operator getOperator();
	
	/**
	 * Devuelve la primera unidad de la composicion 
	 * @return Un objeto que implemente la interfaz IPhysicalUnit
	 */
	
	IPhysicalUnit getLeftUnit();
	
	/**
	 * Devuelve la segunda unidad de la composicion 
	 * @return Un objeto que implemente la interfaz IPhysicalUnit
	 */
	
	IPhysicalUnit getRightUnit();
}

