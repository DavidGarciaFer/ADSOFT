package p4.msys.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;

/**
 * Clase que hereda de MetricSystem y que implementa el sistema metrico internacional
 * referente a las longitudes. Tiene patron Singleton, ya que cuando se invoca a
 * esta clase, se puede hacer con SYSTEM (crea la clase en si) o con METER, KILOMETER
 * o MILIMETER, que son de tipo LengthUnit, y que se considerarian las unidades del sistema
 * metrico.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class SiLengthMetricSystem extends MetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	public static final LengthUnit METER = new LengthUnit(1, "m", SYSTEM);
	public static final LengthUnit KILOMETER =  new LengthUnit(1000, "km", SYSTEM);
	public static final LengthUnit MILIMETER =  new LengthUnit(0.001, "mm", SYSTEM);
	
	/**
	 * Metodo que devuelve la base del sistema metrico, en este caso el metro.
	 * @return IPhysicalUnit La base del sistema metrico
	 */
	
	@Override
	public IPhysicalUnit base() {
		return METER;
	}

	/**
	 * Metodo que devuelve la coleccion de unidades del sistema metrico, en este caso
	 * el km, metro y mm.
	 * @return La coleccion de las unidades del sistema
	 */
	
	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(KILOMETER);
		units.add(METER);
		units.add(MILIMETER);
		return units;
	}

}
