package p4.magnitude;

import p4.exceptions.QuantityException;
import p4.punit.IPhysicalUnit;

/**
 * Clase que declara los metodos y la interfaz IMagnitude, sera utilizada 
 * para implementar magnitudes, con valor y unidad.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public interface IMagnitude {
	/**
	 * Metodo para sumar a la IMagnitude invocada otra pasada por argumento.
	 * @param m La magnitud con la que debe sumarse la invocacion
	 * @return IMagnitude El resultado de la operacion
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */
	
	IMagnitude add (IMagnitude m) throws QuantityException;
	
	/**
	 * Metodo para restar a la IMagnitude invocada otra pasada por argumento.
	 * @param m La magnitud con la que debe restarse la invocacion
	 * @return IMagnitude El resultado de la operacion
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */
	IMagnitude subs(IMagnitude m) throws QuantityException;
	
	/**
	 * Metodo que transforma una misma magnitud de su unidad a otra, pasada por argumento.
	 * @param c La unidad a la que queremos pasar
	 * @return IMagnitude La magnitud con la unidad cambiada
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
	
	/**
	 * Metodo para conocer la unidad de la IMagnitude
	 * @return IPhysicalUnit La unidad
	 */
	IPhysicalUnit getUnit();
	
	/**
	 * Metodo para conocer el valor de la IMagnitude
	 * @return double El valor de la Magnitude
	 */
	double getValue();
}