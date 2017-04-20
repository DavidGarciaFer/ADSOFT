package p4.msys.imperial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;

/**
 * Clase que hereda de MetricSystem y que implementa el sistema metrico imperial
 * referente a la longitud. Tiene patron Singleton, ya que cuando se invoca a
 * esta clase, se puede hacer con SYSTEM (crea la clase en si) o con FOOT, MILE
 * o INCH, que son de tipo LengthUnit, y que se considerarian las unidades del sistema
 * metrico.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class ImperialLengthMetricSystem extends MetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	public static final LengthUnit FOOT = new LengthUnit(1, "ft", SYSTEM);
	public static final LengthUnit MILE =  new LengthUnit(5280, "ml", SYSTEM);
	public static final LengthUnit INCH =  new LengthUnit(1/12, "in", SYSTEM);
	
	/**
	 * Metodo que devuelve la base del sistema metrico, en este caso el pie.
	 * @return IPhysicalUnit La base del sistema metrico
	 */
	@Override
	public IPhysicalUnit base() {
		return FOOT;
	}
	
	/**
	 * Metodo que devuelve la coleccion de unidades del sistema metrico, en este caso
	 * la milla, el pie y la pulgada.
	 * @return La coleccion de las unidades del sistema
	 */

	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(MILE);
		units.add(FOOT);
		units.add(INCH);
		return units;
	}

}
