package p4.punit;

import p4.exceptions.QuantityException;
import p4.msys.si.IMetricSystem;

/**
 * Clase abstracta que implementa la interfaz IPhysicalUnit, con lo cual, da soporte a las 
 * diferentes unidades fisicas. Contiene un sistema metrico, una abreviatura de la unidad
 * fisica y un numero para poder realizar el cambio de unidades.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public abstract class PhysicalUnit implements IPhysicalUnit{
	
	private double measure; // Sirve para la conversión entre tipos 
	private IMetricSystem sys;
	private String abbrev;
	
	/**
	 * Constructor de la clase
	 * @param measure El numero necesario para la conversion entre unidades
	 * @param abbrev La abreviatura de la unidad fisica
	 * @param sys El sistema metrico utilizado
	 */
	public PhysicalUnit(double measure, String abbrev, IMetricSystem sys){
		this.measure = measure;
		this.sys = sys;
		this.abbrev = abbrev;
	}
	
	/**
	 * Metodo que devuelve el numero necesario para la conversion entre unidades
	 * @return double Dicho numero
	 */
	
	public double getMeasure(){
		return this.measure;
	}
	
	/**
	 * Metodo que devuelve si la unidad se puede transformar a otra que se 
	 * le pasa como parametro.
	 * @param u La unidad a la que se quiere llegar
	 * @return true en caso afirmativo, false en caso negativo
	 */
	
	public boolean canTransformTo(IPhysicalUnit u){
		if((this.getQuantity().equals(Quantity.TIEMPO) && u.getQuantity().equals(Quantity.LONGITUD))
				|| (this.getQuantity().equals(Quantity.LONGITUD)) && u.getQuantity().equals(Quantity.TIEMPO))
			return false;
		// Si el conversor no ha sido agregado no podemos transformar de una unidad a otra
		if(this.sys.equals(((PhysicalUnit) u).getSystem()) == false){
			if(sys.getConverter(u.getMetricSystem()) == null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Metodo que devuelve el sistema metrico utilizado
	 * @return IMetricSystem Dicho sistema metrico
	 */
		
	public IMetricSystem getSystem(){
		return this.sys;
	}
	
	/**
	 * 	Metodo que convierte una magnitud a una unidad que se le pasa como parametro
	 * @param d Cantidad a transformar
	 * @param u Unidad fisica que quieres obtener
	 * @return double La cantidad transformada
	 * @throws QuantityException En caso de que las unidades no sean compatibles
	 */
	
	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		if(this.canTransformTo(u) == false)
			throw new QuantityException(this,(PhysicalUnit) u);
			return d*this.getMeasure()/(((PhysicalUnit) u).getMeasure());
	}
	
	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la unidad fisica,
	 * con su abreviatura y su tipo de unidad.
	 */
	@Override
	public String toString(){
		return this.abbrev() + " " + this.getQuantity();
	}
	
	/**
	 * Metodo que devuelve la abreviacion de la unidad fisica
	 * @return String La abreviacion
	 */

	public String abbrev(){
		return abbrev;
	}
	
}
