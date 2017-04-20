package p4.msys.converter;

import p4.exceptions.UnknownUnitException;
import p4.magnitude.IMagnitude;
import p4.msys.si.IMetricSystem;
import p4.punit.IPhysicalUnit;

/**
 * Clase que declara los metodos y la interfaz IMetricSystemConverter, sera utilizada 
 * para implementar convertidores entre diferentes sistemas metricos.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public interface IMetricSystemConverter {
	/**
	 * Metodo que devuelve el sistema metrico del que parte nuestro convertidor.
	 * @return IMetricSystem El sistema metrico fuente, del que partimos
	 */
	IMetricSystem sourceSystem();
	
	/**
	 * Metodo que devuelve el sistema metrico destino de nuestro convertidor.
	 * @return IMetricSystem El sistema metrico objetivo, el destino
	 */
	IMetricSystem targetSystem();
	
	/**
	 * Metodo para transformar una magnitud del sistema fuente a una unidad del sistema destino
	 * @param from Magnitud del sistema fuente
	 * @param to Unidad del sistema destino
	 * @return IMagnitude La Magnitud resultante
	 * @throws UnknownUnitException Cuando hay problemas con la unidad destino
	 */
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;
	/**
	 * Metodo que devuelve un conversor entre el sistema destino y el fuente.
	 * @return IMetricSystemConverter Dicho conversor
	 */
	IMetricSystemConverter reverse();
}
