package p4.msys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.converter.IMetricSystemConverter;
import p4.msys.si.IMetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.Quantity;

/**
 * Clase abstracta que implementa la interfaz IMetricSystem, con lo cual, da soporte a los
 * diferentes sistemas metricos. Esta compuesto por un tipo de cantidad (Quantity)
 * y una lista de converters.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public abstract class MetricSystem implements IMetricSystem {
	

	protected Quantity quantity;
	protected static ArrayList<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();

	/**
	 * Metodo que devuelve la base del sistema metrico.
	 * @return IPhysicalUnit La base del sistema metrico
	 */
	
	@Override
	public abstract IPhysicalUnit base();

	/**
	 * Metodo que devuelve la coleccion de unidades del sistema metrico.
	 * @return La coleccion de las unidades del sistema
	 */
	
	@Override
	public abstract Collection<IPhysicalUnit> units();
	
	/**
	 * Metodo que devuelve el tipo de cantidad que almacena el sistema metrico.
	 * @return Quantity El tipo de cantidad del sistema metrico
	 */
	public Quantity getQuantity() {
		return this.quantity;
	}

	/**
	 * Metodo que devuelve la lista de todos los converters que contiene el sistema metrico.
	 * @return La lista de los converters
	 */
	
	public List<IMetricSystemConverter> getConverters(){
		return converters;
	}
	
	/**
	 * Metodo para aniadir un convertidor (IMetricSystemConverter) al sistema metrico.
	 * @param ic El convertidor de sistemas metricos a aniadir a la lista
	 */
	
	public static void registerConverter(IMetricSystemConverter ic){
		if (converters.contains(ic) == false){
			converters.add(ic);
			((MetricSystem) ic.targetSystem()).getConverters().add(ic.reverse());
		}
	}
	
	/**
	 * Metodo que devuelve el convertidor a la sistema metrico pasado por
	 * argumento (si lo hay).
	 * @param to El sistema metrico deseado en la salida del convertidor
	 * @return IMetricSystemConverter El Convertidor de sistemas metricos deseado, o null si no 
	 * hay ninguno que cumpla nuestra condicion
	 */
	
	public IMetricSystemConverter getConverter(IMetricSystem to) {
		for (IMetricSystemConverter imc: converters){
			if(imc.targetSystem().equals(to))
				return imc;
		}
		return null;
	}

}
