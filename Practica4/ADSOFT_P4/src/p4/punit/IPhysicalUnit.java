/**
 * 
 */
package p4.punit;

import p4.exceptions.QuantityException;
import p4.msys.si.IMetricSystem;

/**
 * Clase que declara los metodos y la interfaz IPhysicalUnit, sera utilizada 
 * para implementar unidades fisicas.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public interface IPhysicalUnit {
	/**
	 * Metodo que devuelve si la unidad se puede transformar a otra que se 
	 * le pasa como parametro.
	 * @param u La unidad a la que se quiere llegar
	 * @return true en caso afirmativo, false en caso negativo
	 */
	boolean canTransformTo(IPhysicalUnit u);
	
	/**
	 * 	Metodo que convierte una magnitud a una unidad que se le pasa como parametro
	 * @param d Cantidad a transformar
	 * @param u Unidad fisica que quieres obtener
	 * @return double La cantidad transformada
	 * @throws QuantityException En caso de que las unidades no sean compatibles
	 */
	double transformTo(double d, IPhysicalUnit u) throws QuantityException;
	
	/**
	 * Metodo que devuelve el tipo de unidad que maneja la IPhysicalUnit invocada.
	 * @return Quantity El tipo de unidad
	 */
	Quantity getQuantity();
	
	/**
	 * Metodo que devuelve la abreviacion de la unidad fisica
	 * @return String La abreviacion
	 */
	String abbrev();
	
	/**
	 * Metodo que devuelve el sistema metrico utilizado
	 * @return IMetricSystem Dicho sistema metrico
	 */
	IMetricSystem getMetricSystem(); 
}
