package p4.msys.si;

import java.util.Collection;

import p4.msys.converter.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;

/**
 * Clase que declara los metodos y la interfaz IMetricSystem, sera utilizada 
 * para implementar sistemas metricos, con una base, una coleccion de unidades
 * y unos convertidores (IMetricSystemConverter).
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public interface IMetricSystem {
	
	/**
	 * Metodo que devuelve la base del sistema metrico.
	 * @return IPhysicalUnit La base del sistema metrico
	 */
	IPhysicalUnit base();
	
	/**
	 * Metodo que devuelve la coleccion de unidades del sistema metrico.
	 * @return Collection<IPhysicalUnit> La coleccion de las unidades del sistema
	 */
	Collection<IPhysicalUnit> units();
	
	/**
	 * Metodo que devuelve el convertidor a la sistema metrico pasado por
	 * argumento (si lo hay).
	 * @param to El sistema metrico deseado en la salida del convertidor
	 * @return IMetricSystemConverter El Convertidor de sistemas metricos deseado, o null si no 
	 * hay ninguno que cumpla nuestra condicion
	 */
	IMetricSystemConverter getConverter(IMetricSystem to);
}
