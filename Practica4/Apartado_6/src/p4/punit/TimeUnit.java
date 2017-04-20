package p4.punit;

import p4.msys.si.IMetricSystem;

/**
 * Clase que hereda de PhysicalUnit, en este caso implementa una unidad
 * de tiempo.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class TimeUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.TIEMPO;
	
	/**
	 * Constructor de la clase
	 * @param measure El numero necesario para la conversion entre unidades
	 * @param ab La abreviatura de la unidad fisica
	 * @param sys El sistema metrico utilizado
	 */
	
	public TimeUnit(double measure, String ab, IMetricSystem sys) {
		super(measure,ab, sys);
	}
	
	/**
	 * Metodo que devuelve el tipo de unidad que maneja la IPhysicalUnit invocada.
	 * @return Quantity El tipo de unidad, en este caso TIEMPO
	 */
	public Quantity getQuantity(){
		return TimeUnit.q;
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
