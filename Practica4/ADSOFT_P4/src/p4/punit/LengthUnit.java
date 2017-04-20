package p4.punit;

import p4.msys.si.IMetricSystem;

/**
 * Clase que hereda de PhysicalUnit, en este caso implementa una unidad
 * de longitud.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class LengthUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.LONGITUD;
	
	/**
	 * Constructor de la clase
	 * @param measure El numero necesario para la conversion entre unidades
	 * @param ab La abreviatura de la unidad fisica
	 * @param sys El sistema metrico utilizado
	 */
	public LengthUnit(double measure, String ab, IMetricSystem sys) {
		super(measure, ab, sys);
	}
	
	/**
	 * Metodo que devuelve el tipo de unidad que maneja la IPhysicalUnit invocada.
	 * @return Quantity El tipo de unidad, en este caso LONGITUD
	 */
	public Quantity getQuantity(){
		return q;
	}

	/**
	 * Metodo que devuelve el sistema metrico utilizado
	 * @return IMetricSystem Dicho sistema metrico
	 */
	
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}

	
}